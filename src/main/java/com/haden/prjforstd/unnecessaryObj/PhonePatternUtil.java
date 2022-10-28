package com.haden.prjforstd.unnecessaryObj;

import antlr.CharScanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhonePatternUtil {
    private final String pattern;
    private static final Pattern PHONE = Pattern.compile("^01(?:0|1|[6-9])-(?:\\\\d{3}|\\\\d{4})-\\\\d{4}$\n");

    public PhonePatternUtil(String pattern) {
        this.pattern = pattern;
    }

    // 유틸 클래스에서 참 거짓을 판별하는 상황에서 Boolean을 Boxing type으로 사용할 이유가 전혀 없음
    public boolean isValid(String phone){
        //..
        return true;
    }

    //주의해야 할 내장 method
    public boolean isPhoneVaild(String phone){
        //String.java의 matches 호출
        //validation을 할때마 새로운 패턴 인스턴스를 계속 만든다
        return phone.matches("^01(?:0|1|[6-9])-(?:\\\\d{3}|\\\\d{4})-\\\\d{4}$\n");
    }

    //Stirng.java 내장함수 matches Patter.matches를 호출한다
    public boolean stringmatches(String expr, String string){
        return Pattern.matches(expr, string);
    }

    //Pattern.java 내장함수 matches
    public static boolean matches(String regex, CharSequence input){
        // 정규 표현식을 받아 컴파일을 해서 패턴을 하나 만들고
        Pattern p = Pattern.compile(regex);
        // 패턴을 가지고 매치가 되는지 판단
        Matcher m = p.matcher(input);
        return m.matches();
    }

    //아래와 같이 수정하는 것이 바람직함
    //미리 Pattern 변수를 compile
    public boolean isPhone2Vaild(String phone){
        return PHONE.matcher(phone).matches();
    }
}
