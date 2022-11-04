package com.haden.prjforstd.equals;

import java.util.Objects;

public class Laptop2 {
    private String model;

    private String company;

    public Laptop2(String model, String company) {
        this.model = model;
        this.company = company;
    }

    //주의해야할 부분 : 받는 객체 타입은 무조건 Object여야 한다
    @Override
    public boolean equals(Object o) {
        //1. ==을 통해 o가 자기 자신의 참조인지 확인함 : 주소값을 체크
        if (this == o) return true;
        // 2. instanceof를 통해 input의 타입이 명확한지 책에서는 instanceof 로 예를 들었으나 인텔리제이에서는 getClass() 로 클래스 check
        if (o == null || getClass() != o.getClass()) return false;
        // 3.  2를통해 검사한 객체를 올바른 타입으로 형변환 object로 들어온 것을 Laptop2로 형변환
        Laptop2 laptop2 = (Laptop2) o;
        // 4. 핵심 필드들이 일치하는지 체크 model / company
        return Objects.equals(model, laptop2.model) && Objects.equals(company, laptop2.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, company);
    }
}
