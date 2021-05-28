package com.fact.tax.facttax.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fact.tax.facttax.model.AcademicYearNew;
@Repository
public interface AcadamicYearDao extends JpaRepository<AcademicYearNew, Integer>{

	@Query("from AcademicYearNew a where a.id=?")
	public AcademicYearNew findAcadamicYearById(int id);
	
}
