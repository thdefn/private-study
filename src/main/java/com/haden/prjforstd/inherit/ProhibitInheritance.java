package com.haden.prjforstd.inherit;

import lombok.Getter;

import java.awt.*;

@Getter
public class ProhibitInheritance {
    /* 상속을 금지하는 방법 첫번째
    모든 생성자를 private or package private으로 선언하고 public static factory로 만드는 법
    모든 생성자를 private으로 막으면 사실상 상속이 불가능함 : Super Equal을 가져올 수 없기 때문
    extend한 클래스를 만든다고 가정함 > extends한 클래스의 super의 생성자가 private이기 때문에 가져올 수 없음
    */
    private int sum;
    private ProhibitInheritance(){

    }
    private ProhibitInheritance(int sum) {
        this.sum = sum;
    }

    public static ProhibitInheritance getInstance(){
        return new ProhibitInheritance();
    }

    /*올바르게 상속을 하려면 어떤 것을 지켜야 할까?
    * 실무에서는 상속 활용하지 않음
    * 1. 주석으로 @implSepc을 통해 상속할 때 필요한 내용을 서술한다
    * */

    // 상속이 있을때 Clone readObject 모두 직간접적으로 override method를 호출해서는 안됨
    // 올바르게 상속이 되었는지 확인 할 수 있는 방법 : 하위 Object를 만들어서 테스트해보면 좋다


    /*
    * @implSepc 해당 method는 blahbalh
    * */

    /*

    public void draw(String color){
        for(Shape shape : shapes){
            shape.draw(color);
        }
    }
    */

}
