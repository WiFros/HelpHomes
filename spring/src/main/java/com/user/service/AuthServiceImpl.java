package com.user.service;

import com.user.vo.LoginRequestDto;
import com.user.vo.SignupRequestDto;
import com.user.mapper.UserMapper;
import com.user.util.JwtUtil;
import com.user.vo.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(UserMapper userMapper, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public String login(LoginRequestDto loginRequestDto) {
        try {
            User user = userMapper.findByEmail(loginRequestDto.getEmail());

            if (user == null) {
                throw new IllegalArgumentException("사용자를 찾을 수 없습니다.");
            }

            if (!passwordEncoder.matches(loginRequestDto.getPassword(), user.getPassword())) {
                throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
            }

            return jwtUtil.createAccessToken(user);
        } catch (SQLException e) {
            throw new RuntimeException("로그인 중 오류가 발생했습니다.", e);
        }
    }

    @Override
    public void signup(SignupRequestDto signupRequestDto) {
        try {
            User existingUser = userMapper.findByName(signupRequestDto.getUsername());

            if (existingUser != null) {
                throw new IllegalArgumentException("이미 존재하는 사용자 이름입니다.");
            }

            User user = new User();
            user.setName(signupRequestDto.getUsername());
            String encodedPassword = passwordEncoder.encode(signupRequestDto.getPassword());
            user.setPassword(encodedPassword);
            user.setEmail(signupRequestDto.getEmail());
            user.setAddress(signupRequestDto.getAddress());
            user.setPhone(signupRequestDto.getPhone());
            user.setRole("user"); // 디폴트 role 설정
            user.setJoinDate(new Timestamp(new Date().getTime())); // 현재 날짜를 가입 날짜로 설정

            userMapper.register(user);
        } catch (SQLException e) {
            throw new RuntimeException("회원가입 중 오류가 발생했습니다.", e);
        }
    }
}