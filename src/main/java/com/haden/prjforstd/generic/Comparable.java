package com.haden.prjforstd.generic;

public interface Comparable<T> {
    // 제너릭 메소드의 장점 : 타입을 한정시킨다 > 메서드의 파라미터 타입을 인터페이스 타입으로 한정해서 좀 더 견고한 코드 작성 가능
    int compare(T o);
}
