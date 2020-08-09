package com.sample.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.ecom.jpa.ProductEntity;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {

}
