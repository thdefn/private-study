package com.haden.prjforstd;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenRefreshForm {
    private String username;
    private String refreshToken;
}
