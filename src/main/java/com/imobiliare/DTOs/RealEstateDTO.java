package com.imobiliare.DTOs;

public class RealEstateDTO {
	private long id;
	private RealEstateTypeDTO type;
	private ZoneDTO zone;

	public RealEstateDTO(){
	}
	
	public RealEstateDTO(long id, RealEstateTypeDTO type, ZoneDTO zone) {
		this.id = id;
		this.type = type;
		this.zone = zone;
	}

	public long getId() {
		return id;
	}

	public RealEstateTypeDTO getType() {
		return type;
	}

	public ZoneDTO getZone() {
		return zone;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setType(RealEstateTypeDTO type) {
		this.type = type;
	}

	public void setZone(ZoneDTO zone) {
		this.zone = zone;
	}
}
