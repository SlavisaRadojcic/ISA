package com.ftn.isa.payload;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ftn.isa.model.User;

public class UserDTO {

	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Date dateOfBirth;
	private String phoneNumber;
	private boolean firstTimeLogin;
	private String passeport;
	private int score;
	private List<FriendDTO> friends = new ArrayList<FriendDTO>();

	public UserDTO() {}

	public UserDTO(long id, String firstName, String lastName, String email, String password, Date dateOfBirth,
			String phoneNumber, boolean firstTimeLogin, String passeport, int score, List<FriendDTO> friends) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.firstTimeLogin = firstTimeLogin;
		this.passeport = passeport;
		this.score = score;
		if(friends != null) {
			this.friends = friends;
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isFirstTimeLogin() {
		return firstTimeLogin;
	}

	public void setFirstTimeLogin(boolean firstTimeLogin) {
		this.firstTimeLogin = firstTimeLogin;
	}

	public String getPasseport() {
		return passeport;
	}

	public void setPasseport(String passeport) {
		this.passeport = passeport;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public List<FriendDTO> getFriends() {
		return friends;
	}

	public void setFriends(List<FriendDTO> friends) {
		this.friends = friends;
	}

	public User convertToModel(UserDTO userDTO) {
		User user = new User();

		user.setId(userDTO.getId());
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setEmail(userDTO.getEmail());
		user.setDateOfBirth(userDTO.getDateOfBirth());
		user.setFirstTimeLogin(userDTO.isFirstTimeLogin());
		user.setPasseport(userDTO.getPasseport());
		user.setScore(userDTO.getScore());
		
		return user;
	}

	public UserDTO convertToDTO(User user) {
		return new UserDTO(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(),
				user.getDateOfBirth(), user.getPhoneNumber(), user.isFirstTimeLogin(), user.getPasseport(), user.getScore(), friends);
	}
	
	public UserDTO convertToDTO(User user, List<FriendDTO> friends) {
		return new UserDTO(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(),
				user.getDateOfBirth(), user.getPhoneNumber(), user.isFirstTimeLogin(), user.getPasseport(), user.getScore(), friends);
	}
}
