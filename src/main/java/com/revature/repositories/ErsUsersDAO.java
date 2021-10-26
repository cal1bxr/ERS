package com.revature.repositories;

import java.util.List;

import com.revature.models.ErsUserRoles;
import com.revature.models.ErsUsers;

public interface ErsUsersDAO {

	List<ErsUsers> getAllUsers();

	ErsUsers getUser(int ersUsersId);
	public boolean addErsUser(ErsUsers ersUser);
	public boolean addErsUserRoles(ErsUserRoles ersUser);
	

//	ErsUsers getByUsername(String username);
}
