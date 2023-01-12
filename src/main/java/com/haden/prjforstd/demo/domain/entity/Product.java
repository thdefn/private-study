package com.haden.prjforstd.demo.domain.entity;

import com.haden.prjforstd.demo.controller.dto.ProductRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor //new Product() 형태의 생성자 만들어줌
@Entity //DB 테이블 역할을 한다
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private int price;


    public Product(ProductRequestDto requestDto) {
        if(requestDto.getTitle() == null || requestDto.getTitle().isEmpty()){
            throw new IllegalArgumentException("상품명이 없습니다");
        }
        if(requestDto.getPrice() <= 0){
            throw new IllegalArgumentException("상품 최저가가 0 이하입니다");
        }
        this.title = requestDto.getTitle();
        this.image = requestDto.getImage();
        this.link = requestDto.getLink();
        this.price = requestDto.getPrice();
    }

    public void updateProductPrice(int price){
        this.price = price;
    }
}
