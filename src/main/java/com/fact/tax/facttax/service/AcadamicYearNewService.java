package com.fact.tax.facttax.service;

import org.springframework.data.domain.Page;

import com.fact.tax.facttax.model.AcademicYearNew;


public interface AcadamicYearNewService {
	
	
	public AcademicYearNew storeAcadamic(AcademicYearNew acadamic);
	
	
	public AcademicYearNew getAcademicYearNew(Integer id);
	

	    public Page<AcademicYearNew> getAcadamicBySearchCriteria(int  id);
	    }


