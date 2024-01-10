package com.example.microtest.controller;

import com.example.microtest.config.UserAuthenticationProvider;
import com.example.microtest.dto.CredentialsDto;
import com.example.microtest.dto.SignUpDto;
import com.example.microtest.dto.UserDTO;
import com.example.microtest.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RequiredArgsConstructor
@RestController
public class AuthController {

    private final UserService userService;
    private final UserAuthenticationProvider userAuthenticationProvider;

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody @Valid CredentialsDto credentialsDto) {
        UserDTO userDto = userService.login(credentialsDto);
        userDto.setToken(userAuthenticationProvider.createToken(userDto));
        return ResponseEntity.ok(userDto);
    }
    @PostMapping("/register")
    public ResponseEntity<SignUpDto> register(@RequestBody @Valid SignUpDto user) {
        UserDTO userDTO = userService.register(user);
        return  ResponseEntity.created(URI.create("/users/" + userDTO.getId())).body(user);
    }

}
