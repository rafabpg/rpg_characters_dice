package com.rpg.server.modules.campain.DTO;

import com.rpg.server.modules.campain.model.RoleEnum;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CampainRequestDTO {

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private RoleEnum role;

    @NotBlank
    private String name;

    @NotBlank
    private String description;
    

}
