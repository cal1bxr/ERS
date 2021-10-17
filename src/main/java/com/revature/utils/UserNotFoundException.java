package com.revature.utils;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String errorMessage, Throwable error){
        super(errorMessage);
    }
}
