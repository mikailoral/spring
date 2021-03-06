package com.doing.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doing.server.dao.CompanyDao;
import com.doing.server.pojo.Company;

@Service("companyService")
@Transactional
public class CompanyServiceImpl implements CompanyService {

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
	
	public List<Company> findAllCompanys(Company company) {
		return dao.findAllCompanys(company);
	}


	
}
