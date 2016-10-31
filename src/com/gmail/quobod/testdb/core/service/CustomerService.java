package com.gmail.quobod.testdb.core.service;

import java.util.List;

import com.gmail.quobod.testdb.core.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
	
	public void deleteCustomer(String ID);

}
