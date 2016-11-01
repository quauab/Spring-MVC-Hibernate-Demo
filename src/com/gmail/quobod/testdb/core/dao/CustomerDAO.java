package com.gmail.quobod.testdb.core.dao;

import java.util.List;

import com.gmail.quobod.testdb.core.entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
	
	public void deleteCustomer(String ID);

	public Customer findById(String param);

	public Customer findByEmail(String param);

}
