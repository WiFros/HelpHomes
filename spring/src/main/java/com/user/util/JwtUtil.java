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
        this.key = Keys.hmacShaKeyFor(secretKey.getBytes());
        this.accessTokenExpiresIn = accessTokenExpiresIn;
    }

    public String createAccessToken(User user) {
        return createToken(user, accessTokenExpiresIn);
    }

    private String createToken(User user, long expireTime) {
        Claims claims = Jwts.claims();
        claims.put("id", user.getId());
        claims.put("email", user.getEmail());
        claims.put("name", user.getName());
        claims.put("role", user.getRole());

        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime tokenValidity = now.plusSeconds(expireTime);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getEmail())  // subject 설정
                .setIssuedAt(Date.from(now.toInstant()))
                .setExpiration(Date.from(tokenValidity.toInstant()))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String getEmailFromToken(String token) {
        Claims claims = parseClaims(token);
        return claims.get("email", String.class);
    }

    public String getIdFromToken(String token) {
        Claims claims = parseClaims(token);
        return claims.get("id", String.class);
    }

    public Claims parseClaims(String token) {
        try {
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
        } catch (Exception e) {
            log.error("Failed to parse JWT token: {}", e.getMessage());
            throw e;
        }
    }

    public String getRoleFromToken(String token) {
        Claims claims = parseClaims(token);
        return (String) claims.get("role");
    }

    public boolean validateToken(String token) {
        if (token == null || token.split("\\.").length != 3) {
            log.error("Invalid JWT token format");
            return false;
        }

        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            log.info("JWT token is valid");
            return true;
        } catch (io.jsonwebtoken.security.SignatureException | MalformedJwtException e) {
            log.error("Invalid JWT signature -> Message: {} ", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("Expired JWT token -> Message: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("Unsupported JWT token -> Message: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty -> Message: {}", e.getMessage());
        }

        return false;
    }
}
