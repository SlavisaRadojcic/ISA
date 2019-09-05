package com.ftn.isa.payload;

import com.ftn.isa.model.Friend;

public class FriendDTO {
	
	private Long id;
	private String status;
	private UserDTO user;
	private Long friendId;
	private String friendFirstName;
	private String friendLastName;

	public FriendDTO() {}
	
	public FriendDTO(String status, UserDTO userDTO, Long friendId, String friendName, String friendLastName) {
		if(status == null) 
			status = "Not friends";
		else
			this.status = status;
		this.user = userDTO;
		
		this.friendId = friendId;
		this.friendFirstName = friendName;
		this.friendLastName = friendLastName;
	}

	public FriendDTO(Friend friend) {
		this.id = friend.getId();
		this.status = friend.getStatus();
		this.friendId = friend.getFriendId();
		this.friendFirstName = friend.getFriendFirstName();
		this.friendLastName = friend.getFriendLastName();

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

	public Long getFriendId() {
		return friendId;
	}

	public void setFriendId(Long friendId) {
		this.friendId = friendId;
	}

	public String getFriendFirstName() {
		return friendFirstName;
	}

	public void setFriendFirstName(String friendFirstName) {
		this.friendFirstName = friendFirstName;
	}

	public String getFriendLastName() {
		return friendLastName;
	}

	public void setFriendLastName(String friendLastName) {
		this.friendLastName = friendLastName;
	}
}
