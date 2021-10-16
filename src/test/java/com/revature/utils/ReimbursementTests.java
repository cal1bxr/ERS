package com.revature.utils;


import com.revature.daos.ReimbursementDAOImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReimbursementTests {
    public static ReimbursementDAOImpl reimbursementDAOimpl;
    public static Logger log = LoggerFactory.getLogger(ReimbursementTests.class);
    public static String username;
    public static String password;
    public static String userRole;
    public static int userRoleID;
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

    @BeforeAll
    public void setTestUser(){
        String username = "mjordan";
        String password = "Password";
        String userRole = "admin";
        log.info("Setting up variables for testing");
    }

    @BeforeAll
    public void setTestReimbursement(){}

    @Test
    public void testLogin(){}

    @Test
    public void testViewPastTickets(){}

    @Test
    public void testSubmitReimbursement(){}

    @Test
    public void testViewAllReimbursement(){}

    @Test
    public void testReimbursementApproval(){}

    @Test
    public void testRequestFilter(){}

    @AfterEach
    public void clearResult(){}

    @AfterAll
    public static void clearReimbursementDAOImpl(){}


}



