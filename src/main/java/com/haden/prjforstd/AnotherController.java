package com.haden.prjforstd;

import com.haden.prjforstd.staticfactorymethod.Laptop;
import com.haden.prjforstd.staticfactorymethod.LaptopForm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RequiredArgsConstructor //final로 선언된 변수에 대해 자동으로 생성자 만들어줌
@RestController
public class AnotherController {
    @Autowired
    private final ProductService productService;

    /*public AnotherController(ProductService productService) {
        this.productService = productService;
    }*/

    public Product updateProduct(@RequestBody ProductRequestDto requestDto) throws SQLException {
        Product product = productService.createProduct(requestDto);
        return product;
    }

    @PostMapping("/add")
    public Laptop addLaptop(@RequestBody LaptopForm laptopForm){
        //지금은 두 개밖에 없으니까 get을 하는 게 편해보이나 만약에 var이 늘어나면 상당히 비효율적일것
        //Laptop laptop = new Laptop(laptopForm.getName(), laptopForm.getCorp());

        //한 줄이면 충분하고 가독성이 좋음
        Laptop laptop = Laptop.from(laptopForm);
        return laptop;
    }
}
