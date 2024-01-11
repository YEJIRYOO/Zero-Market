package com.likelion.zeroMarket.dto;

import com.likelion.zeroMarket.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserSignUpRequestDto {
    private String id;
    private String password;
    private String bank;
    private String account;
    private String nickname;
}
