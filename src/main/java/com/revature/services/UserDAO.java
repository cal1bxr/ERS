package com.revature.services;

import com.revature.models.User;

public class UserDAO {
	public User getByUsername(String username) {
		if(username.equals("mjordan")) {
			return new User("mjordan", "Password", "Admin");
		}
		return null;
	}
}
