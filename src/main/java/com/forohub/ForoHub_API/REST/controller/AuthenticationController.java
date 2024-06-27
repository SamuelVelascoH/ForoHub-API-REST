package com.forohub.ForoHub_API.REST.controller;

import com.forohub.ForoHub_API.REST.domain.usuarios.UserAPI;
import com.forohub.ForoHub_API.REST.dto.AuthenticationUserDTO;
import com.forohub.ForoHub_API.REST.dto.JWTTokenDTO;
import com.forohub.ForoHub_API.REST.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity authenticateUser(@RequestBody @Valid AuthenticationUserDTO authenticationUserDTO){
        Authentication authentication = new UsernamePasswordAuthenticationToken(authenticationUserDTO.login(), authenticationUserDTO.key());
        var authenticatedUser = authenticationManager.authenticate(authentication);
        var jwtToken = tokenService.generateToken((UserAPI) authenticatedUser.getPrincipal());
        return ResponseEntity.ok(new JWTTokenDTO(jwtToken));
    }
}
