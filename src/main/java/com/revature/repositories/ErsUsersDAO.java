package com.revature.repositories;

import java.util.List;

import com.revature.models.ErsUsers;


public interface ErsUsersDAO {

	List<ErsUsers> getAllUsers();
	List<ErsUsers> getUserId(int userId);
	ErsUsers getUserByEmail(String email);
	ErsUsers getPassword(int id);
	ErsUsers getUserRole(int ersUserId);
	boolean addUser(ErsUsers ersUser);
	public ErsUsers getUsername (String username);

	
	
}
