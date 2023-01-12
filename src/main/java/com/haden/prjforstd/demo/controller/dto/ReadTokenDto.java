package com.haden.prjforstd.demo.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReadTokenDto {
    private String refreshToken;

    public static ReadTokenDto of(String refreshToken){
        ReadTokenDto dto = new ReadTokenDto();
        dto.refreshToken = refreshToken;
        return dto;
    }
}
