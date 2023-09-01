package com.anvitha.securecapita.Exception;

public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }
}
