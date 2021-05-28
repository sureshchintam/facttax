package com.fact.tax.facttax.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fact.tax.facttax.dao.EmployeeDao;
import com.fact.tax.facttax.model.Employee;
import com.fact.tax.facttax.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao dao;

	@Override
	public Employee storeEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Employee e=dao.save(employee);
		return e;
	}

}
