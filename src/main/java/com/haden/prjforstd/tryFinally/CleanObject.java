package com.haden.prjforstd.tryFinally;

import jdk.internal.ref.Cleaner;
import jdk.internal.ref.CleanerImpl;

public class CleanObject implements AutoCloseable{

    //finalizer의 역할을 하는 게 클리너임
    //Clean이 실패해서 GC의 기회강 없어져도 AutoClosable 을 통해 이를 보완 가능
   /* private static final Cleaner cleaner = Cleaner.create();
    private static class CleanData implements Runnable{
        @Override
        public void run() {

        }
    }

    private final CleanData cleanData;
    private final Cleaner.Cleanable cleanable;

    public CleanObject() {
        this.cleanData = new CleanData();
        this.cleanable = cleaner.register(this,cleanData);
    }*/

    @Override
    public void close() throws Exception {
        //cleanable.clean();
    }
}
