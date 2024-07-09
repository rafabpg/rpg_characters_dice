package com.rpg.server.exceptions;

public class CharacterNotFound extends RuntimeException{
    
    public CharacterNotFound() {
        super("Character Not Found");
    }

}
