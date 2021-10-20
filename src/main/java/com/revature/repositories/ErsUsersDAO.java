package com.revature.repositories;

import com.revature.models.ErsUsers;

import java.util.List;

public interface ErsUsersDAO {
    public List<ErsUsers> getAllUsers();
    public boolean userLogin();
    public String addUserName();
    public String addFirstName();
    public String addLastName();
    public String addUserEmail();
    public String createPassword();
}
