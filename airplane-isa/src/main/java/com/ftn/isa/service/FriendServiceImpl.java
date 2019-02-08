package com.ftn.isa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.isa.model.Friend;
import com.ftn.isa.payload.FriendDTO;
import com.ftn.isa.repository.FriendRepository;

@Service
public class FriendServiceImpl implements FriendService {

	@Autowired
	FriendRepository friendRepository;
	
	@Override
	public List<FriendDTO> getAllByUserId(long id) {
		List<FriendDTO> friendsDTO = new ArrayList<>();
		List<Friend> friends = friendRepository.getByUserId(id);
		
		for(Friend friend: friends) {
			friendsDTO.add(new FriendDTO().convertToDTO(friend));
		}
		
		return friendsDTO;
	}

	@Override
	public FriendDTO save(FriendDTO friend) {
//		return friendRepository.save(friend);
		return null;
	}

	@Override
	public void delete(long id) {
		friendRepository.deleteById(id);
	}

	@Override
	public FriendDTO changeStatus(long id, String status) {
		Friend friend = friendRepository.getOne(id);
		friend.setStatus(status);
		
//		return friendRepository.save(friend);
		return null;
	}
	
}
