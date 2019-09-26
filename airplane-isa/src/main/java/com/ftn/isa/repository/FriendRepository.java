package com.ftn.isa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.isa.model.Friend;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Long> {

	List<Friend> getByUserId(long userId);
	
	Friend findByFriendIdAndUserId(long friendId, long userId);
}
