package com.haden.prjforstd.effectivejava.inherit;

public class Super {
    // 상속을 잘못 할 시에 문제점 : Constructor는 직간접적으로 override 가능한 method를 call하면 안된다
    public Super() {
        overrideMe();
    }

    public void overrideMe(){
    }
}
