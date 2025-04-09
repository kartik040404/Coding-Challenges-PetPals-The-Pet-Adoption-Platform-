package com.example.petpals.exception;

public class InsufficientFundsException extends Exception{
    public InsufficientFundsException(String error){
        super(error);
    }
}
