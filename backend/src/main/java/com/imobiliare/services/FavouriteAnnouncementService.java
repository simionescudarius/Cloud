package com.imobiliare.services;

import java.util.List;

import com.imobiliare.embeddables.FavouritesKey;
import com.imobiliare.models.FavouriteAnnouncement;

public interface FavouriteAnnouncementService extends CrudService<FavouriteAnnouncement, FavouritesKey>{

	List<FavouriteAnnouncement> getFavourites(long id);
}