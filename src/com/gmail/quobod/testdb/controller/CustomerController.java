package com.gmail.quobod.testdb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gmail.quobod.testdb.core.entity.Customer;
import com.gmail.quobod.testdb.core.service.CustomerService;
import com.gmail.quobod.testdb.core.utils.CustomClass;

@Controller
@RequestMapping("/")
public class CustomerController extends CustomClass {	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public String listCustomers(Model model) {		
		// add the customers to the model
		List<Customer> customers = customerService.getCustomers();
		model.addAttribute("customers", customers);
		
		return "customer-list";
	}
	
	@GetMapping("/customer")
	public String theCustomer(HttpServletRequest req) {
		String id = req.getParameter("id");
		return null;
	}
	
	@PostMapping("/addCustomer")
	public String saveCustomer(HttpServletRequest req) {
		// validate form parameter values
		
		
		// instantiate a new Customer, then set properties
		Customer newCustomer = new Customer();
		newCustomer.setFirstName(req.getParameter("first_name"));
		newCustomer.setLastName(req.getParameter("last_name"));
		newCustomer.setEmail(req.getParameter("email"));

		// save the new customer using service
		customerService.saveCustomer(newCustomer);
		
		return "redirect:/customers";
	}
		
	@GetMapping("/editCustomer")
	public String updateCustomer(HttpServletRequest req) {
		// validate form fields
		Customer theCustomer = new Customer();
		theCustomer.setId(Integer.parseInt(req.getParameter("id")));
		theCustomer.setFirstName(req.getParameter("first_name"));
		theCustomer.setLastName(req.getParameter("last_name"));
		theCustomer.setEmail(req.getParameter("email"));
		
		customerService.saveCustomer(theCustomer);
		
		// redirect to home page
		return "redirect:/customers";
	}
	
	@GetMapping("/deleteCustomer")
	public String removeCustomer(HttpServletRequest req) throws IOException {
		// get id parameter from request object
		String id = req.getParameter("id");
		        
		// delete Customer based on id
		customerService.deleteCustomer(id);
		
		return "redirect:/customers";
	}
	
}
