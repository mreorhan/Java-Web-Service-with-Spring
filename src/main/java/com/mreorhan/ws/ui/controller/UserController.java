package com.mreorhan.ws.ui.controller;

import com.mreorhan.ws.exceptions.UserServiceException;
import com.mreorhan.ws.service.UserService;
import com.mreorhan.ws.shared.dto.UserDto;
import com.mreorhan.ws.ui.model.request.UserDetailsRequestModel;
import com.mreorhan.ws.ui.model.response.ErrorMessages;
import com.mreorhan.ws.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")// http://localhost:8080/users
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/{id}")
    public UserRest getUser(@PathVariable String id) {
        UserRest returnValue = new UserRest();
        UserDto userDto = userService.getUserByUserId(id);
        BeanUtils.copyProperties(userDto, returnValue);
        return returnValue;
    }

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetailsRequestModel) throws Exception {

        UserRest returnValue = new UserRest();

        if (userDetailsRequestModel.getFirstName().isEmpty())
            throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetailsRequestModel, userDto);

        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, returnValue);

        return returnValue;
    }

    @PutMapping
    public String updateUser() {
        return "update user";

    }

    @DeleteMapping
    public String deleteUser() {
        return "delete user";
    }
}
