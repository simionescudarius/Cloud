package com.imobiliare.DTOs;

import java.util.List;

public class UserDTO {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private List<AnnouncementDTO> announcements;
	private List<MeetingDTO> meetings;

	public UserDTO(){
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

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public List<AnnouncementDTO> getAnnouncements() {
		return announcements;
	}

	public List<MeetingDTO> getMeetings() {
		return meetings;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setAnnouncements(List<AnnouncementDTO> announcements) {
		this.announcements = announcements;
	}

	public void setMeetings(List<MeetingDTO> meetings) {
		this.meetings = meetings;
	}
	
	private UserDTO(Long id, String firstName, String lastName, String email, String phoneNumber,
			List<AnnouncementDTO> announcements, List<MeetingDTO> meetings) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.announcements = announcements;
		this.meetings = meetings;
	}

	public static class UserDTOBuilder {
		private Long id;
		private String firstName;
		private String lastName;
		private String email;
		private String phoneNumber;
		private List<AnnouncementDTO> announcements;
		private List<MeetingDTO> meetings;

		public UserDTOBuilder() {
		}
		
		public UserDTOBuilder id (Long id){
			this.id = id;
			return this;
		}

		public UserDTOBuilder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public UserDTOBuilder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public UserDTOBuilder email(String email) {
			this.email = email;
			return this;
		}

		public UserDTOBuilder phoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}

		public UserDTOBuilder announcements(List<AnnouncementDTO> announcements) {
			this.announcements = announcements;
			return this;
		}

		public UserDTOBuilder meetings(List<MeetingDTO> meetings) {
			this.meetings = meetings;
			return this;
		}

		public UserDTO create() {
			return new UserDTO(this.id, this.firstName, this.lastName, this.email, this.phoneNumber, this.announcements,
					this.meetings);
		}

	}
}
