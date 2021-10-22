package com.revature.services;

import java.util.List;

import com.revature.models.ErsUsers;
import com.revature.models.UserDTO;
import com.revature.repositories.ErsUsersDAO;
import com.revature.repositories.ErsUsersDaoImpl;

public class ErsUsersService {

		private ErsUsersDAO usersDao = new ErsUsersDaoImpl();
		
		public List<ErsUsers> getAllUsers(){
			return usersDao.getAllUsers();
		}
		
		public ErsUsers getUserById(int ersUsersId) {
			return usersDao.getUser(ersUsersId);
		}
		
		public boolean login(UserDTO userDto) {
			return true;
		}
}
