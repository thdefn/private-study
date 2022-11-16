package com.haden.prjforstd.memberClass;

import lombok.Data;

public class User {
    // member class는 nested class의 일종: 클래스 안에 클래스가 있는 것이 네스티드 클래스
    /* nested 되어 있는 멤버 클래스는 독립적으로 존재할 수 없으며
    바깥 인스턴스 없이는 생성할 수 없어야 함
     */

    private String name;
    private Address address;

    public class Address{
        String zipcode;
    }

    // 멤버 클래스가 상위 클래스에 접근이 가능하다
    // Address라는 멤버 클래스에서 getUserName 이라는 메서드를 만들어 상위의 User.name을 리스폰스 가능
    public String getUserName(){
        return name;
    }


    // Nested class - local class
    /*
    * Local var을 선언할 수 있는 곳에 선언하여 사용하는 것 ex> method body */

    public void getName(){
        class Name{
            public int age;
        }
    }

    public static void main(String[] args) {
        // new User 객체를 만들어야만 그걸 기반으로 하위 인스턴스를 생성해낼 수 있음
        User user = new User();
        user.new Address();


        // anonymous class 의 예시 이 클래스에는 이름이 없음
        Myname myname = new Myname() {
            private int age;
            @Override
            public int getAge() {
                return age;
            }
        };

        YourName youname = new YourName() {
            private int age;
            @Override
            public int getAge() {
                return age;
            }
        };
    }

}
