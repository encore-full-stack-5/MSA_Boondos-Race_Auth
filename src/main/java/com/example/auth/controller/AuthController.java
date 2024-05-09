package com.example.auth.controller;

import com.example.auth.global.dto.response.TokenResponse;
import com.example.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @GetMapping
    public TokenResponse kickToken(@RequestParam(name = "token") String token) {
        return authService.passToken(token);
    }

    @GetMapping("/parse")
    public UUID parseToken(@RequestParam(name = "token") String token) {
        return authService.parseToken(token);
    }
}
