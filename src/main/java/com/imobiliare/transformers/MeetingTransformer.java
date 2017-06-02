package com.imobiliare.transformers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.imobiliare.DTOs.MeetingDTO;
import com.imobiliare.models.Meeting;

@Component
public class MeetingTransformer implements Transformer<Meeting, MeetingDTO> {

	@Override
	public MeetingDTO toDTO(Meeting object) {
		return new MeetingDTO(object.getId(), new UserTransformer().toDTO(object.getUser1()),
				new UserTransformer().toDTO(object.getUser2()));
	}

	public List<MeetingDTO> toDTOList(List<Meeting> list) {
		if (list == null)
			return null;
		List<MeetingDTO> meetingsDTOs = new ArrayList<>();
		list.forEach((k) -> meetingsDTOs.add(toDTO(k)));
		return meetingsDTOs;
	}

	@Override
	public Meeting toModel(MeetingDTO object) {
		// TODO Auto-generated method stub
		return null;
	}

}
