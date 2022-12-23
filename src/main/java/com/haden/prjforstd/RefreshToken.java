package com.haden.prjforstd;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String tokenValue;

    @NotNull
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public static RefreshToken of(String tokenValue, User user){
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.tokenValue = tokenValue;
        refreshToken.user = user;
        return refreshToken;
    }

    public RefreshToken updateToken(String tokenValue){
        this.tokenValue = tokenValue;
        return this;
    }
}
