package com.fact.tax.facttax.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.fact.tax.facttax.dao.AcadamicYearDao;
import com.fact.tax.facttax.model.AcademicYearNew;
import com.fact.tax.facttax.service.AcadamicYearNewService;



@Service
public class AcadamicYearNewServiceImpl implements AcadamicYearNewService{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private AcadamicYearDao acadamicDao;
	
	@Override
	public AcademicYearNew storeAcadamic(AcademicYearNew acadamic) {
		// TODO Auto-generated method stub
		AcademicYearNew acadamics=acadamicDao.save(acadamic);
		
		
		return acadamics;
	}
	
	 
	
	
	
	

	@Override
	public AcademicYearNew getAcademicYearNew(Integer id) {
		// TODO Auto-generated method stub
		
		AcademicYearNew acadamicYear=null;
		try
		{
			logger.info("Academic year service impl.getAcadamic year");
			acadamicYear=acadamicDao.findById(id).get();
		}
		
		catch(Exception e)
		{
			logger.info("Academic year serviceimpl.getAcadamic year Acadamic year id" + id + "catch the exception -->" + e.getMessage());
		}
		
		return acadamicYear;
	}







	@Override
	public Page<AcademicYearNew> getAcadamicBySearchCriteria(int id) {
		// TODO Auto-generated method stub
		return null;
	}


}
