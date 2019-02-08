package com.ftn.isa.payload;

import com.ftn.isa.model.Friend;

public class FriendDTO {

	private long id;
	private String status;
	private UserDTO user;

	public FriendDTO() {}

	public FriendDTO(long id, String status, UserDTO user) {
		this.id = id;
		this.status = status;
		if (user != null) {
			this.user = user;
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public Friend convertToModel(FriendDTO friendDTO) {
		Friend friend = new Friend();

		friend.setId(friendDTO.getId());
		friend.setStatus(friendDTO.getStatus());
		if (friendDTO.getUser() != null) {
			friend.setUser(new UserDTO().convertToModel(friendDTO.getUser()));
		}

		return friend;
	}

	public FriendDTO convertToDTO(Friend friend) {
		UserDTO userDTO = new UserDTO();
		if (friend.getUser() != null) {
			userDTO = userDTO.convertToDTO(friend.getUser());
		}

		return new FriendDTO(friend.getId(), friend.getStatus(), userDTO);
	}

}
