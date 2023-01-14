package com.haden.prjforstd.effectivejava.useInterface;

public abstract class AbstractVending implements Invending{
    // 모든 공통 구현을 정의하는 추상 클래스를 만듭니다
    // Invending의 구현체로서 공통되는 구현을 함
    @Override
    public void start() {
        System.out.println("Start Vending Machine");
    }

    @Override
    public void stop() {
        System.out.println("Stop Vending Machine");
    }

    @Override
    public void process() {
        start();
        chooseProduct();
        stop();
    }
}
