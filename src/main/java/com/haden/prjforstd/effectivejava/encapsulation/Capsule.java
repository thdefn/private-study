package com.haden.prjforstd.effectivejava.encapsulation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Capsule {

    /*
    * 배열의 문제를 해결하는 방법
    * 1. 배열을 private으로 만들고 불변 리스트를 추가함
    *  */
    private static final PAGE[] PAGE_INFO = {};

    //일종의 view 객체 : 수정 불가능 원본 바뀔 경우 VALUES도 같이 바뀜
    public static final List<PAGE> VALUES = Collections.unmodifiableList(Arrays.asList(PAGE_INFO));

    private String name;
    private int cost;

    public float getDolorCost(){
        return 1050/cost;
    }

    public int getWonCost(){
        return cost;
    }

    public class PAGE{

    }

    // 2. 배열을 private을 두고 복사본을 반환하는 public  method
    // 원본 바뀔 경우 변경되지 않음
    // PAGE_INFO 가  page1 / 2 / 3 / 4 을 갖고 있었다면 clone한것도 동일하게 갖고 있음
    // 근데 PAGE_INFO 에서 2를 통째로 갈아꼈으면 clone 한 것에는 적용 안됨 복사한 것을 통째로 갖고 있을거기때문에
    public static final PAGE[] values(){
        return PAGE_INFO.clone();
    }

    // 외부에서는 cost만 있는 걸 모르고 API RESPONSE로 OOLLOR가 얼마구나 WON이 얼마구나만 알 수 있음
}
