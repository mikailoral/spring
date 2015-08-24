package com.doing.server.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	private static final Logger logger = Logger.getLogger(CompanyServer.class);

	@Autowired
	CompanyService service;

	@Autowired
	private HttpServletRequest request;

	@RequestMapping(value = "/company", method = RequestMethod.GET)
	public @ResponseBody Company getMood() {

		Company mood = new Company();
		mood.setId(1);
		mood.setName("name");
		System.out.println(mood);
		return mood;
	}

	@RequestMapping(value = "/companylist", method = RequestMethod.GET)
	public @ResponseBody List<Company> getMoods() {
		logger.debug("xxxxxx/ntestdebug");
		logger.error("xxxxxx/ntesterror");

		List<Company> list = service.findAllCompanies();
		for (Company company : list) {
			logger.error("xxxxxx/n" + company);
		}
		return list;
	}

	@RequestMapping(value = "/addcompany", method = RequestMethod.POST)
	public @ResponseBody Company addMood(@RequestBody Company company) {
		logger.debug(company);
		System.out.println("companyxxxxxx/n" + company);
		service.saveCompany(company);
		return company;
	}

	// get user agent
	private String getUserAgent() {
		return request.getHeader("user-agent");
	}

	// get request headers
	@RequestMapping(value = "/map", method = RequestMethod.POST)
	private @ResponseBody Map<String, String> getHeadersInfo() {

		Map<String, String> map = new HashMap<String, String>();

		Enumeration headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			map.put(key, value);
		}

		return map;
	}

}
