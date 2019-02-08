package com.ftn.isa.service;

import com.ftn.isa.payload.UserDTO;

public interface UserService {

	UserDTO getUserById(long id);
	
	UserDTO save(UserDTO user);
}
