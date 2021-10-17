package com.revature.daos;

import com.revature.utils.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeDAOIMPL implements EmployeeDAO{
    private static Logger log = LoggerFactory.getLogger(EmployeeDAOIMPL.class);
    @Override
    public boolean login(String username, String password) throws UserNotFoundException {
        try{
            log.info("User logged in");

        } catch(UserNotFoundException e){

        }
        return false;
    }
}
