package com.doing.server.dao;

import java.util.List;

import com.doing.server.pojo.Customer;

public interface CustomerDao {

	Customer findById(int id);
	void saveCustomer(Customer customer);
	void deleteCustomerById(int id);
	List<Customer> findAllCustomers(Customer customer);
	Customer findCustomerByName(String name);

}
