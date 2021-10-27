package com.revature.repositories;

import java.util.List;

import com.revature.models.ErsUsers;

public interface ErsUsersDAO {

	List<ErsUsers> getAllUsers();

	ErsUsers getUser(int ersUsersId);

//	ErsUsers getByUsername(String username);
}
