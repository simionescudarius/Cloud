package com.imobiliare.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "meetings")
@Table(name = "meetings")
public class Meeting {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="meeting_id")
	private long id;
	
	@ManyToOne
	@JoinColumn(name="USER_ID_1")
	private User user1;

	@ManyToOne
	@JoinColumn(name="USER_ID_2")
	private User user2;
}
