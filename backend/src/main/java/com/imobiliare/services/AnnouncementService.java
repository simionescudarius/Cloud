package com.imobiliare.services;

import java.util.List;

import com.imobiliare.models.Announcement;

public interface AnnouncementService extends CrudService<Announcement, Long> {
	List<Announcement> getByRealEstateType (String type);
	List<Announcement> getByRealEstateRoomNumberAndType(int roomNumber, String type);
	List<Announcement> getMostPopular();
	void incViewNumber (long id);
}
