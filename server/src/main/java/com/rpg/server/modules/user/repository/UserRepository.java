package com.rpg.server.modules.user.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rpg.server.modules.character.model.CharacterEntity;
import com.rpg.server.modules.user.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel,String> {
    
    Optional<UserModel> findByUsername(String username);
    Optional<UserModel> findByEmail(String email);

}
