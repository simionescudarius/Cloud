package com.imobiliare.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "realestates")
@Table(name = "realestates")
public class RealEstate {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "realestate_id")
	private long id;

	@ManyToOne
	@JoinColumn(name="type_id", insertable = false, updatable = false)
	private RealEstateType type;
	
	@ManyToOne
	@JoinColumn(name="zone_id", insertable = false, updatable = false)
	private Zone zone;
}
