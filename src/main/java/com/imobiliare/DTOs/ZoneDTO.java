package com.imobiliare.DTOs;

public class ZoneDTO {
	private long id;
	private Integer postalCode;
	private Double latitude;
	private Double longitude;
	private Byte wastePollution;
	private Byte noisePollution;
	private Byte chimicPollution;
	private Boolean shopsNearby;
	private Boolean entertainmentNearby;
	private Boolean barsNearby;
	private Boolean publicTransportNearby;
	private Boolean greatView;
	private Boolean parking;
	private Boolean hardReachable;

	public ZoneDTO (){
	}

	public long getId() {
		return id;
	}

	public Integer getPostalCode() {
		return postalCode;
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public Byte getWastePollution() {
		return wastePollution;
	}

	public void setWastePollution(Byte wastePollution) {
		this.wastePollution = wastePollution;
	}

	public Byte getNoisePollution() {
		return noisePollution;
	}

	public Byte getChimicPollution() {
		return chimicPollution;
	}

	public Boolean isShopsNearby() {
		return shopsNearby;
	}

	public Boolean isEntertainmentNearby() {
		return entertainmentNearby;
	}

	public Boolean isBarsNearby() {
		return barsNearby;
	}

	public Boolean isPublicTransportNearby() {
		return publicTransportNearby;
	}

	public Boolean isGreatView() {
		return greatView;
	}

	public Boolean isParking() {
		return parking;
	}

	public Boolean isHardReachable() {
		return hardReachable;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public void setNoisePollution(Byte noisePollution) {
		this.noisePollution = noisePollution;
	}

	public void setChimicPollution(Byte chimicPollution) {
		this.chimicPollution = chimicPollution;
	}

	public void setShopsNearby(Boolean shopsNearby) {
		this.shopsNearby = shopsNearby;
	}

	public void setEntertainmentNearby(Boolean entertainmentNearby) {
		this.entertainmentNearby = entertainmentNearby;
	}

	public void setBarsNearby(Boolean barsNearby) {
		this.barsNearby = barsNearby;
	}

	public void setPublicTransportNearby(Boolean publicTransportNearby) {
		this.publicTransportNearby = publicTransportNearby;
	}

	public void setGreatView(Boolean greatView) {
		this.greatView = greatView;
	}

	public void setParking(Boolean parking) {
		this.parking = parking;
	}

	public void setHardReachable(Boolean hardReachable) {
		this.hardReachable = hardReachable;
	}
	
	private ZoneDTO(long id, Integer postalCode, Double latitude, Double longitude, Byte wastePollution,
			Byte noisePollution, Byte chimicPollution, Boolean shopsNearby, Boolean entertainmentNearby,
			Boolean barsNearby, Boolean publicTransportNearby, Boolean greatView, Boolean parking,
			Boolean hardReachable) {
		this.id = id;
		this.postalCode = postalCode;
		this.latitude = latitude;
		this.longitude = longitude;
		this.wastePollution = wastePollution;
		this.noisePollution = noisePollution;
		this.chimicPollution = chimicPollution;
		this.shopsNearby = shopsNearby;
		this.entertainmentNearby = entertainmentNearby;
		this.barsNearby = barsNearby;
		this.publicTransportNearby = publicTransportNearby;
		this.greatView = greatView;
		this.parking = parking;
		this.hardReachable = hardReachable;
	}

	public static class ZoneBuilder {
		private long id;
		private Integer postalCode;
		private Double latitude;
		private Double longitude;
		private Byte wastePollution;
		private Byte noisePollution;
		private Byte chimicPollution;
		private Boolean shopsNearby;
		private Boolean entertainmentNearby;
		private Boolean barsNearby;
		private Boolean publicTransportNearby;
		private Boolean greatView;
		private Boolean parking;
		private Boolean hardReachable;

		public ZoneBuilder() {
		}

		public ZoneBuilder id(long id) {
			this.id = id;
			return this;
		}

		public ZoneBuilder postalCode(Integer postalCode) {
			this.postalCode = postalCode;
			return this;
		}

		public ZoneBuilder latitude(Double latitude) {
			this.latitude = latitude;
			return this;
		}

		public ZoneBuilder longitude(Double longitude) {
			this.longitude = longitude;
			return this;
		}

		public ZoneBuilder wastePollution(Byte wastePollution) {
			this.wastePollution = wastePollution;
			return this;
		}

		public ZoneBuilder noisePollution(Byte noisePollution) {
			this.noisePollution = noisePollution;
			return this;
		}

		public ZoneBuilder chimicPollution(Byte chimicPollution) {
			this.wastePollution = chimicPollution;
			return this;
		}

		public ZoneBuilder shopsNearby(Boolean shopsNearby) {
			this.shopsNearby = shopsNearby;
			return this;
		}

		public ZoneBuilder entertainmentNearby(Boolean entertainmentNearby) {
			this.entertainmentNearby = entertainmentNearby;
			return this;
		}

		public ZoneBuilder barsNearby(Boolean barsNearby) {
			this.barsNearby = barsNearby;
			return this;
		}

		public ZoneBuilder publicTransportNearby(Boolean publicTransportNearby) {
			this.publicTransportNearby = publicTransportNearby;
			return this;
		}

		public ZoneBuilder greatView(Boolean greatView) {
			this.greatView = greatView;
			return this;
		}

		public ZoneBuilder parking(Boolean parking) {
			this.parking = parking;
			return this;
		}

		public ZoneBuilder hardReachable(Boolean hardReachable) {
			this.hardReachable = hardReachable;
			return this;
		}

		public ZoneDTO create() {
			return new ZoneDTO(this.id, this.postalCode, this.latitude, this.longitude, this.wastePollution,
					this.noisePollution, this.chimicPollution, this.shopsNearby, this.entertainmentNearby,
					this.barsNearby, this.publicTransportNearby, this.greatView, this.parking, this.hardReachable);
		}
	}

}