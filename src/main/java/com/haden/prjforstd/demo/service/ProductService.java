package com.haden.prjforstd.demo.service;

import com.haden.prjforstd.demo.controller.dto.ProductMypriceRequestDto;
import com.haden.prjforstd.demo.controller.dto.ProductRequestDto;
import com.haden.prjforstd.demo.domain.entity.Product;
import com.haden.prjforstd.demo.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(ProductRequestDto requestDto) throws SQLException {
        Product product = new Product(requestDto);
        productRepository.save(product);

        return product;
    }

    public Product updateProduct(Long id, ProductMypriceRequestDto requestDto) {
        Product product = productRepository.findById(id)
                .orElseThrow(()->new NullPointerException("no contents"));
        int myPrice = requestDto.getMyprice();
        product.updateProductPrice(myPrice);
        productRepository.save(product);

        return product;
    }

    public List<Product> getProductList() {
        List<Product> products = productRepository.findAll();
        return products;
    }
}
