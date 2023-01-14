package com.haden.prjforstd.effectivejava.staticFactoryMethod;

public class LaptopDto {
    private String modelName;
    private String companyName;

    // 항상 entity to dto로 response
    // 필요하지 않은 엔티티의 속성을 제거하고 dto를 생성하는 루틴으로 static Factory Method가 굉장히 유용
    public static LaptopDto from(Laptop laptop){
        LaptopDto laptopDto = new LaptopDto();
        laptopDto.companyName = laptop.getCompany();
        laptopDto.modelName = laptop.getModel();
        return laptopDto;
    }
}
