package com.imobiliare.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="realestate_types")
public class RealEstateType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="type_id")
	private long id;
	
	@NotNull
	@Column(name = "name")
	private String name;

	public RealEstateType(){
	}

	public RealEstateType(String name) {
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
