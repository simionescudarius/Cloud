package com.imobiliare.transformers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.imobiliare.DTOs.AnnouncementDTO;
import com.imobiliare.models.Announcement;

@Component
public class AnnouncementTransformer implements Transformer<Announcement, AnnouncementDTO> {

	@Override
	public AnnouncementDTO toDTO(Announcement object) {
		return new AnnouncementDTO.AnnouncementDTOBuilder().expireDate(object.getExpireDate()).id(object.getId())
				.owner(new UserTransformer().toDTO(object.getOwner())).postDate(object.getPostDate())
				.realEstate(new RealEstateTransformer().toDTO(object.getRealEstate()))
				.viewNumber(object.getViewNumber()).create();
	}

	public List<AnnouncementDTO> toDTOList(List<Announcement> list) {
		if (list == null)
			return null;
		List<AnnouncementDTO> announcementDTOs = new ArrayList<>();
		list.forEach((k) -> announcementDTOs.add(toDTO(k)));
		return announcementDTOs;
	}

	@Override
	public Announcement toModel(AnnouncementDTO object) {
		return new Announcement(object.getOwner().getId(), object.getRealEstate().getId(), object.getPostDate(),
				object.getPostDate(), object.getViewNumber());
	}

}
