package com.example.microtest.service;

import com.example.microtest.dto.CredentialsDto;
import com.example.microtest.dto.SignUpDto;
import com.example.microtest.dto.UserDTO;
import com.example.microtest.entities.User;
import com.example.microtest.mappers.UserMapper;
import com.example.microtest.repository.UserRepository;
import com.example.microtest.util.AppException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserDTO login(CredentialsDto credentialsDTO){
        User user = userRepository.findUserByLogin(credentialsDTO.login())
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDTO.password()),
                user.getPassword())) {
            return userMapper.toUserDto(user);
        }
        throw new AppException("Invalid user",HttpStatus.NOT_FOUND);
    }

    public UserDTO register(SignUpDto sign){
        Optional<User> optionalUser = userRepository.findUserByLogin(sign.login());
        if(optionalUser.isPresent()){
            throw new AppException("Login already exist", HttpStatus.BAD_REQUEST);
        }
        User user = userMapper.signUpToUser(sign);
        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(sign.password())));
        User newUser = userRepository.save(user);
        return userMapper.toUserDto(newUser);
    }
}
