package com.thoughtworks.capacity.gtb.mvc.exception;

public class UserExistException extends Exception{
    public UserExistException(){
        super("The user is already existed");
    }
}
