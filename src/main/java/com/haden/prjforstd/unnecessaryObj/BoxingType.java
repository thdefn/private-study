package com.haden.prjforstd.unnecessaryObj;

public class BoxingType {

    /*항상 primitive type을 사용하라는 것은 아님
    primitive type은 null을 표현할 수 없다

    price가 0 인것과 null인 것의 의미는 다르다.
    0의 의미는 증정품 등의 사유로 0원일 수 있고
    NUlL의 경우 가격이 아직 정해지지 않았다 생각될 수 있음
    */

    int price; // primitive
    Integer price2; // boxing

    //Boxing type 대신 Primitive Type을 사용할 것
    public static long sum(){
        Long sum = 0L; // boxing type > 매번 인스턴스를 생성함
        //long sum = 0L; 이렇게 수정
        for(long i = 0;i<Integer.MAX_VALUE; i++){
            sum += i;
        }
        return sum;
    }

}
