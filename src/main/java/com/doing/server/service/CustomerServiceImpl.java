package com.doing.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doing.server.dao.CustomerDao;
import com.doing.server.pojo.Customer;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao dao;
	
	public Customer findById(int id) {
		return dao.findById(id);
	}

	public void saveCustomer(Customer customer) {
		dao.saveCustomer(customer);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateCustomer(Customer customer) {
		Customer entity = dao.findById(customer.getId());
		if(entity!=null){
			entity.setName(customer.getName());
		}
	}

	public void deleteCustomerById(int id) {
		dao.deleteCustomerById(id);
	}
	
	public List<Customer> findAllCustomers(Customer customer) {
		return dao.findAllCustomers(customer);
	}


	
}
