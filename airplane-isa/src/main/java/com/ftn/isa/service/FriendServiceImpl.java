package com.ftn.isa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.isa.model.Friend;
import com.ftn.isa.repository.FriendRepository;

@Service
public class FriendServiceImpl implements FriendService {

	@Autowired
	FriendRepository friendRepository;
	
	@Override
	public List<Friend> getAllByUserId(long id) {
		return friendRepository.getByUserId(id);
	}

	@Override
	public Friend save(Friend friend) {
		return friendRepository.save(friend);
	}

	@Override
	public void delete(long id) {
		friendRepository.deleteById(id);
	}

	@Override
	public Friend changeStatus(long id, String status) {
		Friend friend = friendRepository.getOne(id);
		friend.setStatus(status);
		
		return friendRepository.save(friend);
	}
	
}
