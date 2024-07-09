package com.rpg.server.modules.character.DTO;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Embeddable
public class EquipmentDTO {

    @NotEmpty(message = "Weapon cannot be empty")
    private String weapon;

    @NotEmpty(message = "Armor cannot be empty")
    private String armor;

    @ElementCollection
    @NotEmpty(message = "Magic items cannot be empty")
    private List<String> magicItems;

}
