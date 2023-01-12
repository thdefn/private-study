package com.haden.prjforstd.security;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    @Value("${haden.jwtSecret}")
    private String jwtSecret;

    private String TOKEN_TYPE = "Bearer ";
    private final long ACCESS_TOKEN_VALID_PERIOD = 1000L*60*30;
    private final long REFRESH_TOKEN_VALID_PERIOD = 1000L*60*60*24*7;

    public TokenDto generateToken(String username){
        Date now = new Date();
        Date accessTokenExpireIn = new Date(now.getTime() + ACCESS_TOKEN_VALID_PERIOD);

        String accessToken = Jwts.builder()
                .setClaims(Jwts.claims().setSubject(username))
                .setIssuedAt(now)
                .setExpiration(accessTokenExpireIn)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();


        String refreshToken = Jwts.builder()
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + REFRESH_TOKEN_VALID_PERIOD))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();

        return TokenDto.of(accessToken, refreshToken, accessTokenExpireIn.getTime());
    }

    public String getUsername(String token){
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean isTokenValid(String token){
        try{
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        }catch (JwtException e){
            e.printStackTrace();
        }
        return false;
    }


}
