package com.ftn.isa.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ftn.isa.model.Friend;
import com.ftn.isa.model.Role;
import com.ftn.isa.model.RoleName;
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

	public UserServiceImpl(UserRepository userRepository, FriendService friendService,
			PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.friendService = friendService;
		this.passwordEncoder = passwordEncoder;
	}

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

	@Override
	public UserDTO changePassword(Long id, UserDTO userDTO) {
		User user = userRepository.getOne(id);

		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		user.setFirstTimeLogin(true);

		return new UserDTO(userRepository.save(user));
	}
	
	@Override
	public List<UserDTO> getFriendList(String email) {
		User user = userRepository.findByEmail(email);
		Role role = user.getRoles().iterator().next();
		List<User> users = userRepository.findAll().stream()
				.filter(u -> u.getId() != user.getId() && role.getName().equals(RoleName.ROLE_USER))
				.collect(Collectors.toList());

		List<User> usersHelper = new ArrayList<>();
		for (Friend friend : user.getFriends()) {
			for(int i=0; i < users.size(); i++) {
				if (friend.getFriendId() == users.get(i).getId())
					usersHelper.add(users.get(i));
			}
		}

		List<UserDTO> userDTOs = new ArrayList<>();
		for (User u : usersHelper) {
			userDTOs.add(new UserDTO(u));
		}

		return userDTOs;
	}

	@Override
	public List<UserDTO> getNoneFriendList(String email) {
		User user = userRepository.findByEmail(email);
		Role role = user.getRoles().iterator().next();
		List<User> users = userRepository.findAll().stream()
				.filter(u -> u.getId() != user.getId() && role.getName().equals(RoleName.ROLE_USER))
				.collect(Collectors.toList());

		for (Friend friend : user.getFriends()) {
			for(int i=0; i <= users.size(); i++) {
				if (friend.getFriendId() == users.get(i).getId())
					users.remove(i);
			}
		}

		List<UserDTO> userDTOs = new ArrayList<>();
		for (User u : users) {
			userDTOs.add(new UserDTO(u));
		}

		return userDTOs;
	}

}
