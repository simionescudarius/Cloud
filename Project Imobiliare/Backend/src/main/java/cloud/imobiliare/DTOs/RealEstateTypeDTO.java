package cloud.imobiliare.DTOs;

import javax.validation.constraints.NotNull;

public class RealEstateTypeDTO {
	private long id;
	@NotNull
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
