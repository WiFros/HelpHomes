package com.user.util;
import lombok.extern.slf4j.Slf4j;

import java.security.Key;
import java.sql.Date;
import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.user.vo.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;



@Component
@Slf4j
public class JwtUtil {
    private final Key key;
    private final long accessTokenExpiresIn;

    public JwtUtil(@Value("${jwt.secret}") String secretKey, @Value("${jwt.expiration}") long accessTokenExpiresIn) {
        this.key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        this.accessTokenExpiresIn = accessTokenExpiresIn;
    }

    /*
     *  access token 생성
     * @param user
     * @return jwt token String
     */
    public String createAccessToken(User user){
        return ceateToken(user, accessTokenExpiresIn);
    }
    /*
     * jwt token 생성
     */
    private String ceateToken(User user, long expireTime){
        Claims claims = Jwts.claims();
        claims.put("id",user.getId());
        claims.put("email",user.getEmail());
        claims.put("name",user.getName());
        claims.put("role",user.getRole());

        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime tokenValidity = now.plusSeconds(expireTime);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(Date.from(now.toInstant()))
                .setExpiration(Date.from(tokenValidity.toInstant()))
                .signWith(key,SignatureAlgorithm.HS256)
                .compact();
    }

    public String getUserEmailFromToken(String token) {
        Claims claims = parseClaims(token);
        return claims.getSubject();
    }
    /*
     * jwt token 검증
     * @param token
     * @return jwt token String
     */
    public Claims parseClaims(String token){
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }

    public String getRoleFromToken(String token) {
        Claims claims = parseClaims(token);
        return (String) claims.get("role");
    }
    /*
     * jwt token 유효성 검사
     * @param token
     * @return jwt token String
     */

    public boolean validateToken(String token){
        try{
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        }catch(io.jsonwebtoken.security.SignatureException | MalformedJwtException e){
            log.error("Invalid JWT signature -> Message: {} ", e);
        }catch(ExpiredJwtException e){
            log.error("Expired JWT token -> Message: {}", e);
        }catch(UnsupportedJwtException e){
            log.error("Unsupported JWT token -> Message: {}", e);
        }catch(IllegalArgumentException e){
            log.error("JWT claims string is empty -> Message: {}", e);
        }

        return false;
    }
}