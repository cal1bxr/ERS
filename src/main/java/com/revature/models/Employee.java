package com.revature.models;

import java.util.Objects;

public class Employee {
    private int userID;
    private String username;
    private String password;
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private int userRoleID;
    private String userRole;

    public Employee(int userID, String username, String password, String userFirstName, String userLastName, String userEmail, int userRoleID, String userRole) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userRoleID = userRoleID;
        this.userRole = userRole;
    }

    public Employee(int userID, String username, String password, String userFirstName, String userLastName, String userEmail, int userRoleID) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userRoleID = userRoleID;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getUserRoleID() {
        return userRoleID;
    }

    public void setUserRoleID(int userRoleID) {
        this.userRoleID = userRoleID;
    }


}
