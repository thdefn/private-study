package com.haden.prjforstd.finalize;

public class MainApplication {

    //call finalize가 실행되지 않는 것을 확인할 수 있음 > finalize()가 안되는구나
    private void run(){
        //run의 메서드 끝나면 item8 참조가 끊어짐 > item8은 GC의 대상이 됨
        Item8 item8 = new Item8();
    }

    public static void main(String[] args){
        MainApplication mainApplication = new MainApplication();
        mainApplication.run();
    }
}
