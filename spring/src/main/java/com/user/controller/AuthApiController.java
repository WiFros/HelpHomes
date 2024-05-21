package com.user.controller;

import com.user.service.AuthService;
import com.user.service.CustomUserDetailsService;
import com.user.vo.LoginRequestDto;
import com.user.vo.SignupRequestDto;

import com.user.vo.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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
    public ResponseEntity<Void> signup(@Valid @RequestBody SignupRequestDto signupRequestDto) {
        authService.signup(signupRequestDto);
        return ResponseEntity.ok().build();
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