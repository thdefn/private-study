package com.haden.prjforstd.effectivejava.singleton;

public enum AnotherSpeaker {
    //책에서 권장하는 방식이나 enum의 의도와 맞지 않아 보기에 부자연스러움
    //enum 외에 클래스를 상속해야 할때 사용이불가능함 > 실무에서 사용하지 않음
    //어떤건 enum? 어떤건 class? : 혼란스러움
    INSTANCE;
    private String message;

    public AnotherSpeaker getInstance(){
        return INSTANCE;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
