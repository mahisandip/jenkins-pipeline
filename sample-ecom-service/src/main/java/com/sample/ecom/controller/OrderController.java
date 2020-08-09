package com.sample.ecom.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sample.ecom.service.OrderService;
import com.sample.ecom.vo.Order;

@RestController
@RequestMapping("/orders/")
public class OrderController {
	
	@Autowired
	private OrderService service;

	@RequestMapping(value = "get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Order> getOrder(@RequestParam(value = "id", required = true) Long id, 
			HttpServletRequest request) {
		return ResponseEntity.status(HttpStatus.OK.value()).body(service.getOrder(id));
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Order> createOrder(@Valid @RequestBody Order order, HttpServletRequest request, 
			BindingResult bindingResult) {
		return ResponseEntity.status(HttpStatus.CREATED.value()).body(service.createOrder(order));
	}
	
	@RequestMapping(value = "update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void updateOrder(@Valid @RequestBody Order order, HttpServletRequest request, 
			BindingResult bindingResult) {
		service.updateOrder(order);
	}
	
}
