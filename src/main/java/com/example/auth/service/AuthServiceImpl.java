package com.example.auth.service;

import com.example.auth.global.dto.request.TeamRequest;
import com.example.auth.global.dto.response.TokenResponse;
import com.example.auth.global.dto.response.UserResponse;
import com.example.auth.global.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
    private final RestTemplate restTemplate;
    private final JwtUtil jwtUtil;

    @Override
    public TokenResponse passToken(String token) {
        TeamRequest request = new TeamRequest("이수진", "1203");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization" ,"jwt " + token);
        HttpEntity<TeamRequest> requestEntity = new HttpEntity<>(
                request,
                httpHeaders
        );

        UserResponse res = restTemplate
                .postForEntity(
                        "http://192.168.0.12:8080/api/v1/auth/token"
                        ,requestEntity
                        ,UserResponse.class
                ).getBody();
        return new TokenResponse(jwtUtil.generateToken(res.id()));
    }

    @Override
    public UUID parseToken(String token) {
        return UUID.fromString(jwtUtil.getByUUIDFromTokenAndValidate(token));
    }
}
