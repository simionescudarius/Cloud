package com.imobiliare.DTOs;

import java.util.Date;

public class AnnouncementDTO {
	private Long id;
	private UserDTO owner;
	private RealEstateDTO realEstate;
	private Date postDate;
	private Date expireDate;
	private Long viewNumber;
	private Integer price;

	public AnnouncementDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserDTO getOwner() {
		return owner;
	}

	public RealEstateDTO getRealEstate() {
		return realEstate;
	}

	public Date getPostDate() {
		return postDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public Long getViewNumber() {
		return viewNumber;
	}

	public void setOwner(UserDTO owner) {
		this.owner = owner;
	}

	public void setRealEstate(RealEstateDTO realEstate) {
		this.realEstate = realEstate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public void setViewNumber(Long viewNumber) {
		this.viewNumber = viewNumber;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	private AnnouncementDTO(Long id, UserDTO owner, RealEstateDTO realEstate, Date postDate, Date expireDate,
			Long viewNumber, Integer price) {
		this.id = id;
		this.owner = owner;
		this.realEstate = realEstate;
		this.postDate = postDate;
		this.expireDate = expireDate;
		this.viewNumber = viewNumber;
		this.price = price;
	}

	public static class AnnouncementDTOBuilder {
		private Long id;
		private UserDTO owner;
		private RealEstateDTO realEstate;
		private Date postDate;
		private Date expireDate;
		private Long viewNumber;
		private Integer price;

		public AnnouncementDTOBuilder() {
		}

		public AnnouncementDTOBuilder id(Long id) {
			this.id = id;
			return this;
		}

		public AnnouncementDTOBuilder owner(UserDTO owner) {
			this.owner = owner;
			return this;
		}

		public AnnouncementDTOBuilder realEstate(RealEstateDTO realEstate) {
			this.realEstate = realEstate;
			return this;
		}

		public AnnouncementDTOBuilder postDate(Date postDate) {
			this.postDate = postDate;
			return this;
		}

		public AnnouncementDTOBuilder expireDate(Date expireDate) {
			this.expireDate = expireDate;
			return this;
		}

		public AnnouncementDTOBuilder viewNumber(Long viewNumber) {
			this.viewNumber = viewNumber;
			return this;
		}

		public AnnouncementDTOBuilder price(Integer price) {
			this.price = price;
			return this;
		}

		public AnnouncementDTO create() {
			return new AnnouncementDTO(id, owner, realEstate, postDate, expireDate, viewNumber, price);
		}
	}
}
