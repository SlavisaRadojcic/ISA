package com.ftn.isa.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ftn.isa.model.Friend;
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
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public UserDTO getUserById(long id) {
		User user = userRepository.getOne(id);
		List<FriendDTO> friendsDTO = friendService.getAllByUserId(id);

		UserDTO userDTO = new UserDTO(user);
		userDTO.setFriends(friendsDTO);

		return userDTO;
	}

	@Override
	public UserDTO save(UserDTO userDTO) {
		User user = new User();
		BeanUtils.copyProperties(userDTO, user, "friends", "passport", "score");

		userDTO.getFriends().forEach(friendDTO -> {
			Friend friend = new Friend();
			BeanUtils.copyProperties(friendDTO, friend, "user");

			user.getFriends().add(friend);
		});

		return new UserDTO(userRepository.save(user));
	}
	
	@Override
	public UserDTO update(Long id, UserDTO userDTO) {
		User user = new User();
		User userRole = userRepository.getOne(id);
		BeanUtils.copyProperties(userDTO, user, "friends", "passport", "score");
		
		user.setRoles(Collections.singleton(userRole.getRoles().iterator().next()));
		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

		return new UserDTO(userRepository.save(user));
	}

	@Override
	public UserDTO getUserByEmail(String email) {
		UserDTO userDTO = new UserDTO(userRepository.findByEmail(email));

		return userDTO;
	}

}
