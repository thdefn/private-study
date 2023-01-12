package com.haden.prjforstd.demo.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenRefreshForm {
    private String username;
    private String refreshToken;
}
