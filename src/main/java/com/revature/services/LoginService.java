package com.revature.services;

import com.revature.models.ErsUsers;
import com.revature.models.User;
import com.revature.models.UserDTO;
import com.revature.repositories.ErsUsersDAO;
import com.revature.repositories.ErsUsersDaoImpl;

public class LoginService {

	private ErsUsersDAO ersUserDao = new ErsUsersDaoImpl();
	
	public boolean login(UserDTO userDto) {
		ErsUsers user = ersUserDao.getUsername(userDto.username);
		if (user != null && (userDto.password.hashCode() == user.getErsPassword())) {
			return true;
		}

		return false;

	}
}
