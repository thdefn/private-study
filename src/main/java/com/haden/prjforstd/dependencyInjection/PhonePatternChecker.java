package com.haden.prjforstd.dependencyInjection;

public class PhonePatternChecker {
    // Constructor Injection 생성자 주입
    // CI는 Test, Flexibility를 높일 수 있다

    /*
    고정해 놓은 값에 비해 훨씬 유연해진 class : pattern Injection 가능함
    Test code 작성 시 인젝션 하기도 편리함
    */

    private final String pattern;

    public PhonePatternChecker(String pattern) {
        this.pattern = pattern;
    }

    public boolean isValid(String phone){
        return Boolean.TRUE;
    }
}
