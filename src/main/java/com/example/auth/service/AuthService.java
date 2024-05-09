package com.example.auth.service;

import com.example.auth.global.dto.response.TokenResponse;

import java.util.UUID;

public interface AuthService {
    TokenResponse passToken(String token);
    UUID parseToken(String token);
}
