package com.rpg.server.modules.character.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rpg.server.exceptions.CharacterNotFound;
import com.rpg.server.exceptions.UserNotFound;
import com.rpg.server.modules.character.model.CharacterEntity;
import com.rpg.server.modules.character.repository.CharacterRepository;
import com.rpg.server.modules.user.repository.UserRepository;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private UserRepository userRepository;

    public CharacterEntity createCharacter(CharacterEntity character) {
        this.userRepository.findByUsername(character.getUsernameId()).orElseThrow(
            () -> new UserNotFound()
        );
        return this.characterRepository.save(character);
    }

    public void deleteCharacter(UUID id) {
        var characterOptional = this.characterRepository.findById(id);
        if (characterOptional.isPresent()) {
            this.characterRepository.delete(characterOptional.get());
        } else {
            throw new CharacterNotFound();
        }
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
