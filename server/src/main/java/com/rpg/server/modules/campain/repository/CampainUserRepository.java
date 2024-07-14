package com.rpg.server.modules.campain.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rpg.server.modules.campain.model.CampainUserModel;

public interface CampainUserRepository extends JpaRepository<CampainUserModel, UUID>{

    Optional<List<CampainUserModel>> findByUserId(String userId);
    Optional<CampainUserModel> findByCampainId(UUID campainId);
    void deleteByCampainId(UUID campainId);

}
