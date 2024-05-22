package com.user.controller;

import com.user.service.AuthService;
import com.user.service.CustomUserDetailsService;
import com.user.vo.LoginRequestDto;
import com.user.vo.SignupRequestDto;

import com.user.vo.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "인증 API")
@Slf4j
public class AuthApiController {
    private final AuthService authService;
    private final CustomUserDetailsService customUserDetailsService;

    public AuthApiController(AuthService authService, CustomUserDetailsService customUserDetailsService) {
        this.authService = authService;
        this.customUserDetailsService = customUserDetailsService;
    }

    @PostMapping("/login")
    @Operation(summary = "로그인")
    public ResponseEntity<String> login(@Valid @RequestBody LoginRequestDto loginRequestDto) {
        String token = authService.login(loginRequestDto);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/signup")
    @Operation(summary = "회원가입")
    public ResponseEntity<String> signup(@Valid @RequestBody SignupRequestDto signupRequestDto) {
        try {
            log.info("Received signup data: {}", signupRequestDto);
            authService.signup(signupRequestDto);
            return ResponseEntity.ok("회원가입 성공");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버 오류가 발생했습니다.");
        }
    }
    

    @PostMapping("/me")
    @Operation(summary = "현재 사용자 정보")
    public ResponseEntity<User> getCurrentUser(@AuthenticationPrincipal UserDetails userDetails) {
        System.out.println("userDetails: " + userDetails); // 디버그 로그 추가
        if (userDetails != null) {
            System.out.println("user : " + userDetails.getUsername());
            User user = customUserDetailsService.getUser(userDetails.getUsername());
            return ResponseEntity.ok(user);
        } else {
            System.out.println("userDetails is null");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}