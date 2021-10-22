package com.revature.services;

import com.revature.models.ErsUsers;
import com.revature.models.UserDTO;
import com.revature.repositories.ErsUsersDAO;
import com.revature.repositories.ErsUsersDaoImpl;

public class LoginService {

	private ErsUsersDAO ersUser = new ErsUsersDaoImpl();

	public boolean login(UserDTO userDto) {
		ErsUsers ersUser = ersUser.getErsUsername();
		if (ersUsername != null && (userDto.password.hashCode() == ersUser.getPassword())) {
			return true;
		}

		return false;

	}
}
