package com.ftn.isa.service;

import java.util.List;

import com.ftn.isa.model.Friend;

public interface FriendService {

	List<Friend> getAllByUserId(long id);
	
	Friend save(Friend friend);
	
	void delete(long id);
	
	Friend changeStatus(long id, String status);
}
