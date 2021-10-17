package com.revature.daos;

import com.revature.models.Employee;
import com.revature.utils.UserNotFoundException;

public interface EmployeeDAO {
    boolean login(String username, String password) throws UserNotFoundException;
    public boolean addUser(Employee employee);


}
