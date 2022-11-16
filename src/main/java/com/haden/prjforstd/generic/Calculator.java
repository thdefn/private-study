package com.haden.prjforstd.generic;

public class Calculator<E> {
    // 덧셈 뺄셈에 대한 식을 나열해주는 용도의 계산기 클래스
    // Calculator을 선언한 순간부터 나는 한 타입만 받을 거야 하는거임
    private StringBuilder expression;

    public Calculator() {
        expression = new StringBuilder();
    }

    // 클래스를 제네릭 타입으로 만들면 해당하는 타입의 객체만 이제 받을 수 있음
    public void add(E e){
        expression.append("+"+e.toString());
    }

    public void minuse(E e){
        expression.append("-"+e.toString());
    }

    public String expression(){
        if(expression.charAt(0)=='+'){
            return expression.substring(1);
        }else{
            return expression.toString();
        }
    }

    //최근 자바는 Object type을 쓰는 사람들이 많이 없음 > 대신 제네릭 타입 사용
}
