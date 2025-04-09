package com.example.petpals.exception;

public class DetailsNotFoundException extends Exception{
    public DetailsNotFoundException(String error){
        super(error);
    }
}
