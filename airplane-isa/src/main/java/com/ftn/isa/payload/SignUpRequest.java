package com.ftn.isa.payload;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class SignUpRequest {
	@NotBlank
    @Size(min = 3, max = 40)
    private String firstName;
	
	@NotBlank
    @Size(min = 3, max = 40)
    private String lastName;

    @NotBlank
    @Size(max = 40)
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 20)
    private String password;
    
	private Date dateOfBirth;
	
	private String phoneNumber;
	
	private boolean firstTimeLogin;
}