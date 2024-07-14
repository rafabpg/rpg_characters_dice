package com.rpg.server.modules.campain.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rpg.server.modules.campain.DTO.CampainRequestDTO;
import com.rpg.server.modules.campain.service.CampainService;

import org.springframework.web.bind.annotation.RequestHeader;
import jakarta.validation.Valid;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/campain")
public class CampainController {


    @Autowired
    private CampainService campainService;
    
    @PostMapping
    public ResponseEntity<Object> createCampain(@Valid @RequestBody CampainRequestDTO entity, @RequestHeader(name = "Authorization") String token) {
        try {
            var result = this.campainService.createCampain(entity, token);
            return ResponseEntity.status(201).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error: " + e.getMessage());
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable UUID id) {
        try {
            var result = this.campainService.findById(id);
            return ResponseEntity.status(200).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error: " + e.getMessage());
        }
    }
    
    @GetMapping
    public ResponseEntity<Object> getByUsername(@RequestHeader(name = "Authorization") String token) {
       try {
            var result = this.campainService.findByUsername(token);
            return ResponseEntity.status(200).body(result);
       } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error: " + e.getMessage());
       }
    }
    


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable UUID id) {
        try {
            this.campainService.deleteCampain(id);
            return ResponseEntity.status(200).body("Delete Sucessful");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error: " + e.getMessage());
        }
    }

}
