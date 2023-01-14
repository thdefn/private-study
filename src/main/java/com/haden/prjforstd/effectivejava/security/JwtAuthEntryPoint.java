package com.haden.prjforstd.effectivejava.security;

import com.haden.prjforstd.demo.domain.entity.ResponseCode;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthEntryPoint implements AuthenticationEntryPoint {
    // 인증되지 않은 사용자가 secured HTTP resource를 요청할 때 트리거됨
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        String exceptionCode = (String) request.getAttribute("exception");

        if(exceptionCode == null){
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        } else if (exceptionCode.equals(ResponseCode.UNSUPPORTED_TOKEN.getCode())) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, ResponseCode.UNSUPPORTED_TOKEN.getMessage());
        } else if (exceptionCode.equals(ResponseCode.EXPIRED_TOKEN.getCode())) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, ResponseCode.EXPIRED_TOKEN.getMessage());
        } else if (exceptionCode.equals(ResponseCode.WRONG_TYPE_TOKEN.getCode())) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, ResponseCode.WRONG_TYPE_TOKEN.getMessage());
        } else if (exceptionCode.equals(ResponseCode.WRONG_TOKEN.getCode())) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, ResponseCode.WRONG_TOKEN.getMessage());
        }

    }
}
