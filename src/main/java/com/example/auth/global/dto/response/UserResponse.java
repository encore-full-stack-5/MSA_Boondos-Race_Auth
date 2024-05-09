package com.example.auth.global.dto.response;

import java.time.LocalDate;

public record UserResponse (
        String id,
        String email,
        String nickname,
        LocalDate birthDay,
        String gender
){
}
