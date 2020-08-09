package com.sample.ecom.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.sample.ecom.exception.InternalServerException;
import com.sample.ecom.exception.NoSuchResourceFoundException;
import com.sample.ecom.jpa.CustomerEntity;
import com.sample.ecom.repository.CustomerJpaRepository;
import com.sample.ecom.service.CustomerService;
import com.sample.ecom.vo.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerJpaRepository customerRepo;

	@Override
	public Customer getCustomer(Long id) {
		Customer customer = new Customer();
		CustomerEntity entity = customerRepo.findByCustomerId(id);
		
		if(ObjectUtils.isEmpty(entity)) {
			throw new NoSuchResourceFoundException("customer id not found");
		}
		
		BeanUtils.copyProperties(entity, customer);
		return customer;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		
		try {
			CustomerEntity custEntity = new CustomerEntity();
			BeanUtils.copyProperties(customer, custEntity);
			BeanUtils.copyProperties(customerRepo.save(custEntity), customer);
			return customer;
		
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}
	}

	@Override
	public void updateCustomer(Customer customer) {
		
		CustomerEntity entity = customerRepo.findByCustomerId(customer.getCustomerId());
		if(ObjectUtils.isEmpty(entity)) {
			throw new NoSuchResourceFoundException("customer not found");
		}
		
		BeanUtils.copyProperties(customer, entity);
		customerRepo.save(entity);
	}

	@Override
	public void deleteCustomer(Long id) {
		
		CustomerEntity entity = customerRepo.findByCustomerId(id);
		if(ObjectUtils.isEmpty(entity)) {
			throw new NoSuchResourceFoundException("customer not found");
		}
		entity.setDeleteIndicator("Y");
		entity.getOrders().forEach(x -> x.setDeleteIndicator("Y"));
		customerRepo.save(entity);
	}

}
