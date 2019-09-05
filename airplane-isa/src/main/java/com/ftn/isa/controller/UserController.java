package com.ftn.isa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.isa.payload.FriendDTO;
import com.ftn.isa.payload.UserDTO;
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
	@PreAuthorize("hasRole('USER')")
	public UserDTO getUserById(@PathVariable long userId) {
		return userService.getUserById(userId);
	}
	
	@GetMapping("/get/{email}")
	public UserDTO getUserByEmail(@PathVariable String email) {
		return userService.getUserByEmail(email);
	}
	
	@PostMapping
	@PreAuthorize("hasRole('USER')")
	public FriendDTO addNewFrind(@RequestBody FriendDTO friend) {
		return friendService.save(friend);
	}
	
	@GetMapping("/friends/{email}/{friendId}")
	@PreAuthorize("hasRole('USER')")
	public void acceptFrind(@PathVariable String email, @PathVariable Long friendId) {
		friendService.addNewFriend(email, friendId);
	}
	
	@GetMapping("/remove-friends/{email}/{friendId}")
	@PreAuthorize("hasRole('USER')")
	public void removeFrind(@PathVariable String email, @PathVariable Long friendId) {
		friendService.removeFriend(email, friendId);
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public UserDTO editUser(@PathVariable Long id, @RequestBody UserDTO user) {
		return userService.update(id, user);
	}
	
	@PostMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public UserDTO changePassword(@PathVariable Long id, @RequestBody UserDTO user) {
		return userService.changePassword(id, user);
	}
	
	@GetMapping("/{email}/friends")
	@PreAuthorize("hasRole('USER')")
	public List<UserDTO> getFriendsByUserEmail(@PathVariable String email) {
		return userService.getFriendList(email);
	}
	
	@GetMapping("/{email}/none-friends")
	@PreAuthorize("hasRole('USER')")
	public List<UserDTO> getNoneFriendsByUserEmail(@PathVariable String email) {
		return userService.getNoneFriendList(email);
	}
}
