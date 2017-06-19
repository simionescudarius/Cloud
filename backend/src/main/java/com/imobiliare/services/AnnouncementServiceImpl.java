package com.imobiliare.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.imobiliare.models.Announcement;
import com.imobiliare.repositories.AnnouncementRepository;

@Service
@Transactional
public class AnnouncementServiceImpl implements AnnouncementService {
	@Autowired
	AnnouncementRepository announcementRepository;

	@Override
	public void save(Announcement object) {
		announcementRepository.save(object);
	}

	@Override
	public List<Announcement> getAll() {
		return announcementRepository.findAllByOrderByPostDateAsc();
	}

	@Override
	public Announcement getById(Long id) {
		return announcementRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		announcementRepository.delete(id);
	}

	@Override
	public List<Announcement> getByRealEstateType(String type) {
		return announcementRepository.getByRealEstateType(type);
	}

	@Override
	public List<Announcement> getByRealEstateRoomNumberAndType(int roomNumber, String type) {
		return this.announcementRepository.getByRealEstateRoomNumberAndType(roomNumber, type);
	}

	@Override
	public void incViewNumber(long id) {
		this.announcementRepository.incViewNumber(id);
	}

	@Override
	public List<Announcement> getMostPopular() {
		List<Announcement> list = new ArrayList<>();
		Page<Announcement> page = this.announcementRepository.mostPopular(new PageRequest(0, 4, new Sort(Sort.Direction.DESC, "viewNumber")));
		page.forEach((k) -> list.add(k));
		return list;

	}

	@Override
	public List<Announcement> getMyAnnouncements(long id) {
		return this.announcementRepository.findAllByOwnerId(id);
	}

}
