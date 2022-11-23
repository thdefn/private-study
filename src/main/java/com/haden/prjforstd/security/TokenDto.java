package com.haden.prjforstd.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TokenDto {
    private final String accessToken;
    private final String refreshToken;
    private final Long accessTokenExpireIn;
}
