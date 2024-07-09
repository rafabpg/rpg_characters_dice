package com.rpg.server.modules.character.model;

import java.util.List;
import java.util.UUID;

import com.rpg.server.modules.character.DTO.AbilitiesDTO;
import com.rpg.server.modules.character.DTO.AttributesDTO;
import com.rpg.server.modules.character.DTO.EquipmentDTO;
import com.rpg.server.modules.character.DTO.SpecialAbilities;
import com.rpg.server.modules.character.DTO.SpellDTO;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Entity(name = "character")
public class CharacterEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

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

    @Embedded
    @NotNull(message = "Attributes cannot be null")
    private AttributesDTO attributes;

    @ElementCollection
    @NotNull(message = "Abilities cannot be null")
    private List<AbilitiesDTO> abilities;

    @ElementCollection
    @NotNull(message = "Spells cannot be null")
    private List<SpellDTO> spells;

    @Embedded
    @NotNull(message = "Equipment cannot be null")
    private EquipmentDTO equipment;

    @Min(value = 1, message = "Max HP must be at least 1")
    private int maxHp;

    @ElementCollection
    @NotNull(message = "Special abilities cannot be null")
    private List<SpecialAbilities> specialAbilities;
}
