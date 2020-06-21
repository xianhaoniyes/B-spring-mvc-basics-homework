package com.thoughtworks.capacity.gtb.mvc.exception;

public class MismatchException extends Exception{

    public MismatchException(){
        super("Username or password wrong");
    }
}
