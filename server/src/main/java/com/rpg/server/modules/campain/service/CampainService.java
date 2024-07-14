package com.rpg.server.modules.campain.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rpg.server.exceptions.UserNotFound;
import com.rpg.server.modules.campain.DTO.CampainRequestDTO;
import com.rpg.server.modules.campain.model.CampainModel;
import com.rpg.server.modules.campain.model.CampainUserModel;
import com.rpg.server.modules.campain.repository.CampainRepository;
import com.rpg.server.modules.campain.repository.CampainUserRepository;
import com.rpg.server.modules.user.repository.UserRepository;
import com.rpg.server.providers.JwtProvider;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CampainService {

    private CampainRepository campainRepository;
    private CampainUserRepository campainUserRepository;
    private UserRepository userRepository;
    private JwtProvider jwtProvider;

    public CampainModel createCampain(CampainRequestDTO campainRequestDTO,String token) {
        String userId = this.jwtProvider.validateToken(token);
        this.userRepository.findByUsername(userId).orElseThrow(
            () -> new UserNotFound()
        );
        CampainModel campain = this.campainRepository.save(CampainModel.builder()
            .name(campainRequestDTO.getName())
            .description(campainRequestDTO.getDescription())
            .build());
        this.campainUserRepository.save(CampainUserModel.builder()
            .campainId(campain.getId())
            .role(campainRequestDTO.getRole())
            .userId(userId)
            .build());
        return campain;
    }

    @Transactional
    public void deleteCampain(UUID id) {
        this.campainUserRepository.deleteByCampainId(id);
        this.campainRepository.deleteById(id);
    }

}
