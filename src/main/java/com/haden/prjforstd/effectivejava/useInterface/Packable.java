package com.haden.prjforstd.effectivejava.useInterface;

public interface Packable {
    // 인터페이스에는 메소드의 실체를 가질 수 없다 라는 과거의 문제점
    // 실체가 있는 메소드 : interface의 default method
    default void packOrder(){
        System.out.println("포장 주문이 들어왔습니다");
    }
}
