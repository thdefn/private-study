package com.haden.prjforstd.demo.domain.entity;

import com.haden.prjforstd.demo.controller.dto.SignupForm;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity(name = "TUSER")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRoleEnum role;

    public static User from(SignupForm form, String password, UserRoleEnum role){
        User user = new User();
        user.username = form.getUsername();
        user.password = password;
        user.email = form.getEmail();
        user.role = role;
        return user;
    }

}
