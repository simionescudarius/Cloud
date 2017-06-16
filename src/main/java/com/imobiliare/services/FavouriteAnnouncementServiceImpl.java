package com.imobiliare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imobiliare.embeddables.FavouritesKey;
import com.imobiliare.models.FavouriteAnnouncement;
import com.imobiliare.repositories.FavouriteAnnouncementRepository;

@Service
public class FavouriteAnnouncementServiceImpl implements FavouriteAnnouncementService {
	@Autowired
	FavouriteAnnouncementRepository favouriteAnnouncementRepository;

	@Override
	public void save(FavouriteAnnouncement object) {
		this.favouriteAnnouncementRepository.save(object);
	}

	@Override
	public List<FavouriteAnnouncement> getAll() {
		return this.favouriteAnnouncementRepository.findAll();
	}

	@Override
	public FavouriteAnnouncement getById(FavouritesKey id) {
		return this.favouriteAnnouncementRepository.findOne(id);
	}

	@Override
	public void delete(FavouritesKey id) {
		this.favouriteAnnouncementRepository.delete(id);
	}

	@Override
	public List<FavouriteAnnouncement> getFavourites(long id) {
		return this.favouriteAnnouncementRepository.findAllByUserId(id);
	}

}
