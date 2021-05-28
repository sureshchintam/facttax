package com.fact.tax.facttax.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fact.tax.facttax.dao.AdminRepository;
import com.fact.tax.facttax.model.AdminLevel;
import com.fact.tax.facttax.model.AdminUser;
import com.fact.tax.facttax.model.User;
import com.fact.tax.facttax.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	com.fact.tax.facttax.dao.UserRepository userRepo;
	@Autowired
	AdminRepository adminRepo;
	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		User userObj =userRepo.save(user);
		AdminLevel adminLevel= new AdminLevel();
		adminLevel.setCustId(userObj.getId());
		adminLevel.setAdminId(1);
		
		adminRepo.saveCustAdminLevel(adminLevel);
		return userObj;
	}
	@Override
	public User findByUser(String email, String password) {
		// TODO Auto-generated method stub
		return userRepo.findUserByStatusAndName(email, password);
		//return null;
	}
	@Override
	public List<User> findAllUsers() {
		return userRepo.findAll();
	
	}
	@Override
	public List<User> findByUsersByLevel( List<Integer> custIds) {
		// TODO Auto-generated method stub
	   
	  //  return null;
		return userRepo.findUsersByLevel(custIds);
	}
	@Override
	public AdminUser findByAdminUser(String email, String password) {
		// TODO Auto-generated method stub
		return userRepo.findByAdminUser(email,password);
	}
	@Override
	public List<AdminUser> getAdminUsersByDocumentLevel(String levelName) {
		// TODO Auto-generated method stub
		return userRepo.getAdminUsersByDocumentLevel(levelName);
	}
	
	
	

}
