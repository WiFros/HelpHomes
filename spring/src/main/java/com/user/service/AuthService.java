package com.user.service;

import com.user.vo.LoginRequestDto;
import com.user.vo.SignupRequestDto;

public interface AuthService {
    String login(LoginRequestDto loginRequestDto);

    void signup(SignupRequestDto signupRequestDto);
}