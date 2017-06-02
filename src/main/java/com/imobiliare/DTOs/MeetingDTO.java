package com.imobiliare.DTOs;

public class MeetingDTO {
	private long id;
	private UserDTO user1;
	private UserDTO user2;
	
	public MeetingDTO(){
	}
	
	public MeetingDTO(long id, UserDTO user1, UserDTO user2) {
		this.id = id;
		this.user1 = user1;
		this.user2 = user2;
	}

	public long getId() {
		return id;
	}

	public UserDTO getUser1() {
		return user1;
	}

	public UserDTO getUser2() {
		return user2;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setUser1(UserDTO user1) {
		this.user1 = user1;
	}

	public void setUser2(UserDTO user2) {
		this.user2 = user2;
	}
}
