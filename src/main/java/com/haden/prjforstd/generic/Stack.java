package com.haden.prjforstd.generic;

import java.util.Collection;
import java.util.List;

public class Stack<E> {
    // Bounded Wildcard
    // 매개변수 타입이 불공변임 (invariant) 자기 타입만 허용
    public static final int DEFAULT_SIZE = 20;
    private int size;
    private E[] elements;

    public Stack(){
        elements = (E[]) new Object[DEFAULT_SIZE]; // object를 Element로 캐스팅
        size = 0;
    }

    public E push(E item){
        elements[++size] = item;
        return item;
    }


    // 문제의 소지가 있음
    public void pushAll(Iterable<E> src){
        for(E e:src){
            push(e);
        }
    }

    // 한정적 와일드카드 타입 이용해보자 <?> 어떻게 한정을 시킬 것이냐 : 특정 타입을 확장한 와일드 카드 타입
    public void pushAll2(Iterable<? extends E> src){
        for(E e:src){
            push(e);
        }
    }

    // 확장한 것만 사용 가능한 것이 아니라 부모의 클래스 또한 파라미터로 받겠다고 선언 가능함
    // 제네릭 상위 ㅋ클래스인 와일드 카드를 Collection으로 받겠다
    public void popAll(Collection<? super E> dst){
        //...
    }

    public static void main(String[] args) {
        // Integer, Long, Double 등 박싱 타입은 Number을 확장함
        Stack<Number> numberStack = new Stack<>(); // 넘버 타입을 가지는 스택 생성
        Iterable<Integer> integers = List.of(1,2); // 인티저는 넘버 타입을 가지고 있으니 아무 문제 없는 거 아닌가?
        //numberStack.pushAll(integers); // 컴파일 에러 발생
        numberStack.pushAll2(integers); // number을 extends한 인티저임이 충분히 설명되어서 문제 발생하지 않음

        Collection<Object> integers2 = List.of(1,2); //오브젝트는 모든 타입의 super임
        numberStack.popAll(integers2); // E의 super인 Object로 된 배열 받기 가능함

        // 확장한 클래스는 상위의 클래스로 자동으로 타입 캐스팅 된다
    }
}
