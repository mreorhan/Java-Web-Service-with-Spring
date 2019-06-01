package com.mreorhan.ws.service.impl;

import com.mreorhan.ws.shared.dto.UserDto;
import com.mreorhan.ws.entity.UserEntity;
import com.mreorhan.ws.shared.UserRepository;
import com.mreorhan.ws.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto user) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user,userEntity); // userDTO ve userEntity eşleşmesi yapar.

        userEntity.setEmailVerificationToken("123");
        userEntity.setEncryptedPassword("test");
        userEntity.setUserId("testuserID");

        UserEntity storedUserDetails= userRepository.save(userEntity);

        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetails,returnValue);

        return returnValue;
    }
}
