package com.doing.server.dao;

import java.util.List;

import com.doing.server.pojo.Company;

public interface CompanyDao {

	Company findById(int id);
	void saveCompany(Company company);
	void deleteCompanyById(int id);
	List<Company> findAllCompanys(Company company);
	Company findCompanyByName(String name);

}
