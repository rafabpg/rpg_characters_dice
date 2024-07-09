package com.rpg.server.character.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rpg.server.character.model.CharacterEntity;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/character")
public class CharacterController {
    
    @PostMapping
    public ResponseEntity<Object> createCharacter(@Valid @RequestBody CharacterEntity entity) {
        
        try {
            
            return ResponseEntity.status(201).body(entity);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error: " + e.getMessage());
        }
        
    }
    

}
