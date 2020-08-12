package com.railway.managers;

import java.util.List;

import com.railway.constants.Gender;
import com.railway.constants.UserType;
import com.railway.dao.UserDao;
import com.railway.entites.User;



public class UserManager {
		private static UserDao dao=new UserDao();
	private static UserManager instance = new UserManager();
		
	private UserManager() {
		
	}

	public static UserManager getInstance() {
		return instance;
	}

	public User createUser(long id, String email, String password, String firstName, String lastName, Gender gender,
			UserType userType,long phoneNo) {
		User user = new User();
		user.setUserId(id);
		user.setEmail(email);
		user.setPassword(password);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setGender(gender);
		user.setUserType(userType);
		user.setPhoneNo(phoneNo);
		return user;

	}

	

	public Long authenticate(String email, String password) {
		return dao.authenticate(email, password);
	}

}
