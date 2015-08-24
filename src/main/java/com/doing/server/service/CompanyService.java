package com.doing.server.service;

import java.util.List;

import com.doing.server.pojo.Company;

public interface CompanyService {

	Company findById(int id);
	
	void saveCompany(Company company);
	
	void updateCompany(Company company);
	
	void deleteCompanyById(int id);

	List<Company> findAllCompanies(); 
	
	Company findCompanyByName(String name);

	boolean isCompanyNameUnique(Integer id, String name);
	
}
