package com.haden.prjforstd.demo.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupForm {
    private String username;
    private String password;
    private String email;
    private String adminToken= "";
}
