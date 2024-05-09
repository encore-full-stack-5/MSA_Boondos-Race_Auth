package com.example.auth.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthServiceImplTest {
    @Autowired
    private AuthService authService;

    @Test
    void parseToken() {
        String token = "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiIwMTFmNzkzNy1hYzA4LTRkNmItOWNiMS0wYzhmNjYzOWNmOTciLCJleHAiOjE3MTUzMzU1MTh9.mDi4gU0c_rfj0KPyyDaZhfk-E0Qq300VfpiMk6biFDW95oDXQbMBW2g1LHc5aAeo";

        UUID uuid = authService.parseToken(token);

        assertNotNull(uuid);
        System.out.println(uuid);
    }
}