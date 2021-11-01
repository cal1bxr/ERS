package com.revature.services;

import java.util.List;

import com.revature.models.ErsUsers;
import com.revature.models.UserDTO;
import com.revature.repositories.ErsUsersDAO;
import com.revature.repositories.ErsUsersDaoImpl;


public class ErsUsersService {

		private ErsUsersDAO usersDao = new ErsUsersDaoImpl();
		
		public List<ErsUsers> findAllUsers(){
			return usersDao.getAllUsers();
		}
		
		public List<ErsUsers> getUserById(int ersUsersId) {
			List<ErsUsers> user = usersDao.getUserId(ersUsersId);
			if(user != null) {
				return user;
			} else {
				return null;
			}
		}
		
		public ErsUsers getUserByEmail(String ersEmail) {
			ErsUsers user = usersDao.getUserByEmail(ersEmail);
			if(user != null) {
				return user;
			} else {
				return null;
			}
		}
		
		public ErsUsers getUserPass(int ersUsersId) {
			return usersDao.getPassword(ersUsersId);	
		}
		
		public boolean addUser(ErsUsers user){
			return usersDao.addUser(user);
		}
		
		public boolean login(UserDTO userDto) {
			return true;
		}
		
		public ErsUsers getUserByUsername(String ersUsername){
			ErsUsers user = usersDao.getUsername(ersUsername);
			if(user != null) {
				return user;
			} else {
				return null;
			}
		}
		
		public ErsUsers getUserRole(int ersUsersId) {
			return usersDao.getUserRole(ersUsersId);
		}
}
