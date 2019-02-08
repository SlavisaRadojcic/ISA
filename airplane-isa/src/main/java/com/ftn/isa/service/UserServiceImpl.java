package com.ftn.isa.service;

import com.ftn.isa.model.Friend;
import com.ftn.isa.model.User;
import com.ftn.isa.payload.FriendDTO;
import com.ftn.isa.payload.UserDTO;
import com.ftn.isa.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

		UserDTO userDTO = new UserDTO(user);
		userDTO.setFriends(friendsDTO);

		return userDTO;
	}

	@Override
	public UserDTO save(UserDTO userDTO) {
		User user = new User();
		BeanUtils.copyProperties(userDTO, user, "friends");

		userDTO.getFriends().forEach(friendDTO -> {
			Friend friend = new Friend();
			BeanUtils.copyProperties(friendDTO, friend, "user");

			user.getFriends().add(friend);
		});

		return new UserDTO(userRepository.save(user));
	}

}
