package com.ftn.isa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.isa.model.Friend;
import com.ftn.isa.model.User;
import com.ftn.isa.service.FriendService;
import com.ftn.isa.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	FriendService friendService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/{userId}")
	public User getFriendsByUserId(@PathVariable long userId) {
		return userService.getUserById(userId);
	}
	
	@PostMapping
	public Friend addNewFrind(@RequestBody Friend friend) {
		return friendService.save(friend);
	}
	
	@PostMapping("/{id}/{status}")
	public Friend acceptFrind(@PathVariable long id, @PathVariable String status) {
		return friendService.changeStatus(id, status);
	}
}
