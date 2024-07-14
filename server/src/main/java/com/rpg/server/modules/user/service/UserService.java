package com.rpg.server.modules.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rpg.server.exceptions.UserNotFound;
import com.rpg.server.exceptions.UsernameAlreadyTaken;
import com.rpg.server.modules.user.model.UserModel;
import com.rpg.server.modules.user.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserModel createUser(UserModel user){
        this.userRepository.findByUsername(user.getUsername()).ifPresent((userEntity)-> {
            throw new UsernameAlreadyTaken();
        });
        String password_hash = this.passwordEncoder.encode(user.getPassword());
        user.setPassword(password_hash);
        return this.userRepository.save(user);
    }
    
    public UserModel findByUsername(String username) {
        return this.userRepository.findByUsername(username).orElse(null);
    }

    public void deleteUser(String username) {
        this.userRepository.findByUsername(username).orElseThrow(
            () -> new UserNotFound()
        );
        this.userRepository.deleteById(username);
    }

}
