package com.imobiliare.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name = "zone")
@Table(name = "zone")
public class Zone {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "zone_id")
	private long id;
	
	@Column(name="post_code")
	private int postalCode;
	
	@NotNull
	@Column(name="latitude")
	private double latitude;
	
	@NotNull
	@Column(name="longitude")
	private double longitude;
	
	@NotNull
	@Column(name="NOISE_POLLUTION")
	private byte noisePollution;
	
	@NotNull
	@Column(name="CHIMIC_POLLUTION")
	private byte chimicPollution;
	
	@NotNull
	@Column(name="SHOPS_NEARBY")
	private byte shopsNearby;
	
	@Column(name="ENTERTAINMENT_NEARBY")
	private byte entertainmentNearby;
	
	@Column(name="BARS_NEARBY")
	private byte barsNearby;
	
	@Column(name="PUBLICTRANSPORT_NEARBY")
	private byte publicTransportNearby;
	
	@Column(name="GREAT_VIEW")
	private byte greatView;
	
	@Column(name="PARKING")
	private byte parking;
	
	@Column(name="HARD_REACHABLE")
	private byte hardReachable;
	
}
