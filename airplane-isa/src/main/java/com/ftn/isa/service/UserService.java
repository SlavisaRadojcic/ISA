package com.ftn.isa.service;

import java.util.List;

import com.ftn.isa.payload.FriendDTO;
import com.ftn.isa.payload.UserDTO;

public interface UserService {

	UserDTO getUserById(long id);
	
	UserDTO save(UserDTO user);
	
	UserDTO getUserByEmail(String email);
	
	UserDTO update(Long id, UserDTO userDTO);
	
	UserDTO changePassword(Long id, UserDTO userDTO);
	
	List<FriendDTO> getFriendList(String email);
	
	List<UserDTO> getNoneFriendList(String email);
}
