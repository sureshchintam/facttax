package com.fact.tax.facttax.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity
public class AcademicYearNew implements Serializable{
	
	@Id
	@SequenceGenerator(name="academicyr", sequenceName="ID_GENERATOR")
	@GeneratedValue(generator="academicyr")
	
	private int id;
	
	private String academic_year_new;
	
	private String created_by;
	
	private String updated_by;
	
	private Timestamp create_date_time;
	
	private Timestamp update_date_time;
	
	private String status;

	private String current_status;
	
	




	public String getAcademic_year_new() {
		return academic_year_new;
	}

	public void setAcademic_year_new(String academic_year_new) {
		this.academic_year_new = academic_year_new;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}

	public Timestamp getCreate_date_time() {
		return create_date_time;
	}

	public void setCreate_date_time(Timestamp create_date_time) {
		this.create_date_time = create_date_time;
	}

	public Timestamp getUpdate_date_time() {
		return update_date_time;
	}

	public void setUpdate_date_time(Timestamp update_date_time) {
		this.update_date_time = update_date_time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCurrent_status() {
		return current_status;
	}

	public void setCurrent_status(String current_status) {
		this.current_status = current_status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
	
/*	private Long academic_year_new_id;
	
	//@Column(name="academic_year_new")
	private String academic_year_new;
	
//	private Location createdLocation;

	//@Column(name = "created_by")
	private String created_by;

	//@Column(name = "updated_by")
	private String updated_by;
	
	//@Column(name = "create_date_time")
	private Timestamp create_date_time;
	
	//@Column(name = "update_date_time")
	private Timestamp update_date_time;
	
	@Column(name = "status")
	private String status;
	
	//@Column(name = "current_status")
	private String current_status;

	
	public Long getAcademic_year_new_id() {
		return academic_year_new_id;
	}

	public void setAcademic_year_new_id(Long academic_year_new_id) {
		this.academic_year_new_id = academic_year_new_id;
	}

	public String getAcademic_year_new() {
		return academic_year_new;
	}

	public void setAcademic_year_new(String academic_year_new) {
		this.academic_year_new = academic_year_new;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}

	public Timestamp getCreate_date_time() {
		return create_date_time;
	}

	public void setCreate_date_time(Timestamp create_date_time) {
		this.create_date_time = create_date_time;
	}

	public Timestamp getUpdate_date_time() {
		return update_date_time;
	}

	public void setUpdate_date_time(Timestamp update_date_time) {
		this.update_date_time = update_date_time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCurrent_status() {
		return current_status;
	}

	public void setCurrent_status(String current_status) {
		this.current_status = current_status;
	}


	*/
	
	

}
