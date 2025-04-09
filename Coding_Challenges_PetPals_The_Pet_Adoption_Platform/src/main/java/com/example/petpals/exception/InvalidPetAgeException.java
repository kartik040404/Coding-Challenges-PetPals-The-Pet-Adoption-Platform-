package com.example.petpals.exception;

public class InvalidPetAgeException extends Exception{
    public InvalidPetAgeException(String error){
        super(error);
    }
}
