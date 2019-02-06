package com.ftn.isa.payload;

import java.util.Date;

import lombok.Data;

@Data
public class JwtAuthenticationResponse {
	private String accessToken;
    private String tokenType = "Bearer";
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String phoneNumber;
    private String role;

    public JwtAuthenticationResponse(String firstName, String lastName, Date dateOfBirth, String phoneNumber, String role, String accessToken) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.role = role;
    	this.accessToken = accessToken;
    }
}
