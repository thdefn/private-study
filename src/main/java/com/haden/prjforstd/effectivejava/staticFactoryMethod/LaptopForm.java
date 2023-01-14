package com.haden.prjforstd.effectivejava.staticFactoryMethod;

import lombok.Getter;

@Getter
public class LaptopForm {
    private String name;
    private String corp;

    /*public static LaptopForm ofNameandCorp(String name, String corp){
        LaptopForm laptopForm = new LaptopForm();
        laptopForm.name = name;
        laptopForm.corp = corp;
        return laptopForm;
    }*/
}
