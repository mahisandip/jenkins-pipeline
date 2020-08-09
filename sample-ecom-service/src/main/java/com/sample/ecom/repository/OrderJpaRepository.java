package com.sample.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.ecom.jpa.OrderEntity;

public interface OrderJpaRepository extends JpaRepository<OrderEntity, Long> {
	
	OrderEntity findByOrderId(Long id);
}
