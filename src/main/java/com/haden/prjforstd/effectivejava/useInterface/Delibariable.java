package com.haden.prjforstd.effectivejava.useInterface;

public interface Delibariable {
    default void deliveryOrder(){
        System.out.println("배달주문이 들어왔습니다");
    }
}
