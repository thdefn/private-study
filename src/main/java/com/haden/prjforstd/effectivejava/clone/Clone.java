package com.haden.prjforstd.effectivejava.clone;

import com.haden.prjforstd.effectivejava.equals.Laptop2;

public class Clone {
    static void first (){
        int[] a = {1,2,3,4};
        int[] b = a; // shallow copy 객체의 주소값을 다른 객체에 할당
        b = a.clone(); // deep copy 내부의 값을 전부 카피
    }

    static void second (){
        // deep copy는 완전하지 않음
        Laptop2[] a = {new Laptop2("그램 16인치","삼성")};
        Laptop2[] b = a.clone();
        b[0].setCompany("LG");

        //b를 바꿨으나 a 에서 가르키는 회사명도 똑같이 엘지임
        //랩탑 배열에 들어가 있는 거는 랩탑 인스턴스에 레퍼런스 value 라서
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4};

        System.out.println(a.clone() != a); //참
        System.out.println(a.clone().getClass() == a.getClass()); //참
        System.out.println(a.clone().equals(a)); //일반적으로 참


    }
}
