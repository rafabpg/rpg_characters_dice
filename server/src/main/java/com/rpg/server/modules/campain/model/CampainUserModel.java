package com.rpg.server.modules.campain.model;

import java.util.UUID;

import com.rpg.server.modules.user.model.UserModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity(name = "campain_user")
public class CampainUserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "campain_id",insertable = false,updatable = false)
    private CampainModel campain;

    @Column(name = "campain_id")
    private UUID campainId;

    @ManyToOne
    @JoinColumn(name = "username",insertable = false,updatable = false)
    private UserModel user;

    @Column(name = "username")
    private String userId;

    @Enumerated(value = EnumType.STRING)
    private RoleEnum role;

}
