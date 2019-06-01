package com.mreorhan.ws.service.impl;

import com.mreorhan.ws.entity.UserEntity;
import com.mreorhan.ws.service.UserService;
import com.mreorhan.ws.shared.UserRepository;
import com.mreorhan.ws.shared.Utils;
import com.mreorhan.ws.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    Utils utils;

    @Override
    public UserDto createUser(UserDto user) {

        if (userRepository.findByEmail(user.getEmail()) != null) throw new RuntimeException("Email already exists.");

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user,userEntity); // userDTO ve userEntity eşleşmesi yapar.

        String publicUserId = utils.generateUserId(30);
        userEntity.setEmailVerificationToken("123");
        userEntity.setEncryptedPassword("test");
        userEntity.setUserId(publicUserId);

        UserEntity storedUserDetails= userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetails,returnValue);

        return returnValue;
    }
}
