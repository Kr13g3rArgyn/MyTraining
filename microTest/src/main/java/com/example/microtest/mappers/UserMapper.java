package com.example.microtest.mappers;

import com.example.microtest.dto.SignUpDto;
import com.example.microtest.dto.UserDTO;
import com.example.microtest.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toUserDto(User user);
    User signUpToUser(SignUpDto sign);
}
