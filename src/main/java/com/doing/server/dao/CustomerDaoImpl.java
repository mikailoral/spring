package com.doing.server.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.doing.server.pojo.Customer;

@Repository("customerDao")
public class CustomerDaoImpl extends AbstractDao<Integer, Customer> implements CustomerDao {
	
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(CustomerDaoImpl.class);

	public Customer findById(int id) {
		return getByKey(id);
	}

	public void saveCustomer(Customer customer) {
		persist(customer);
	}

	public void deleteCustomerById(int id) {
		Query query = getSession().createSQLQuery("delete from Customer where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Customer> findAllCustomers(Customer customer) {
		Criteria criteria = createEntityCriteria();
		return (List<Customer>) criteria.list();
	}
	
	public Customer findCustomerByName(String name) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("name", name));
		return (Customer) criteria.uniqueResult();
	}

}
