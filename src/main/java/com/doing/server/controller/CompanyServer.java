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

import com.doing.server.pojo.Company;
import com.doing.server.service.CompanyService;

@RestController
public class CompanyServer {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(CompanyServer.class);

	@Autowired
	CompanyService service;

	@Autowired
	private HttpServletRequest request;


	@RequestMapping(value = "/companylist", method = RequestMethod.POST)
	public @ResponseBody List<Company> getCompanys(@RequestBody Company companyp) {

		List<Company> list = service.findAllCompanys(companyp);
		for (Company company : list) {
			System.out.println(company);
		}
		return list;
	}

	@RequestMapping(value = "/addcompany", method = RequestMethod.POST)
	public @ResponseBody Company addCompany(@RequestBody Company company) {
		service.saveCompany(company);
		return company;
	}
	
	@RequestMapping(value = "/updatecompany", method = RequestMethod.POST)
	public @ResponseBody Company updateCompany(@RequestBody Company company) {
		service.updateCompany(company);
		return company;
	}

	@RequestMapping(value = "/deletecompany", method = RequestMethod.POST)
	public @ResponseBody Company deleteCompany(@RequestBody Company company) {
		service.deleteCompanyById(company.getId());
		return company;
	}
	
	@RequestMapping(value = "/getcompany", method = RequestMethod.POST)
	public @ResponseBody Company findById(@RequestBody Company company) {
		service.findById(company.getId());
		return company;
	}



}
