package com.haden.prjforstd.effectivejava.memberClass;

public interface Myname {
    // nested class - Anonymous class
    /*
    * 이미 존재하는 인터페이스나 추상 클래스, 일반 클래스 등을 메서드 내부의 영역에서 확장해서 사용하는 것
    * nested 되어 있는 멤버 클래스가 독립적으로 존재할 수 있음*/

    // 이 경우 상위의 이름을 가지고 있어야 함
    public int getAge();
}
