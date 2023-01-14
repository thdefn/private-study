package com.haden.prjforstd.effectivejava.array;

import java.util.ArrayList;
import java.util.List;

public class Array {
    public static void main(String[] args) {
        // 런타임시 에러
        // 배열은 런타임 할 때도 담기로 한 원소의 타입을 인지하고 있음
        Object[] objects = new Long[1]; // 박싱된 롱타입은 오브젝트의 확장 > 오브젝트 배열에 롱의 인스턴스 넣을 수 있음
        objects[0] = "test"; //스트링을 오브젝트 타입으로 변환해서 넣으려고 함
        // 실제로 안에 있는 인스턴스 타입은 롱 타입이기 때문에 오브젝트 타입 안에 스트링을 넣는 게 아니라 롱 타입안에 스트링을 넣는 것 > 런타임 에러


        // 컴파일시 에러 발생 > 나는 오브젝트로 선언했는데 너는 왜 롱타입 주니? 하고 컴파일러가 체크
        // 제네릭은 런타임 시 타입에 대한 정보가 사라짐
        //List<Object> objectList = new ArrayList<Long>();


       // 제네릭 사용하면 컴파일 레벨에서 잡을 수 있는 오류의 종류가 많아짐
    }
}
