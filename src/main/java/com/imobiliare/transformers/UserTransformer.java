package com.imobiliare.transformers;

import org.springframework.stereotype.Component;

import com.imobiliare.DTOs.UserDTO;
import com.imobiliare.models.User;

@Component
public class UserTransformer implements Transformer<User, UserDTO> {

	@Override
	public UserDTO toDTO(User object) {
		return new UserDTO.UserDTOBuilder()
				.announcements(new AnnouncementTransformer().toDTOList(object.getAnnouncements()))
				.email(object.getEmail()).firstName(object.getFirstName()).id(object.getId())
				.lastName(object.getLastName()).meetings(new MeetingTransformer().toDTOList(object.getMeetings()))
				.phoneNumber(object.getPhoneNumber()).create();
	}

	public UserDTO toDTOforAnnouncement(User object) {
		return new UserDTO.UserDTOBuilder().announcements(null).email(object.getEmail())
				.firstName(object.getFirstName()).id(object.getId()).lastName(object.getLastName()).meetings(null)
				.phoneNumber(object.getPhoneNumber()).create();
	}

	@Override
	public User toModel(UserDTO object) {
		User user = new User();
		user.setEmail(object.getEmail());
		user.setFirstName(object.getFirstName());
		user.setLastName(object.getLastName());
		user.setPhoneNumber(object.getPhoneNumber());
		return user;
	}

}
