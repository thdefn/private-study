package com.haden.prjforstd.demo.domain.repository;

import com.haden.prjforstd.demo.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
