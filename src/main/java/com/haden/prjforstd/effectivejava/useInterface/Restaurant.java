package com.haden.prjforstd.effectivejava.useInterface;

public class Restaurant extends Delivery implements Delibariable, Packable {
    //만약 배달 주문앱ㅂ에 포장 주문의 기능이 추가된다면? 하지만 한 클래스밖에는 상속이 불가능함 > interface로 만들면 되지~
    // 클래스의 확장은 하나만 가능하기 때문에 생기는 문제
    @Override
    public void info() {
        super.info();
    }
}
