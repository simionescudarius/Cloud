package com.imobiliare.DTOs;

public class RealEstateTypeDTO {
	private long id;
	private String name;

	public RealEstateTypeDTO(){
	}
	
	public RealEstateTypeDTO(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
}
