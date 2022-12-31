package com.haden.prjforstd;

public class ReadTokenDto {
    private String refreshToken;

    public static ReadTokenDto of(String refreshToken){
        ReadTokenDto dto = new ReadTokenDto();
        dto.refreshToken = refreshToken;
        return dto;
    }
}
