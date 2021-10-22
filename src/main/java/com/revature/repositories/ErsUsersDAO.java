package com.revature.repositories;

import java.util.List;

import com.revature.models.ErsUsers;

public interface ErsUsersDAO {

	public List<ErsUsers> getAllUsers();

	public ErsUsers getUser(int ersUsersId);

	public ErsUsers getByUsername(String username);
}
