package com.revature.repositories;

import com.revature.models.ErsUsers;

import java.util.List;

public interface ErsUsersDAO {
    public List<ErsUsers> getAllUsers();
    public ErsUsers getUser(int ersUsersId);
    public boolean userLogin(String ersUsername, String ersPassword);
//    public void insert(ErsUsers user);
//    public void update(ErsUsers user);
//    public void delete(ErsUsers user);

    
}
