package com.fact.tax.facttax.model;

public class AdminLevel {
public int custId;
public int adminId;
public AdminLevel() {
	
}
public AdminLevel(int custId) {
	this.custId=custId;
}
public int getCustId() {
	return custId;
}
public void setCustId(int custId) {
	this.custId = custId;
}
public int getAdminId() {
	return adminId;
}
public void setAdminId(int adminId) {
	this.adminId = adminId;
}
}
