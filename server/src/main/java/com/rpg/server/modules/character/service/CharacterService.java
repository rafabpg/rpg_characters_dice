package com.rpg.server.modules.character.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rpg.server.exceptions.CharacterNotFound;
import com.rpg.server.modules.character.model.CharacterEntity;
import com.rpg.server.modules.character.repository.CharacterRepository;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    public CharacterEntity createCharacter(CharacterEntity character) {
        return this.characterRepository.save(character);
    }

    public void deleteCharacter(UUID id) {
        this.characterRepository.findById(id).ifPresent(characterEntity -> characterRepository.delete(characterEntity));
        throw new CharacterNotFound();
    }

    public List<CharacterEntity> findAll() {
        return this.characterRepository.findAll();
    }

    public CharacterEntity findById(UUID id) {
        return this.characterRepository.findById(id).orElse(null);
    }

    public List<CharacterEntity> findByRace(String race) {
        return this.characterRepository.findByRace(race);
    }

    public List<CharacterEntity> findByCharacterClass(String characterClass) {
        return this.characterRepository.findByCharacterClass(characterClass);
    }


}
