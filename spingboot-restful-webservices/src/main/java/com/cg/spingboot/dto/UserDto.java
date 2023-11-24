package com.cg.spingboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    
    //User should not be empty or null
    @NotEmpty(message = "User first name should not be empty or null")
    private String firstName;
    
    //User should not be empty or null
    @NotEmpty(message = "User last name should not be empty or null")
    private String lastName;
    
    // //User should not be empty or null
//    EMail address should be valid
    @NotEmpty(message = "User email should not be empty or null")
    @Email(message = "User EMail address should be valid")
    private String email;
}