package com.thrillio.sasi.managers;

import com.thrillio.sasi.dao.UserDao;
import com.thrillio.sasi.entities.User;

public class UserManager {
	// implementing singleton -- only one object needs to be created , global point
	// of access
	private static UserManager instance = new UserManager();
	private static UserDao userDao = new UserDao();

	// implementing constructor as private ensures , the client cannot be
	// instantiated
	private UserManager() {

	}

	// one cannot create instance it needs to be static method --singleton pattern
	public static UserManager getInstance() {
		return instance;

	}

	public User createUser(long id, String email, String password, String firstName, String lastName, int gender,
			String userType) {
		User user = new User();
		user.setId(id);
		user.setEmail(email);
		user.setPassword(password);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setGender(gender);
		user.setUserType(userType);

		return user;
	}

	public User[] getUsers() {
		return userDao.getUsers();
	}
}
