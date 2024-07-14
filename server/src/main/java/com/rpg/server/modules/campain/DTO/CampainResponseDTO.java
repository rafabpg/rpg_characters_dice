package com.rpg.server.modules.campain.DTO;

import java.util.UUID;

import com.rpg.server.modules.campain.model.RoleEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CampainResponseDTO {
    
    private UUID id;
    private String name;
    private String description;
    private RoleEnum role;

}
