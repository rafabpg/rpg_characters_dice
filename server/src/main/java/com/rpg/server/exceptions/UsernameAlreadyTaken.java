package com.rpg.server.exceptions;

public class UsernameAlreadyTaken extends RuntimeException {
    
    public UsernameAlreadyTaken(){
        super("Username Already Taken");
    }
}
