package com.rpg.server.modules.character.DTO;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
@Embeddable
public class AttributesDTO {

    @Min(value = 1, message = "Attribute must be at least 1")
    @Max(value = 20, message = "Attribute must be less than or equal to 20")
    private int strength;

    @Min(value = 1, message = "Attribute must be at least 1")
    @Max(value = 20, message = "Attribute must be less than or equal to 20")
    private int dexterity;

    @Min(value = 1, message = "Attribute must be at least 1")
    @Max(value = 20, message = "Attribute must be less than or equal to 20")
    private int constitution;

    @Min(value = 1, message = "Attribute must be at least 1")
    @Max(value = 20, message = "Attribute must be less than or equal to 20")
    private int intelligence;

    @Min(value = 1, message = "Attribute must be at least 1")
    @Max(value = 20, message = "Attribute must be less than or equal to 20")
    private int wisdom;

    @Min(value = 1, message = "Attribute must be at least 1")
    @Max(value = 20, message = "Attribute must be less than or equal to 20")
    private int charisma;
}