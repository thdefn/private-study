package com.haden.prjforstd.clone;

import lombok.Getter;

@Getter
public class Yum {
    String snack;
    String chocolate;

    //객체를 생성하는 데 사용할 수 있는 패턴 > 클론을 대신할 수 있음

    public Yum(String snack, String chocolate) {
        this.snack = snack;
        this.chocolate = chocolate;
    }


    //1. conversion Constructor

    public Yum(Yum yum) {
        this.snack = yum.getSnack();
        this.chocolate = yum.getChocolate();
    }


    //2. conversion Factory

    public static Yum newInstance(Yum yum){
        return yum;
    }

    @Override
    public String toString() {
        return "Yum{" +
                "snack='" + snack + '\'' +
                ", chocolate='" + chocolate + '\'' +
                '}';
    }

    public static void main(String[] args) {
        //객체를 생성하는 데 사용할 수 있는 패턴 > 클론을 대신할 수 있음
        Yum yum = new Yum("hi","mychoco");
        System.out.println(yum.toString());

        //1. conversion Constructor 를 통한 복제
        Yum yum2 = new Yum(yum);
        System.out.println(yum == yum2);
        System.out.println(yum2.toString());

        //2. conversion Factory 를 통한 복제
        Yum yum3 = newInstance(yum);
        System.out.println(yum == yum3);
        System.out.println(yum3.toString());
    }

}
