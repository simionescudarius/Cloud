package com.imobiliare.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name = "announcements")
@Table(name = "announcements")
public class Announcement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "announcement_id")
	private long id;
	
	@NotNull
	@Column(name = "user_id")
	private Long ownerId;

	@ManyToOne
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private User owner;
	
	@NotNull
	@Column(name = "realestate_id")
	private Long realEstateId;
	
	@ManyToOne
	@JoinColumn(name = "realestate_id", insertable = false, updatable = false)
	private RealEstate realEstate;
	
	@NotNull
	@Column(name = "post_date")
	private Date postDate;
	
	@Column(name = "expire_date")
	private Date expireDate;
	
	@Column(name = "view_number")
	private Long viewNumber;

	public Announcement(){
	}
	
	public long getId() {
		return id;
	}

	public User getOwner() {
		return owner;
	}

	public RealEstate getRealEstate() {
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

	public Long getOwnerId() {
		return ownerId;
	}

	public Long getRealEstateId() {
		return realEstateId;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public void setRealEstate(RealEstate realEstate) {
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

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public void setRealEstateId(Long realEstateId) {
		this.realEstateId = realEstateId;
	}
	
	public Announcement(Long ownerId, Long realEstateId, Date postDate,
			Date expireDate, Long viewNumber) {
		this.ownerId = ownerId;
		this.realEstateId = realEstateId;
		this.postDate = postDate;
		this.expireDate = expireDate;
		this.viewNumber = viewNumber;
	}
}
