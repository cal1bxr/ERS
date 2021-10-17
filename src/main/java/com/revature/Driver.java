package com.revature;

import com.revature.daos.EmployeeDAOIMPL;
import com.revature.models.Employee;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.slf4j.MDC;

public class Driver {

    private static Logger log = LoggerFactory.getLogger(Driver.class);

    public static void main(String[] args){
        EmployeeDAOIMPL employeeDAOIMPL = new EmployeeDAOIMPL();
//        employeeDAOIMPL.addUser(Employee employee);
    }
}
