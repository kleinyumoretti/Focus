package com.klein.Exception;

public class RegisterException extends RuntimeException{
    public RegisterException(){}

    public RegisterException(String msg){
        super(msg);
    }
}
