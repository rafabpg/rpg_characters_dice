package com.rpg.server.modules.character.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rpg.server.modules.character.model.CharacterEntity;


public interface CharacterRepository  extends JpaRepository<CharacterEntity,UUID>{
    
    Optional<CharacterEntity> findById(UUID id);
    List<CharacterEntity> findByRace(String race);
    List<CharacterEntity> findByCharacterClass(String characterClass);
    List<CharacterEntity> findCharacterEntitiesByUsername(String username);
    
}
