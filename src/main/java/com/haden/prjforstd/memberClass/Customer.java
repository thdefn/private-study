package com.haden.prjforstd.memberClass;

public class Customer {
    // Nested class - static member class
    /*
    책에서 권장하는 방식 : Nested 되어 있는 member class가 독립적으로 존재 가능함
    쓰임이 다름 : 일반 멤버 클래스처럼 바깥 인스턴스를 참조할 일이 있다면 멤버클래스 그렇지 않다면 스태틱 멤버 클래스 사용
    일반적인 상황에서는 static memeber class
    * */

    // 멤버 클래스는 상위의 인스턴스를 무조건 가져가야 함 > 메모리를 불필요하게 더 차지
    // 일반 멤버 클래스로 얻을 수 있는 이득이 있는 게 아니면 스태틱 권장
   private int age;
    private Address address;

    public String printBarCode(){
        return address.fullAddress + address.zipcode;
    }

    public static class Address{
        private String fullAddress;
        private String zipcode;
    }
}
