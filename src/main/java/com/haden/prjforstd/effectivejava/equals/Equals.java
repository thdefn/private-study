package com.haden.prjforstd.effectivejava.equals;

public class Equals {
    static void UseCase(){
        Laptop2 laptop = new Laptop2("mo","corp");
        //reflexibity 대칭성
        System.out.println(laptop.equals(laptop));

        //symmetry 대칭성
        Laptop2 laptop2 = new Laptop2("mo","corp");
        System.out.println(laptop.equals(laptop2) == laptop2.equals(laptop));

        //transitivity 추이성 추론을 통해 참인 걸 판단 가능함
        Laptop2 laptop3 = new Laptop2("mo", "corp");
        System.out.println("laptop==laptop2 "+laptop.equals(laptop2));
        System.out.println("laptop2==laptop3 "+laptop2.equals(laptop3));
        System.out.println("laptop==laptop3 "+laptop.equals(laptop3));

        //consistency 일관성 여러번 호출해도 항상 결과는 같음
        System.out.println(laptop.equals(laptop2));
        System.out.println(laptop.equals(laptop2));
        System.out.println(laptop.equals(laptop2));

        //not null null이 아닌 모든 참조값에 대해 x.equals(null) == false

    }

    public static void main(String[] args) {
        UseCase();
    }
}
