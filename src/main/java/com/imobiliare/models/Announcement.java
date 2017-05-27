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

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User owner;
	
	@ManyToOne
	@JoinColumn(name = "realestate_id")
	private RealEstate realEstate;
	
	@NotNull
	@Column(name = "post_date")
	private Date postDate;
	
	@Column(name = "expire_date")
	private Date expireDate;
	
	@Column(name = "viewNumber")
	private long viewNumber;
}
