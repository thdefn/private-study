package com.haden.prjforstd.finalize;

public class Item8 {
    /*
    finalize() 는 java9에서 deprecated
    GC가 일어날때 "call finalize"를 콘솔에 같이 출력해
    GC가 일어날 때 해당 메서드가 실행됨 근데 GC가 언제 일어날지 아무도 모름
    */

    //finalize()는 언제 쓸까? > 자원 관점에서 회수가 될 거라고 가정하지만
    // 혹시나 모를 오류때문에 회수가 되지 않을 때 회수를 구현 : 일종의 걸음망 역할
    // 니가 닫았을거라고 생각하지만 혹시 모르니~

    private boolean closed;

    public void close() throws Exception{
        //객체를 닫는다
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("call finalize");
        super.finalize();

        if(!this.closed){
            close();
        }
    }
}
