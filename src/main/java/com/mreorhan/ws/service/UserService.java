package com.mreorhan.ws.service;

import com.mreorhan.ws.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto user);

    UserDto updateUser(String id, UserDto user);

    void deleteUser(String id);

    UserDto getUser(String email);

    UserDto getUserByUserId(String id);
}
