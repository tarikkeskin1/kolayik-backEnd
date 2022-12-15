package com.fmss.kolayik.exceptions;

public class ExpenseNotFoundException extends RuntimeException{
    public ExpenseNotFoundException(String message){
        super(message);
    }
}
