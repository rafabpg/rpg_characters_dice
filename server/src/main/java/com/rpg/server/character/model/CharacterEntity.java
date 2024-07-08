package com.rpg.server.character.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity(name = "character")
public class CharacterEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotEmpty(message = "Name cannot be empty")
    @Size(max = 50, message = "Name cannot exceed 50 characters")
    private String name;

    @NotEmpty(message = "Race cannot be empty")
    @Size(max = 50, message = "Race cannot exceed 50 characters")
    private String race;

    @NotEmpty(message = "Character class cannot be empty")
    @Size(max = 50, message = "Character class cannot exceed 50 characters")
    private String characterClass;

    @Min(value = 1, message = "Level must be at least 1")
    @Max(value = 100, message = "Level must be less than or equal to 100")
    private int level;

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

    @Min(value = 1, message = "Max HP must be at least 1")
    private int maxHp;

    @NotNull(message = "Abilities cannot be null")
    private String[] abilities;

    @NotNull(message = "Spells cannot be null")
    private String[] spells;

    @NotNull(message = "Equipment cannot be null")
    private String[] equipment;

    @NotNull(message = "Special abilities cannot be null")
    private String[] specialAbilities;
}
