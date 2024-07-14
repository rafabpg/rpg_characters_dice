package com.rpg.server.modules.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rpg.server.exceptions.UserNotFound;
import com.rpg.server.exceptions.UsernameAlreadyTaken;
import com.rpg.server.modules.character.model.CharacterEntity;
import com.rpg.server.modules.character.repository.CharacterRepository;
import com.rpg.server.modules.user.model.UserModel;
import com.rpg.server.modules.user.repository.UserRepository;
import com.rpg.server.providers.JwtProvider;

@Service
public class UserService {
    
    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtProvider jwtProvider;

    public UserModel createUser(UserModel user){
        this.userRepository.findByUsername(user.getUsername()).ifPresent((userEntity)-> {
            throw new UsernameAlreadyTaken();
        });
        String password_hash = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(password_hash);
        return this.userRepository.save(user);
    }
    
    public UserModel findByUsername(String token) {
        String userId = this.jwtProvider.validateToken(token);
        return this.userRepository.findByUsername(userId).orElse(null);
    }

    public void deleteUser(String token) {
        String userId = this.jwtProvider.validateToken(token);
        this.userRepository.findByUsername(userId).orElseThrow(
            () -> new UserNotFound()
        );
        this.userRepository.deleteById(userId);
    }

    public List<CharacterEntity> getCharacters(String token) {
        String userId = this.jwtProvider.validateToken(token);
        return this.characterRepository.findByUsernameId(userId).orElse(null);
    }

}
