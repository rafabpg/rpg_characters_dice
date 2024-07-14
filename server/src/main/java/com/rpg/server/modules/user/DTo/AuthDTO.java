package com.rpg.server.modules.user.DTo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthDTO {
    private String username;
    private String password;
}
