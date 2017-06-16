package com.imobiliare.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "realestates")
public class RealEstate {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "realestate_id")
	private long id;
	
	@NotNull
	@Column(name = "type_id")
	private Long typeId;
	
	@NotNull
	@Column(name = "zone_id")
	private Long zoneId;
	
	@NotNull
	@Column(name = "area")
	private int area;
	
	@NotNull
	@Column(name = "room_number")
	private int roomNumber;

	@ManyToOne
	@JoinColumn(name="type_id", insertable = false, updatable = false)
	private RealEstateType type;
	
	@ManyToOne
	@JoinColumn(name="zone_id", insertable = false, updatable = false)
	private Zone zone;

	public RealEstate(){
	}
	
	public RealEstate(Long typeId, Long zoneId, int area, int roomNumber) {
		this.typeId = typeId;
		this.zoneId = zoneId;
		this.area = area;
		this.roomNumber = roomNumber;
	}

	public long getId() {
		return id;
	}

	public RealEstateType getType() {
		return type;
	}

	public Zone getZone() {
		return zone;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setType(RealEstateType type) {
		this.type = type;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public Long getTypeId() {
		return typeId;
	}

	public Long getZoneId() {
		return zoneId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public void setZoneId(Long zoneId) {
		this.zoneId = zoneId;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
}
