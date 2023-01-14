package com.haden.prjforstd.effectivejava.security;

import com.haden.prjforstd.demo.domain.entity.ResponseCode;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = parseJwt(request);
        try {
            if(token != null && jwtUtil.isTokenValid(token)){
                String username = jwtUtil.getUsername(token);
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities()); //UsernamePasswordAuthenticationToken을 생성하는 부분
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        catch (SecurityException | MalformedJwtException e){
            request.setAttribute("excepetion", ResponseCode.WRONG_TYPE_TOKEN.getCode());
        }catch (ExpiredJwtException e){
            request.setAttribute("exception", ResponseCode.EXPIRED_TOKEN.getCode());
        }catch (UnsupportedJwtException e){
            request.setAttribute("exception",ResponseCode.UNSUPPORTED_TOKEN.getCode());
        }catch (IllegalArgumentException e){
            request.setAttribute("exception",ResponseCode.WRONG_TOKEN.getCode());
        }
        filterChain.doFilter(request, response);
    }

    private String parseJwt(HttpServletRequest request){
        String headerAuth = request.getHeader("Authorization");
        if(StringUtils.hasText(headerAuth)&&headerAuth.startsWith("Bearer")){
            return headerAuth.substring(7);
        }
        return null;
    }
}
