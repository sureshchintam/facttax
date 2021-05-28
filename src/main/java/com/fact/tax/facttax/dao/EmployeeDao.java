package com.fact.tax.facttax.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fact.tax.facttax.model.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
