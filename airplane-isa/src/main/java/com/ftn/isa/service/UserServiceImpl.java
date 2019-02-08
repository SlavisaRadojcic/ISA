package com.ftn.isa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.isa.model.User;
import com.ftn.isa.payload.FriendDTO;
import com.ftn.isa.payload.UserDTO;
import com.ftn.isa.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	FriendService friendService;
	
	@Override
	public UserDTO getUserById(long id) {
		User user = userRepository.getOne(id);
		List<FriendDTO> friendsDTO = friendService.getAllByUserId(id);
		
		UserDTO userDTO = new UserDTO().convertToDTO(user, friendsDTO);
		
		return userDTO;
	}

	@Override
	public UserDTO save(UserDTO userDTO) {
		User user = new UserDTO().convertToModel(userDTO);
		
		userRepository.save(user);
		UserDTO newUserDTO = new UserDTO().convertToDTO(user);
		
		return newUserDTO;
	}

}
