package com.fact.tax.facttax.service;

import java.util.List;

import com.fact.tax.facttax.model.AdminUser;
import com.fact.tax.facttax.model.User;

public interface UserService {
public  User createUser(User user);
public  User findByUser(String email,String password);
public  AdminUser findByAdminUser(String email,String password);
public  List<User> findByUsersByLevel(List<Integer> custIds);
public List<User> findAllUsers();
public List<AdminUser> getAdminUsersByDocumentLevel(String levelName);
}
