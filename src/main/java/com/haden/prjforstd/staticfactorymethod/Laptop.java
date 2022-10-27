package com.haden.prjforstd.staticfactorymethod;

import lombok.Getter;

@Getter
public class Laptop {
    private Long id;
    private String model;
    private String company;

    //제조사 별로 별도로 다른 db 테이블에 들어가야 하는 경우
    //of로 param으로 type을 넘기면 같은 Laptop 인스턴스를 만들수있지만 type에 맞는 레파지토리에서 리스폰스가 가능함

    // 단점: staticfactorymethod 제공하면 생성자가 없어서 상속받은 클래스를 만들 수 없음
    // 생성자 : Constructor
    /*public Laptop(String model, String company) {
        this.model = model;
        this.company = company;
    }*/

    // 정적 팩토리 메소드 : Static Factory method
    // of : 만든 것들의 재료를 볼 수 있음 from : 만든 것들의 재료를 볼 수 없음
    // 모델명과 회사명을 파라미터로 받아 새로운 객체의 인스턴스를 만들어 반환하겠다


    // 파라미터 명을 다 명시한 이유 : 생성자의 경우에는 무조건 String으로 두 개 들어가야함
    // 파라미터명을 메소드 네임에 담고 있다면 모델 네임을 먼저 넣고 컴패니를 나중에 넣어야 겠구나 ~ 하는 정보 명시 가능함
    public static Laptop ofModelAndCompany(String model, String company){
        Laptop laptop = new Laptop();
        laptop.company = company;
        laptop.model = model;
        return laptop;
    }

    public static Laptop from(LaptopForm laptopForm){
        Laptop laptop = new Laptop();
        laptop.model = laptopForm.getName(); //지금은 두 개밖에 없으니까 get을 하는 게 편해보이나 만약에 var이 늘어나면?
        laptop.company = laptopForm.getCorp();
        return laptop;
    }
}
