package com.doing.server.service;

import java.util.List;

import com.doing.server.pojo.Company;

public interface CompanyService {

	Company findById(int id);
	void saveCompany(Company company);
	void updateCompany(Company company);
	void deleteCompanyById(int id);
	List<Company> findAllCompanys(Company company); 
	
}
