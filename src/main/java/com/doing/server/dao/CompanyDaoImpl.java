package com.doing.server.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.doing.server.pojo.Company;

@Repository("companyDao")
public class CompanyDaoImpl extends AbstractDao<Integer, Company> implements CompanyDao {
	
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(CompanyDaoImpl.class);

	public Company findById(int id) {
		return getByKey(id);
	}

	public void saveCompany(Company company) {
		persist(company);
	}

	public void deleteCompanyById(int id) {
		Query query = getSession().createSQLQuery("delete from Company where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Company> findAllCompanys(Company company) {
		Criteria criteria = createEntityCriteria();
		return (List<Company>) criteria.list();
	}
	
	public Company findCompanyByName(String name) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("name", name));
		return (Company) criteria.uniqueResult();
	}

}
