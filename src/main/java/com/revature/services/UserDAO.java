package com.revature.services;

import com.revature.models.User;
import com.revature.repositories.ErsUsersDAO;
import com.revature.repositories.ErsUsersDaoImpl;

public class UserDAO {
	
	private static ErsUsersDAO ersUserDao = new ErsUsersDaoImpl();

	public User getByUsername(String username) {
		if(username.equals("mjordan")) {
			return new User("mjordan", "Password".hashCode(), "Admin");
		}
		return null;
	}
}
