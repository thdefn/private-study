package com.haden.prjforstd.effectivejava.encapsulation;

public class ItemInfo {
    /*
    최초에는 name과 price를 response할 수 있었음
    허나 내부 정책이 바뀌어 내부에선 price 대신 cost라는 용어를 사용하고자 함
    밖에서는 그대로 price로 노출이 되어야 함
    내부에 어떤 데이터로 관리를 하고 있는지 알 수 없게 한다
    * */

    // 좀 더 Strct 한 규정을 적용하고 싶다면 name의 불필요한 setter을 없앨 수 있음
    // 변할 수 있는 필드가 있고 생성한 후부터는 변하면 안되는 값들이 있을 수 있음 이 경우에는 name이 필요 없는 경우
    // set을 없애고 생성자로만 이름을 주입받는다면 그 장점은? : 해당 필드는 변하지 않을 것이라고 암시적으로 알려줌 final로 선언해도 비슷한 효과
    // final로 선언하고 set도 없애는게 가장 명확하기는 함
    public String name;
    public int price;

    public ItemInfo(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
