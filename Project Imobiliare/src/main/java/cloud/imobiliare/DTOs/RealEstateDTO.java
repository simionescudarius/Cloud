package cloud.imobiliare.DTOs;

public class RealEstateDTO {
	private long id;
	private RealEstateTypeDTO type;
	private ZoneDTO zone;
	private int area;
	private int roomNumber;

	public RealEstateDTO(){
	}
	
	public RealEstateDTO(long id, RealEstateTypeDTO type, ZoneDTO zone, int area, int roomNumber) {
		this.id = id;
		this.type = type;
		this.zone = zone;
		this.area = area;
		this.roomNumber = roomNumber;
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
