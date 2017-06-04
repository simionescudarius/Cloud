package com.imobiliare.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
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

	public long getId() {
		return id;
	}

	public User getUser1() {
		return user1;
	}

	public User getUser2() {
		return user2;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}
}
