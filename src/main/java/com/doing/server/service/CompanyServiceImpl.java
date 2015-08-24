package com.doing.server.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doing.server.controller.CompanyServer;
import com.doing.server.dao.CompanyDao;
import com.doing.server.pojo.Company;

@Service("companyService")
@Transactional
public class CompanyServiceImpl implements CompanyService {
	
	private static final Logger logger = Logger.getLogger(CompanyServiceImpl.class);

	@Autowired
	private CompanyDao dao;
	
	public Company findById(int id) {
		return dao.findById(id);
	}

	public void saveCompany(Company company) {
		dao.saveCompany(company);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateCompany(Company company) {
		Company entity = dao.findById(company.getId());
		if(entity!=null){
			entity.setName(company.getName());
		}
	}

	public void deleteCompanyById(int id) {
		dao.deleteCompanyById(id);
	}
	
	public List<Company> findAllCompanies() {
		logger.debug("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxfindAllCompanies");
		return dao.findAllCompanies();
	}

	public Company findCompanyByName(String name) {
		return dao.findCompanyByName(name);
	}

	public boolean isCompanyNameUnique(Integer id, String name) {
		Company company = findCompanyByName(name);
		return ( company == null || ((id != null) && (company.getId() == id)));
	}
	
}
