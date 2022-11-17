package com.haden.prjforstd.generic;

public class Box {
    private Object object;

    public Object getObject() {
        return object; //Object 타입의 객체를 반환함
    }

    public void setObject(Object object) {
        this.object = object; //자바의 모든 객체를 받을 수 있음
    }

    public static void main(String[] args) {
        Box box = new Box();
        box.setObject("hello");
        String str = (String) box.getObject(); //Object 타입을 원래 타입의 객체로 받기 위해 Type Casting이 필요함

        Box2<String> box2 = new Box2<String>();
        box2.set("hello");
        String str2 = box2.get();
    }
}
