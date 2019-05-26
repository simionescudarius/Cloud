package cloud.imobiliare.transformers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import cloud.imobiliare.DTOs.MeetingDTO;
import cloud.imobiliare.entities.Meeting;

@Component
public class MeetingTransformer implements Transformer<Meeting, MeetingDTO> {

	@Override
	public MeetingDTO toDTO(Meeting object) {
		return new MeetingDTO(object.getId(), object.getUser1().getId(), object.getUser2().getId(),
				object.getAnnouncement().getId());
	}

	public List<MeetingDTO> toDTOList(List<Meeting> list) {
		if (list == null || list.isEmpty()) {
			return null;
		}
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
