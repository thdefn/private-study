package com.haden.prjforstd.effectivejava.blockInstantiation;

public class PatternUtil {

    //잘못된 예제

    /*모종의 이유로 해당 이메일 체크하는 패턴 자체가 필요해졌다면?
    PATTERN은 퍼블릭으로 열면 좋겠지만 그러지 못하고 getPattern 메서드를 생성한 상황

    getPattern 메서드를 만들었지만 PatternUtil 인스턴스를 생성해야 하네? 왜 생성을 못하지?
    PatternUtil을 staticFactoryMethod로 만들어 가져오는 식으로 변형 가능함
    */

    private static final String PATTERN = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";

    private PatternUtil(){};

    public static boolean isEmailValid(String email){
        return email.matches(PATTERN);
    }

    public String getPattern(){
        return PATTERN;
    }
}
