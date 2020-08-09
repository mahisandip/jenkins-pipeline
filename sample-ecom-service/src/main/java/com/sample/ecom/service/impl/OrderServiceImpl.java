package com.sample.ecom.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.sample.ecom.exception.InternalServerException;
import com.sample.ecom.exception.NoSuchResourceFoundException;
import com.sample.ecom.jpa.OrderEntity;
import com.sample.ecom.repository.OrderJpaRepository;
import com.sample.ecom.service.OrderService;
import com.sample.ecom.vo.Order;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderJpaRepository ordersRepo;
	
	@Override
	public Order getOrder(Long id) {

		OrderEntity entity = ordersRepo.findByOrderId(id);
		if(ObjectUtils.isEmpty(entity)) {
			throw new NoSuchResourceFoundException("order id is not available");
		}
		
		Order order = new Order();
		BeanUtils.copyProperties(entity, order);
		return order;
	}

	@Override
	public Order createOrder(Order order) {
		
		try {
		OrderEntity entity = new OrderEntity();
		BeanUtils.copyProperties(order, entity);
		BeanUtils.copyProperties(ordersRepo.save(entity), order);
		return order;
		
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}
	}

	@Override
	public void updateOrder(Order order) {
		
		OrderEntity entity = ordersRepo.findByOrderId(order.getOrderId());
		if(ObjectUtils.isEmpty(entity)) {
			throw new NoSuchResourceFoundException("order not found");
		}
		
		BeanUtils.copyProperties(order, entity);
		ordersRepo.save(entity);
		
	}

}
