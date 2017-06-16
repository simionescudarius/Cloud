package com.imobiliare.DTOs;

public class MeetingDTO {
	private long id;
	private Long user1;
	private Long user2;
	private Long announcement_id;
	
	public MeetingDTO(){
	}

	public MeetingDTO(long id, Long user1, Long user2, Long announcement_id) {
		this.id = id;
		this.user1 = user1;
		this.user2 = user2;
		this.announcement_id = announcement_id;
	}

	public Long getUser1() {
		return user1;
	}

	public Long getUser2() {
		return user2;
	}

	public void setUser1(Long user1) {
		this.user1 = user1;
	}

	public void setUser2(Long user2) {
		this.user2 = user2;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getAnnouncement_id() {
		return announcement_id;
	}

	public void setAnnouncement_id(Long announcement_id) {
		this.announcement_id = announcement_id;
	}
	
}
