package com.thoughtworks.capacity.gtb.mvc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {
    @NotBlank(message = "username could not null")
    @Size(min = 3, max = 10 ,message = "username is length between 3 and 10")
    @Pattern(regexp = "^\\w+$",message = "username must be a number, letter or underscore")
    private String username;
    @NotBlank(message = "password could not null")
    @Size(min = 5,max = 12,message = "password length between 5 and 12")
    private String password;
    @NotBlank(message = "email could not null")
    @Email(message = "please input correct email")
    private String email;
}
