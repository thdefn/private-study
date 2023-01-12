package com.haden.prjforstd;

import com.haden.prjforstd.demo.controller.dto.ProductRequestDto;
import com.haden.prjforstd.demo.domain.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private String title;
    private String image;
    private String link;
    private int price;

    @BeforeEach
    void setup(){
      title = "사과";
      image = "사과이미지";
      link = "https://search.shopping.naver.com/search/all?query=%EC%82%AC%EA%B3%BC&bt=-1&frm=NVSCPRO";
      price = 10000;
    }

    @Test
    @DisplayName("normal")
    void createProduct(){

        //given
        ProductRequestDto requestDto = new ProductRequestDto(title, image, link, price);

        //when
        Product product = new Product(requestDto);

        //then
        assertNull(product.getId());
        assertEquals(title, product.getTitle());
        assertEquals(image, product.getImage());
        assertEquals(link, product.getLink());
        assertEquals(price, product.getPrice());
    }

    //비정상 케이스는 묶어서 계층구조로 표현
    @Nested
    @DisplayName("abnormal")
    class FailCase {

        @Nested
        class Title{
            @Test
            @DisplayName("null")
            void fail1(){
                //given
                String title = null;
                ProductRequestDto requestDto = new ProductRequestDto(title, image, link, price);
                //when
                Exception e = assertThrows(IllegalArgumentException.class,()->new Product(requestDto));
                //then
                assertEquals("상품명이 없습니다", e.getMessage());

            }

            @Test
            @DisplayName("빈 문자열")
            void fail2(){
                //given
                String title = "";
                ProductRequestDto requestDto = new ProductRequestDto(title, image, link, price);
                //when
                Exception e = assertThrows(IllegalArgumentException.class,()->new Product(requestDto));
                //then
                assertEquals("상품명이 없습니다", e.getMessage());
            }
        }

        @Nested
        @DisplayName("상품 최저가")
        class Price{

            @Test
            @DisplayName("0")
            void fail1(){
                //given
                int price = 0;
                ProductRequestDto requestDto = new ProductRequestDto(title, image, link, price);
                //when
                Exception e = assertThrows(IllegalArgumentException.class, ()->{new Product(requestDto);});
                //that
                assertEquals("상품 최저가가 0 이하입니다", e.getMessage());
            }

            @Test
            @DisplayName("음수")
            void fail2(){
                //given
                int price = -15000;
                ProductRequestDto requestDto = new ProductRequestDto(title, image, link, price);
                //when
                Exception e = assertThrows(IllegalArgumentException.class, ()->{new Product(requestDto);});
                //that
                assertEquals("상품 최저가가 0 이하입니다", e.getMessage());

            }
        }

    }

}