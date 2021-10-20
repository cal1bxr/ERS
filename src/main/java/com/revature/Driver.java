package com.revature;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class Driver {

    private static Logger log = LoggerFactory.getLogger(Driver.class);
    private static ReimbursementController reimbControl =
            new ReimbursementController();

    public static void main(String[] args){
        EmployeeDAOIMPL employeeDAOIMPL = new EmployeeDAOIMPL();
//        employeeDAOIMPL.addUser(Employee employee);
        reimbControl.displayAllTickets();
    }
}
