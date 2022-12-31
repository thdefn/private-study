package com.haden.prjforstd;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ResponseCode {
    WRONG_TYPE_TOKEN(HttpStatus.BAD_REQUEST, "400_1", "토큰 타입이 잘못되었습니다"),
    EXPIRED_TOKEN(HttpStatus.BAD_REQUEST, "400_2", "토큰이 만료되었습니다"),
    UNSUPPORTED_TOKEN(HttpStatus.BAD_REQUEST, "400_3","지원하지 않는 토큰입니다"),
    WRONG_TOKEN(HttpStatus.BAD_REQUEST, "400_4", "토큰이 잘못되었습니다")
    ;
    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    ResponseCode(HttpStatus httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }
}
