package com.haden.prjforstd.toString;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
//@ToString(exclude = {"modelNum"})
public class Laptop3 {
    private String modelName;
    private String company;
    //private String country;
    @ToString.Exclude private String country; //유지보수 측면에서 이게 더 나음
    private String modelNum;

    public static void main(String[] args) {
        System.out.println(new Laptop3("그램16인지","엘지", "kor","12"));
    }
}
