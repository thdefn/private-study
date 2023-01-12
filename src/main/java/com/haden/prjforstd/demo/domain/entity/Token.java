package com.haden.prjforstd.demo.domain.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;

@Getter
@Builder
@RedisHash("Token")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Indexed
    private String username;

    private String tokenValue;

    private String updateAt;

    public static Token of(String username, String tokenValue){
        return Token.builder()
                .username(username)
                .tokenValue(tokenValue)
                .updateAt(LocalDateTime.now().toString())
                .build();
    }
}
