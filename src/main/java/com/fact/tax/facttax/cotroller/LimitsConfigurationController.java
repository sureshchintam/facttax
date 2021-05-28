package com.fact.tax.facttax.cotroller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.mockito.internal.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fact.tax.facttax.Configuration;
import com.fact.tax.facttax.LimitConfiguration;
import com.fact.tax.facttax.dao.AdminRepository;
import com.fact.tax.facttax.model.AdminLevel;
import com.fact.tax.facttax.model.AdminUser;
import com.fact.tax.facttax.model.User;
import com.fact.tax.facttax.model.UserRegistration;
import com.fact.tax.facttax.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LimitsConfigurationController {

	@Autowired
	private Configuration configuration;
	@Autowired
	private UserService userService;
	@Autowired
	private AdminRepository adminRepo;

	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromConfiguration() {

		return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());

	}

	@PostMapping("/userRegistration")
	public User createUser(@RequestBody UserRegistration userRegistration) {

		System.out.println("call userRegistraion = " + userRegistration.getFirstName());
		User user = new User();
		user.setFirstName(userRegistration.getFirstName());
		user.setLastName(userRegistration.getLastName());
		user.setPassword(userRegistration.getPassword());
		user.setEmail(userRegistration.getEmail());
		user.setMobile(userRegistration.getMobile());
		return userService.createUser(user);
		// return ResponseEntity.created(location).build();

	}

	@RequestMapping(value = "/customerUserLogin", method = RequestMethod.GET)
	public User userLoginCheck(@RequestParam("email") String email, @RequestParam("password") String password) {

		System.out.println("call login ");

		return userService.findByUser(email, password);
		// return ResponseEntity.created(location).build();

	}

	@RequestMapping(value = "/adminUserLogin", method = RequestMethod.GET)
	public AdminUser adminUserLoginCheck(@RequestParam("email") String email,
			@RequestParam("password") String password) {

		System.out.println("call AdminLogin ");
		AdminUser adminUser=  userService.findByAdminUser(email, password);
		return adminUser;
		// return ResponseEntity.created(location).build();

	}

	@RequestMapping(value = "/usersAllByLevel", method = RequestMethod.GET)
	public List<User> userAll(@RequestParam("level") String level,@RequestParam("adminId") String adminId)

	 {

		System.out.println("call All   level" + level);
		int levelCount=0;
		if (level.equals("Registration")) {
			levelCount=1;
		} else if (level.equalsIgnoreCase("Document")) {
			levelCount=2;
			
		} else if (level.equalsIgnoreCase("Preparation")) {
			levelCount=3;

		} else if (level.equalsIgnoreCase("QC")) {
			levelCount=4;

		} else if (level.equalsIgnoreCase("Payment")) {
			levelCount=5;

		} else if (level.equalsIgnoreCase("Filling")) {
			levelCount=6;


		} else if (level.equalsIgnoreCase("Completed")) {
			levelCount=7;


		}


		
		if (levelCount==1) {

			List<AdminUser> documentLevelUsersList= userService.getAdminUsersByDocumentLevel("Document");

			List<User> usersList=  userService.findAllUsers();
			List<User>allUsersList= new ArrayList<>();
			for(User userObj :usersList) {
				List<String> levelId = adminRepo.getUserLevelId(userObj.getId());
				if (levelId.get(0).equals("1")) {
					userObj.setLevel("Registration");
					userObj.setDoucmentLevelUsers(documentLevelUsersList);
							
				} else if (levelId.get(0).equalsIgnoreCase("2")) {
					userObj.setLevel("Documents");
				} else if (levelId.get(0).equalsIgnoreCase("3")) {
					userObj.setLevel("Preparation");

				} else if (levelId.get(0).equalsIgnoreCase("4")) {
					userObj.setLevel("QC");

				} else if (levelId.get(0).equalsIgnoreCase("5")) {
					userObj.setLevel("Payment");

				} else if (levelId.get(0).equalsIgnoreCase("6")) {
					userObj.setLevel("Filling");


				} else if (levelId.get(0).equalsIgnoreCase("7")) {
					userObj.setLevel("Completed");


				}


				allUsersList.add(userObj);
				
			}

			
			return allUsersList;
		} else {
			List<String> custIds = adminRepo.getCustomerIds(levelCount,adminId);
			List<Integer> Ids = new ArrayList<>();
			custIds.forEach(cust -> {
				Ids.add(Integer.parseInt(cust));
			});
			List<User> selectedUsers = userService.findByUsersByLevel(Ids);
			List<User>updateUsersList=new ArrayList<>();
			for(User userObj :selectedUsers) {
				userObj.setLevel(level);
				updateUsersList.add(userObj);
				
			}
			
			System.out.println("user size " + updateUsersList.size());
			return updateUsersList;
			// return userService.findAllUsers();

			// return ResponseEntity.created(location).build();
		}
		// return null;
	}

	@RequestMapping(value = "/movedToNextLevel", method = RequestMethod.GET)
	public boolean movedToNextLevel(@RequestParam("customers") String customers,@RequestParam("level") String level,@RequestParam("documentUserIds") String documentUserIds) {
		int levelCount=1;
		
		System.out.println("document users= "+documentUserIds);
		if (level.equals("Registration")) {
			levelCount=levelCount+1;
		} else if (level.equalsIgnoreCase("Documents")) {
			levelCount=levelCount+2;
		} else if (level.equalsIgnoreCase("Preparation")) {
			levelCount=levelCount+3;

		} else if (level.equalsIgnoreCase("QC")) {
			levelCount=levelCount+4;

		} else if (level.equalsIgnoreCase("Payment")) {
			levelCount=levelCount+5;

		} else if (level.equalsIgnoreCase("Filling")) {
			levelCount=levelCount+6;


		} else if (level.equalsIgnoreCase("Completed")) {
			levelCount=levelCount+7;


		}

		System.out.println("call move next    level" + level + " ids= " + customers);
		String[] customersList = customers.split(",");
		int[] documentUsers=null;
		if(documentUserIds==null || documentUserIds.isEmpty()) {
			documentUsers[0]=1;
		}else {
		String[] documentUserIdsList=documentUserIds.split(",");
		documentUsers=Arrays.asList(documentUserIdsList).stream().mapToInt(Integer::parseInt).toArray();

		}
		// intarray[i]=Integer.parseInt(customersList.trim()); // No more Exception in
		// this line

		int[] array = Arrays.asList(customersList).stream().mapToInt(Integer::parseInt).toArray();
		int count = adminRepo.updateLevelForCustmers(array, levelCount,documentUsers);
		// return userService.findAllUsers();

		// return ResponseEntity.created(location).build();

		// return null;
		return true;
	}


}
