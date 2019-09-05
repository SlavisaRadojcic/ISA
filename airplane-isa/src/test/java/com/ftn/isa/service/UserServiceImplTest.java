package com.ftn.isa.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ftn.isa.model.Friend;
import com.ftn.isa.model.User;
import com.ftn.isa.payload.UserDTO;
import com.ftn.isa.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

	@Mock
	UserRepository userRepository;
	@Mock
	FriendService friendService;
	@Mock
	PasswordEncoder passwordEncoder;
	@InjectMocks
	UserServiceImpl userService;
	
	@DisplayName("Get by id User")
	@Test
	void getUserByIdTest() {
		User user = new User();
		
		when(userRepository.getOne(anyLong())).thenReturn(user);
		
		UserDTO userDTO = userService.getUserById(1L);
		
		verify(userRepository).getOne(anyLong());
		
		assertNotNull(userDTO);
	}
	
	@Disabled
	@DisplayName("Save User")
	@Test
	void saveTest() {
		User user = new User();
		List<Friend> friends = new ArrayList<>();
		friends.add(new Friend());
		
		when(userRepository.save(any(User.class))).thenReturn(user);
		
		UserDTO userDTO = userService.save(new UserDTO());
		
		verify(userRepository).save(any(User.class));
		
		assertNotNull(userDTO);
	}
	
	@DisplayName("Get by email User")
	@Test
	void getUserByEmailTest() {
		User user = new User();
		
		when(userRepository.findByEmail(anyString())).thenReturn(user);
		
		UserDTO userDTO = userService.getUserByEmail("aaa@ddd");
		
		verify(userRepository).findByEmail(anyString());
		
		assertNotNull(userDTO);
	}

}
