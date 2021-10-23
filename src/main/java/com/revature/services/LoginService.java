package com.revature.services;

import com.revature.models.ErsUsers;
import com.revature.models.User;
import com.revature.models.UserDTO;
import com.revature.repositories.UserDAO;

public class LoginService {

	private UserDAO userDao = new UserDAO();
	
	public boolean login(UserDTO userDto) {
		User user = userDao.getByUsername(userDto.username);
		if (user != null && (userDto.password.hashCode() == user.getPassword())) {
			return true;
		}

		return false;

	}
}
