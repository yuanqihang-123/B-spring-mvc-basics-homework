package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.entity.UserEntity;
import com.thoughtworks.capacity.gtb.mvc.exception.UserNotFoundException;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.websocket.server.PathParam;

@Controller
@ResponseBody
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public void register(@RequestBody @Valid UserEntity userEntity){
        userService.registerUser(userEntity);
    }

    @GetMapping("/login")
    public UserEntity login(@PathParam("username") @Size(min = 3,max = 10,message = "username length between 3 and 10")
                                @Pattern(regexp = "^\\w+$",message = "username must contains with number,letter，underline") String username,
                            @PathParam("password")@Size(min = 5,max = 12,message = "password length between 5 and 12") String password)
            throws UserNotFoundException {
        return userService.login(username,password);
    }

}
