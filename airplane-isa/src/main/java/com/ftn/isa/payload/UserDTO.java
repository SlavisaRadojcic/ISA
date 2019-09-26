package com.ftn.isa.payload;

import java.util.ArrayList;
import java.util.List;

import com.ftn.isa.model.Role;
import com.ftn.isa.model.User;

public class UserDTO {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String phone;
	private boolean firstTimeLogin;
	private String passport;
	private Integer score;
	private String city;
	private List<FriendDTO> friends = new ArrayList<>();
//	private Role role;

	public UserDTO() {
	}

	public UserDTO(User user) {
		this.id = user.getId();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.phone = user.getPhone();
		this.firstTimeLogin = user.isFirstTimeLogin();
		this.passport = user.getPasseport();
		this.score = user.getScore();
		this.city = user.getCity();

		if (!user.getFriends().isEmpty()) {
			user.getFriends().forEach(friend -> this.friends.add(new FriendDTO(friend)));
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isFirstTimeLogin() {
		return firstTimeLogin;
	}

	public void setFirstTimeLogin(boolean firstTimeLogin) {
		this.firstTimeLogin = firstTimeLogin;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<FriendDTO> getFriends() {
		return friends;
	}

	public void setFriends(List<FriendDTO> friends) {
		this.friends = friends;
	}
	
//	public Role getRole() {
//		return role;
//	}
//
//	public void setRole(Role role) {
//		this.role = role;
//	}
	
}
