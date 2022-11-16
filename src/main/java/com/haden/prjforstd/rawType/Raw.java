package com.haden.prjforstd.rawType;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Raw {

    // 명확하게 타입 추론이 가능하게 하자 그렇지 않다면 런타임 시 예외 발생 가능
    // List<Object> 는 명확하게 타입을 제시한 경우임

    // 아래와 같이 merge하면 다른 타입이 들어왔을 때 런타임시 언젠가는 문제가 생김
    static List listMerge(List a, List b){
        List c = new ArrayList();
        c.addAll(a);
        c.addAll(b);
        return c;
    }

    // unbounded wildcard type
    private int add(List<?> s1){
        s1.add(null);
        return 1;
    }

    public static void main(String[] args) {
        // 비권장 코드 : 만약 type parameter가 없다면?
        List test = new ArrayList(); //test라는 리스트 객체를 만듦 타입 파라미터를 명시하지 않았기 때문에 Object로 간주
        test.add("no1");
        test.add(1);
        // String과 int를 둘 다 담을 수 있음

        // 다만 객체의 타입을 추측하기 어려워서 generic이 주는 타입의 안정성을 잃을 수 있음
        // add만 했기 때문에 현ㅈ는 에러 발생 x BUT typecasting을 해서 메서드에 넣는다면 에러가 발생할 가능성


        //예외적으로 raw를 사용할 때
        //1. Class 리터럴에는 raw type을 써야함
        //List.class

        //2. 런타임시 제네릭 타입 정보가 지워지기 때문에 다음과 같이 체크
        List<String> a = new ArrayList<>(); // List<E>의 정보가 실제 런타임에는 지워짐 그래서 와일드 카드 타입으로 나눈다
        if(a instanceof Set){ //a가 Set의 일종이면
            Set<?> s = (Set<?>) a; //와일드 카드 타입의 Set집합으로 타입캐스팅
            for(Object o:s){ //s로 for문
                if(o instanceof String){ //o가 String이면
                    // true
                }
            }
        }

    }
}
