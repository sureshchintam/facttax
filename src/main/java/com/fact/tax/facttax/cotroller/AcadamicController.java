package com.fact.tax.facttax.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fact.tax.facttax.model.AcademicYearNew;
import com.fact.tax.facttax.model.Employee;
import com.fact.tax.facttax.service.AcadamicYearNewService;
import com.fact.tax.facttax.service.EmployeeService;
import com.google.common.net.MediaType;

@RestController
@RequestMapping(value="api")
@CrossOrigin(origins = {"*"},
methods= { RequestMethod.GET,
		RequestMethod.POST,
		RequestMethod.DELETE,
		RequestMethod.PUT
		
}
		)

public class AcadamicController{

@Autowired
private AcadamicYearNewService acadamicService;
@Autowired
private EmployeeService empService;

@RequestMapping(value="acadamic", method=RequestMethod.POST,consumes=org.springframework.http.MediaType.APPLICATION_JSON_VALUE,produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Object> store(@RequestBody AcademicYearNew acadamic)
{
	
	ResponseEntity<Object> response=null;
	AcademicYearNew acadamicObj= acadamicService.storeAcadamic(acadamic);
	response=ResponseEntity.status(200).body(acadamicObj);
	return response;
	
}

@RequestMapping(value="employee", method=RequestMethod.POST,consumes=org.springframework.http.MediaType.APPLICATION_JSON_VALUE,produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Object> storeEmp(@RequestBody Employee emp)
{
	
	ResponseEntity<Object> response=null;
	Employee e= empService.storeEmployee(emp);
	response=ResponseEntity.status(200).body(e);
	return response;
	
}



}
