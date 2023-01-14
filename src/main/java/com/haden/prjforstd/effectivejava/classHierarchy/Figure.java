package com.haden.prjforstd.effectivejava.classHierarchy;

public class Figure {
    /*클래스가 순서성을 유지해야 하는데
    * 타입으로 특정 필드의 유무가 결정되어지는 태그 달린 클래스는 좋지 않다
    * 인스턴스의 타입으로는 의미가 불분명함 직접 꺼내봐야 알 수 있음*/

    // enum 선언
    enum Shape {RECTANGLE, CIRCLE};
    final Shape shape;
    // 꼭 필요하지는 않은 변수들 선언 어떤 타입을 쓰든 뭐든 불필요한 타입이 생김
    double length;
    double width;
    double radius;

    // double 값 하나만 전달할경우 enum은 CIRCLE이됨
    public Figure(double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    // double 값 두개 전달할경우 enum은 RECTANGLE
    public Figure(double length, double width) {
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    // 분기처리를 위한 switch
    double area(){
        switch (shape){
            case RECTANGLE: return length * width;
            case CIRCLE: return Math.PI * (radius * radius);
            default: throw new AssertionError(shape);
        }
    }
}
