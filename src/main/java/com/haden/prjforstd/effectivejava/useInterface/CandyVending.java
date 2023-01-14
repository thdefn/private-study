package com.haden.prjforstd.effectivejava.useInterface;

public class CandyVending implements Invending{
    //그런 다음 각 하위 클래스에 대해 위임자 클래스를 구현합니다.
    //그리고 그 위임자를 사용하여 호출을 AbstractVending으로 전달합니다
    AbstractVendingDelegator delegator = new AbstractVendingDelegator();

    @Override
    public void start() {
        delegator.start();
    }

    @Override
    public void chooseProduct() {
        delegator.chooseProduct();
    }

    @Override
    public void stop() {
        delegator.stop();
    }

    @Override
    public void process() {
        delegator.process();
    }

    // 공통되지 않아서 추상 클래스에서 구현하지 않은 choosProduct 구현
    private class AbstractVendingDelegator extends AbstractVending{
        @Override
        public void chooseProduct() {
            System.out.println("Produce diiferent candies");
            System.out.println("Choose a type of candy");
            System.out.println("pay for candy");
            System.out.println("collect candy");
        }
    }
}
