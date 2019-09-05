package com.ftn.isa.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ftn.isa.model.Friend;
import com.ftn.isa.payload.FriendDTO;
import com.ftn.isa.repository.FriendRepository;
import com.ftn.isa.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class FriendServiceImplTest {
	
	@Mock
	FriendRepository friendRepository;
	@Mock
	UserRepository userRepository;
	@InjectMocks
	FriendServiceImpl friendService;

	@DisplayName("Find all Friend by User id")
	@Test
	void getAllByUserIdTest() {
		List<Friend> friends = new ArrayList<>();
		friends.add(new Friend());
		
		when(friendRepository.getByUserId(anyLong())).thenReturn(friends);
		
		List<FriendDTO> friendsDTO = friendService.getAllByUserId(1L);
		
		verify(friendRepository).getByUserId(anyLong());
		
		assertEquals(1, friendsDTO.size());
	}

	@Disabled
	@DisplayName("Save Friend")
	@Test
	void saveTest() {
		Friend friend = new Friend();

		when(friendRepository.save(any(Friend.class))).thenReturn(friend);
		
		FriendDTO friendDTO = friendService.save(new FriendDTO());

		verify(friendRepository).save(any(Friend.class));
		
		assertNotNull(friendDTO);
	}

	@DisplayName("Delete Friend")
	@Test
	void deleteTest() {
		friendService.delete(anyLong());

		verify(friendRepository).deleteById(anyLong());
	}
}
