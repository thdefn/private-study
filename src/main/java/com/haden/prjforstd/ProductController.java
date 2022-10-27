package com.haden.prjforstd;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/api/products")
    public Product createProduct(@RequestBody ProductRequestDto requestDto) throws SQLException {
        //ProductService productService = new ProductService();
        Product product = productService.createProduct(requestDto);

        return product;
    }

    @PutMapping("/api/products/{id}")
    public Long updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto requestDto){
        Product product = productService.updateProduct(id, requestDto);
        return product.getId();
    }

    @GetMapping("/api/products")
    public List<Product> getProductList(){
        List<Product> products = productService.getProductList();
        return products;
    }

}
