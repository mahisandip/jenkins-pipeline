package com.sample.ecom.service;

import javax.transaction.Transactional;

import com.sample.ecom.vo.Order;

public interface OrderService {

	Order getOrder(Long id);
	
	@Transactional
	Order createOrder(Order order);
	
	@Transactional
	void updateOrder(Order order);
	
}
