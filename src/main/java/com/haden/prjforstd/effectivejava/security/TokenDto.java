package com.haden.prjforstd.effectivejava.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TokenDto {
    private String accessToken;
    private String refreshToken;
    private Long accessTokenExpireIn;

    public static TokenDto of(String accessToken, String refreshToken, Long accessTokenExpireIn){
        TokenDto tokenDto = new TokenDto();
        tokenDto.accessToken = accessToken;
        tokenDto.refreshToken = refreshToken;
        tokenDto.accessTokenExpireIn = accessTokenExpireIn;
        return tokenDto;
    }
}
