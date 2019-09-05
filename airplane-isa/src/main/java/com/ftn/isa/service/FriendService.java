package com.ftn.isa.service;

import java.util.List;

import com.ftn.isa.payload.FriendDTO;

public interface FriendService {

	List<FriendDTO> getAllByUserId(long id);
	
	FriendDTO save(FriendDTO friend);
	
	void delete(long id);
	
	FriendDTO changeStatus(long id, String status);
	
	void addNewFriend(String userMail, Long friendId);
	
	void removeFriend(String userMail, Long friendId);
}
