package com.haden.prjforstd.effectivejava.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class Operator {
    /*List.of의 내부 : 같은 타입의 객체 n개를 입력받도록 되어 있음
    * 파라미터로 받는 엘리먼트의 타입과 리스폰스로 주어지는 엘리먼트의 타입이 완전히 동일함 > 타입을 맞추게 됨*/
    List<String> stringList = List.of("T1","T2","T3");

    private static UnaryOperator<Object> IDENTIFY_FN = (t)->t; //object를 타입으로 가진 UnaryOperator

    public static <T> UnaryOperator<T> indentifyFuntion(){
        return (UnaryOperator<T>) IDENTIFY_FN; // 타입캐스팅으로 리스폰스
        //object는 제너릭으로 캐스팅되지 않음, 유형이 다르기 때문에 에러 발생
        // 이와 같이 Object 타입을 사용하면 모든 종류의 자바 객체를 저장할 수 있다는 장점은 있지만, 저장할 때 타입 변환이 발생하고, 읽어올 때도 타입 변환이 발생합니다.
    }

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("h1");
        String s = (String) list.get(0);
    }

}
