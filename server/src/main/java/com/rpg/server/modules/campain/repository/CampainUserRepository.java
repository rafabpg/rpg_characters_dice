package com.rpg.server.modules.campain.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rpg.server.modules.campain.model.CampainUserModel;

public interface CampainUserRepository extends JpaRepository<CampainUserModel, UUID>{

    Optional<CampainUserModel> findByCampainId(UUID campainId);
    void deleteByCampainId(UUID campainId);
    Optional<CampainUserModel> findByUserId(String userId);

}
