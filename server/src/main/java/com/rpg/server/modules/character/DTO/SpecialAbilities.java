package com.rpg.server.modules.character.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Embeddable
public class SpecialAbilities {
     @Column(name = "special_ability_name")
    private String name;
    private String description;

}