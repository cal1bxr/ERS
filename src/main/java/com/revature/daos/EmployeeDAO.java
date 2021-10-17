package com.revature.daos;

import com.revature.utils.UserNotFoundException;

public interface EmployeeDAO {
    boolean login(String username, String password) throws UserNotFoundException;

}
