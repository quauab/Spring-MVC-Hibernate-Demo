package com.gmail.quobod.testdb.core.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gmail.quobod.testdb.core.dao.CustomerDAO;
import com.gmail.quobod.testdb.core.entity.Customer;
import com.gmail.quobod.testdb.core.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	
	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		customerDAO.saveCustomer(theCustomer);
	}


	@Override
	@Transactional
	public void deleteCustomer(String ID) {
		customerDAO.deleteCustomer(ID);
	}


	@Override
	public Customer findById(String param) {
		return customerDAO.findById(param);
	}


	@Override
	public Customer findByEmail(String param) {
		return customerDAO.findByEmail(param);
	}

}
