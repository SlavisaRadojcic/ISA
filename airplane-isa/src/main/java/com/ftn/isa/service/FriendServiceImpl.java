package com.ftn.isa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ftn.isa.model.Friend;
import com.ftn.isa.model.User;
import com.ftn.isa.payload.FriendDTO;
import com.ftn.isa.repository.FriendRepository;
import com.ftn.isa.repository.UserRepository;

@Service
@Transactional
public class FriendServiceImpl implements FriendService {

	FriendRepository friendRepository;
	UserRepository userRepository;
	
	public FriendServiceImpl(FriendRepository friendRepository, UserRepository userRepository) {
		this.friendRepository = friendRepository;
		this.userRepository = userRepository;
	}

	@Override
	public List<FriendDTO> getAllByUserId(long id) {
		List<FriendDTO> friendsDTO = new ArrayList<>();
		List<Friend> friends = friendRepository.getByUserId(id);

		for(Friend friend: friends) {
			friendsDTO.add(new FriendDTO(friend));
		}

		return friendsDTO;
	}

	@Override
	public FriendDTO save(FriendDTO friendDTO) {
		Friend friend = new Friend();
		BeanUtils.copyProperties(friendDTO, friend);
		
		friendRepository.save(friend);

		return new FriendDTO(friend);
	}

	@Override
	public void delete(long id) {
		friendRepository.deleteById(id);
	}

	@Override
	public FriendDTO changeStatus(long id, String status) {
		Friend friend = friendRepository.getOne(id);
		friend.setStatus(status);
		friendRepository.save(friend);
		
		return new FriendDTO(friend);
	}

	@Override
	public void addNewFriend(String userMail, Long friendId) {
		User user = userRepository.findByEmail(userMail);
		User friend = userRepository.findById(friendId).get();
		
		Friend fri = new Friend();
		fri.setFriendFirstName(friend.getFirstName());
		fri.setFriendLastName(friend.getLastName());
		fri.setFriendId(friendId);
		fri.setStatus("requested");
		fri.setUser(user);
		
		Friend otherFriend = new Friend();
		otherFriend.setFriendFirstName(user.getFirstName());
		otherFriend.setFriendLastName(user.getLastName());
		otherFriend.setFriendId(user.getId());
		otherFriend.setStatus("waiting");
		otherFriend.setUser(friend);
		
		friendRepository.save(fri);
		friendRepository.save(otherFriend);
	}

	@Override
	public void removeFriend(String userMail, Long friendId) {
		User user = userRepository.findByEmail(userMail);
		User friend = userRepository.findById(friendId).get();
		
		for(Friend f: user.getFriends()) {
			if(f.getFriendId() == friend.getId()) {
				friendRepository.deleteById(f.getId());
			}
		}
		
		for(Friend f: friend.getFriends()) {
			if(f.getFriendId() == user.getId()) {
				friendRepository.deleteById(f.getId());
			}
		}
	}

	@Override
	public void friendAccepted(String userMail, Long friendId) {
		User user = userRepository.findByEmail(userMail);
		Friend friendToAccept = friendRepository.findById(friendId).get();
		Friend otherFriendToAccept = friendRepository.findByFriendIdAndUserId(user.getId(), friendToAccept.getFriendId());
		
		friendToAccept.setStatus("accepted");
		otherFriendToAccept.setStatus("accepted");
		
		friendRepository.save(friendToAccept);
		friendRepository.save(otherFriendToAccept);
		
	}

	@Override
	public void friendCancelled(String userMail, Long friendId) {
		User user = userRepository.findByEmail(userMail);
		Friend friendToAccept = friendRepository.findById(friendId).get();
		Friend otherFriendToAccept = friendRepository.findByFriendIdAndUserId(user.getId(), friendToAccept.getFriendId());
		
		friendRepository.deleteById(friendToAccept.getId());
		friendRepository.deleteById(otherFriendToAccept.getId());
	}

}
