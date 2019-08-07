package com.ftn.isa.payload;

import lombok.Data;

@Data
public class JwtAuthenticationResponse {
	private String accessToken;
	private String tokenType = "Bearer";
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String role;

	public JwtAuthenticationResponse(String firstName, String lastName, String email, String phoneNumber, String role,
			String accessToken) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.role = role;
		this.accessToken = accessToken;
	}
}
