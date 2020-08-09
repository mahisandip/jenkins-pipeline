package com.sample.ecom.service;

import javax.transaction.Transactional;

import com.sample.ecom.vo.Customer;

public interface CustomerService {
	
	Customer getCustomer(Long id);
	
	@Transactional
	Customer addCustomer(Customer customer);
	
	@Transactional
	void updateCustomer(Customer customer);
	
	@Transactional
	void deleteCustomer(Long id);

}
