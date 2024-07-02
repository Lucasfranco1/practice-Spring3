package com.retomando.demo.authentication.exceptions;

public class ParamBadRequest extends RuntimeException{

    public ParamBadRequest(String message){
        super(message);
    }
}
