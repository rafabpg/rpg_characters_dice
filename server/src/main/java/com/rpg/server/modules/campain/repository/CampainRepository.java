package com.rpg.server.modules.campain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rpg.server.modules.campain.model.CampainModel;

public interface CampainRepository  extends JpaRepository<CampainModel,UUID>{
    
    

}
