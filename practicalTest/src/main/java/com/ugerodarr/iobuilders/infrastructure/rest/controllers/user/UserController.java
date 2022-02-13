package com.ugerodarr.iobuilders.infrastructure.rest.controllers.user;

import com.ugerodarr.iobuilders.application.services.user.CreateUserService;
import com.ugerodarr.iobuilders.domain.model.user.User;
import com.ugerodarr.iobuilders.infrastructure.dtos.user.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    CreateUserService createUserService;

    @PostMapping("/createUser")
    @Operation(
            summary = "Register User",
            description = "Register User with name, lastname, password and email. Check if email already exists.",
            tags = { "Users" }
    )
    public User createUser(@Valid @RequestBody UserDTO userDTO) throws Exception  {
        return createUserService.createUser(userDTO);
    }

}
