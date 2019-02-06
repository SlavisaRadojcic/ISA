package com.ftn.isa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ftn.isa.model.User;
import com.ftn.isa.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User getUserById(long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with id : " + id));
	}

	@Override
	public User save(User user) {
//		User newUser = userRepository.getOne(user.getId());
//		
//		newUser.setEmail(user.getEmail());
//		newUser.setUsername(user.getUsername());
//		newUser.setName(user.getName());
//		
//		return userRepository.save(user);
		
		return null;
	}

}
