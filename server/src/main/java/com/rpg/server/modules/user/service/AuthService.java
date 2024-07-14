package com.rpg.server.modules.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.rpg.server.exceptions.PassowordIncorret;
import com.rpg.server.exceptions.UserNotFound;
import com.rpg.server.modules.user.DTo.AuthDTO;
import com.rpg.server.modules.user.DTo.AuthResponseDTO;
import com.rpg.server.modules.user.repository.UserRepository;

@Service
public class AuthService {
    
    @Value("${security.token.secret}")
    private String secret_key;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthResponseDTO login(AuthDTO authDTO) {
        var user = userRepository.findByUsername(authDTO.getUsername()).orElseThrow(
            () -> new UserNotFound()
        );
        var password = this.passwordEncoder.matches(authDTO.getPassword(), user.getPassword());
        if(password){
            Algorithm algorithm = Algorithm.HMAC256(secret_key);
            var token = JWT.create().withIssuer("secret").withSubject(user.getUsername().toString()).sign(algorithm);
            var auth = AuthResponseDTO.builder().token(token).build();
            return auth;   
        }else{
            throw new PassowordIncorret();
        }
    }


}
