package com.lirchis.blogapi.exception;

public class LoginException extends RuntimeException{

    public LoginException(){};

    public LoginException(String msg){
        super(msg);
    }

    public LoginException(String msg,Throwable cause){
        super(msg,cause);
    }

}
