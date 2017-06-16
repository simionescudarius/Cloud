package com.imobiliare.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.imobiliare.embeddables.FavouritesKey;

@Entity
@Table(name = "favourites")
public class FavouriteAnnouncement {

	@EmbeddedId
	private FavouritesKey key;

	@ManyToOne
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private User user;

	@ManyToOne
	@JoinColumn(name = "announcement_id", insertable = false, updatable = false)
	private Announcement announcement;

	public FavouritesKey getKey() {
		return key;
	}

	public void setKey(FavouritesKey key) {
		this.key = key;
	}

	public User getUser() {
		return user;
	}

	public Announcement getAnnouncement() {
		return announcement;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setAnnouncement(Announcement announcement) {
		this.announcement = announcement;
	}

}
