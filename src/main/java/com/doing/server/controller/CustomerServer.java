package com.doing.server.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.doing.server.pojo.Customer;
import com.doing.server.service.CustomerService;

@RestController
public class CustomerServer {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(CustomerServer.class);

	@Autowired
	CustomerService service;

	@Autowired
	private HttpServletRequest request;


	@RequestMapping(value = "/customerlist", method = RequestMethod.POST)
	public @ResponseBody List<Customer> getCustomers(@RequestBody Customer customerp) {

		List<Customer> list = service.findAllCustomers(customerp);
		for (Customer customer : list) {
			System.out.println(customer);
		}
		return list;
	}

	@RequestMapping(value = "/addcustomer", method = RequestMethod.POST)
	public @ResponseBody Customer addCustomer(@RequestBody Customer customer) {
		service.saveCustomer(customer);
		return customer;
	}
	
	@RequestMapping(value = "/updatecustomer", method = RequestMethod.POST)
	public @ResponseBody Customer updateCustomer(@RequestBody Customer customer) {
		service.updateCustomer(customer);
		return customer;
	}

	@RequestMapping(value = "/deletecustomer", method = RequestMethod.POST)
	public @ResponseBody Customer deleteCustomer(@RequestBody Customer customer) {
		service.deleteCustomerById(customer.getId());
		return customer;
	}
	
	@RequestMapping(value = "/getcustomer", method = RequestMethod.POST)
	public @ResponseBody Customer findById(@RequestBody Customer customer) {
		service.findById(customer.getId());
		return customer;
	}



}
