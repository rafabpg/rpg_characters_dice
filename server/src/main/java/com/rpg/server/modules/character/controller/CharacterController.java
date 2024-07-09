package com.rpg.server.modules.character.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rpg.server.modules.character.model.CharacterEntity;
import com.rpg.server.modules.character.service.CharacterService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/character")
public class CharacterController {
    
    @Autowired
    private CharacterService characterService;


    @PostMapping
    public ResponseEntity<Object> createCharacter(@Valid @RequestBody CharacterEntity entity) {
        
        try {
            var result = this.characterService.createCharacter(entity);
            return ResponseEntity.status(201).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error: " + e.getMessage());
        }
        
    }

    @GetMapping
    public ResponseEntity<Object> getAllCharacters() {
        try {
            var result = this.characterService.findAll();
            return ResponseEntity.status(200).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error: " + e.getMessage());
        }
    }
    
    

}
