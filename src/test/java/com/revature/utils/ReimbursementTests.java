package com.revature.utils;


import com.revature.daos.EmployeeDAOIMPL;
import com.revature.daos.ReimbursementDAOImpl;
import com.revature.models.Employee;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReimbursementTests {
    public static ReimbursementDAOImpl reimbursementDAOimpl;
    public static EmployeeDAOIMPL employeeDAO;
    public static Employee employee;
    public static Logger log = LoggerFactory.getLogger(ReimbursementTests.class);
    public static String username;
    public static String password;
    public static String userRole;
    public static int userRoleID;
    public static int userID;
    public static String userFirstName;
    public static String userLastName;
    public static String userEmail;
    public static int reimbID;
    public static float reimbAmount;
    public static int reimbAuthor;
    public static int reimbStatusID;
    public static int reimbTypeID;
    public static String reimbStatus;
    public static String reimbType;


    @BeforeAll
    public static void setReimbursementDAOImpl(){
        reimbursementDAOimpl = new ReimbursementDAOImpl();
    }
    public static void setEmployeeDAOIMPL() {employeeDAO = new EmployeeDAOIMPL();}
    public static void setEmployee() {employee = new Employee(userID, username, password, userFirstName, userLastName, userEmail, userRoleID, userRole);
    }

    @BeforeAll
    public static void setTestUser(){
        int userID = 3;
        String username = "Testm";
        String password = "Password";
        String userFirstName = "Matt";
        String userLastName = "Jordan";
        String userEmail = "someone@someemail.com";
        int userRoleID = 2;
        String userRole = "admin";
        log.info("Setting up variables for testing");
    }

//    @BeforeAll
//    public void setTestReimbursement(){}

    @Test
    public void testAddUser() {
        log.info("in test addUser");
        try (Connection conn = ConnectionUtil.getConnection()){
            boolean result = employeeDAO.addUser(employee);
            assertTrue(result==true);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
//    @Test
//    public void testLogin(){}
//
//    @Test
//    public void testViewPastTickets(){}
//
//    @Test
//    public void testSubmitReimbursement(){}
//
//    @Test
//    public void testViewAllReimbursement(){}
//
//    @Test
//    public void testReimbursementApproval(){}
//
//    @Test
//    public void testRequestFilter(){}
//
//    @AfterEach
//    public void clearResult(){}
//
//    @AfterAll
//    public static void clearReimbursementDAOImpl(){}
//

}



