package com.gmail.quobod.testdb.core.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gmail.quobod.testdb.core.dao.CustomerDAO;
import com.gmail.quobod.testdb.core.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query
		Query<Customer> query = currentSession.createQuery("from Customer order by lastName", Customer.class);
				
		// get list of customers from the query
		List<Customer> customers = query.getResultList();
		
		// return the list of customers
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save the customer
		currentSession.saveOrUpdate(theCustomer);
	}
	
	@Override
	public void deleteCustomer(String ID) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Customer> query = currentSession.createQuery("from Customer where id = '" + ID + "'", Customer.class);
		Customer customer = query.getSingleResult();
		currentSession.delete(customer);
	}

	@Override
	public Customer findById(String param) {
		Customer customer = null;
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Customer> query = currentSession.createQuery("from Customer where id = '" + param + "'", Customer.class);
		if (query.getMaxResults() > 0 && null != (customer = query.getSingleResult())) {
			return customer;
		}
		return null;
	}

	@Override
	public Customer findByEmail(String param) {
		Customer customer = null;
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Customer> query = currentSession.createQuery("from Customer where email = '" + param + "'", Customer.class);
		if (query.getMaxResults() > 0 && null != (customer = query.getSingleResult())) {
			return customer;
		}
		return null;
	}

	
}
