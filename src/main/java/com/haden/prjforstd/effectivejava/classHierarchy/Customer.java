package com.haden.prjforstd.effectivejava.classHierarchy;

public class Customer extends ImporvedUser{
    @Override
    boolean order(String info) {
        // 카드로 결제 후 주문 수락
        return false;
    }
}
