package com.rpg.server.exceptions;

public class UserNotFound extends RuntimeException{
    
    public UserNotFound(){
        super("User not Found");
    }

}
