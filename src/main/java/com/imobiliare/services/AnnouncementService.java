package com.imobiliare.services;

import java.util.List;

import com.imobiliare.models.Announcement;

public interface AnnouncementService extends CrudService<Announcement> {
	List<Announcement> getByRealEstateType (String type);
}
