package com.imobiliare.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imobiliare.embeddables.FavouritesKey;
import com.imobiliare.models.FavouriteAnnouncement;

@Repository
public interface FavouriteAnnouncementRepository extends JpaRepository<FavouriteAnnouncement, FavouritesKey> {
	List<FavouriteAnnouncement> findAllByUserId(long userId);
}