package com.fact.tax.facttax.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	private String firstName;
	private String lastName;
	@Transient	
	private List <AdminUser>  doucmentLevelUsers;

	public String getLevel() {
		return level;
	}
	public List<AdminUser> getDoucmentLevelUsers() {
		return doucmentLevelUsers;
	}
	public void setDoucmentLevelUsers(List<AdminUser> doucmentLevelUsers) {
		this.doucmentLevelUsers = doucmentLevelUsers;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	private String level;
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private String mobile;
	private String email;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	private String password;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
