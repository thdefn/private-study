package com.haden.prjforstd.useInterface;

public class DrinkVending implements Invending{

    /*
    Benefits of Skeletal Implementation
    1.A subclass can extend other classes, like DrinkVending.
    2.Get rid of duplicate code by delegating calls to the Abstract class.
    3.If a subclass needs a new implementation of interface, it can do so.

    Conclusion
    When your interface has some common methods, always create an Abstract class.
    You can then use subclasses a delegator. Always try to use skeletal implementation.
    * */

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

    private class AbstractVendingDelegator extends AbstractVending{
        @Override
        public void chooseProduct() {
            System.out.println("Produce diiferent soft drinks");
            System.out.println("Choose a type of soft drinks");
            System.out.println("pay for drinks");
            System.out.println("collect drinks");
        }
    }
}
