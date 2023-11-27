package com.cg.spingboot.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
		description = "userDto Model Information")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    
    @Schema(
    		description = "User First Name"
    		)
    //User should not be empty or null
    @NotEmpty(message = "User first name should not be empty or null")
    private String firstName;
    
    @Schema(
    		description = "User Last Name"
    		)
    //User should not be empty or null
    @NotEmpty(message = "User last name should not be empty or null")
    private String lastName;
    
    @Schema(
    		description = "User Email Address"
    		)
    // //User should not be empty or null
//    EMail address should be valid
    @NotEmpty(message = "User email should not be empty or null")
    @Email(message = "User EMail address should be valid")
    private String email;
}