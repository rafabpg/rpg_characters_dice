package com.rpg.server.modules.campain.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rpg.server.modules.campain.DTO.CampainRequestDTO;
import com.rpg.server.modules.campain.service.CampainService;

import org.springframework.web.bind.annotation.RequestHeader;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


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
    

}
