package com.ftn.isa.payload;

import com.ftn.isa.model.Friend;

public class FriendDTO {

	private Long id;
	private String status;
	private UserDTO user;

	public FriendDTO() {}

	public FriendDTO(Friend friend) {
		this.id = friend.getId();
		this.status = friend.getStatus();

		if (friend.getUser() != null) {
			// FIXME infinite loop?
//			this.user = new UserDTO(friend.getUser());
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

}
