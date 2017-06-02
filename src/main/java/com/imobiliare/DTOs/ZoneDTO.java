package com.imobiliare.DTOs;

public class ZoneDTO {
	private long id;
	private int postalCode;
	private double latitude;
	private double longitude;
	private byte wastePollution;
	private byte noisePollution;
	private byte chimicPollution;
	private boolean shopsNearby;
	private boolean entertainmentNearby;
	private boolean barsNearby;
	private boolean publicTransportNearby;
	private boolean greatView;
	private boolean parking;
	private boolean hardReachable;

	public ZoneDTO (){
	}

	public long getId() {
		return id;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public byte getWastePollution() {
		return wastePollution;
	}

	public void setWastePollution(byte wastePollution) {
		this.wastePollution = wastePollution;
	}

	public byte getNoisePollution() {
		return noisePollution;
	}

	public byte getChimicPollution() {
		return chimicPollution;
	}

	public boolean isShopsNearby() {
		return shopsNearby;
	}

	public boolean isEntertainmentNearby() {
		return entertainmentNearby;
	}

	public boolean isBarsNearby() {
		return barsNearby;
	}

	public boolean isPublicTransportNearby() {
		return publicTransportNearby;
	}

	public boolean isGreatView() {
		return greatView;
	}

	public boolean isParking() {
		return parking;
	}

	public boolean isHardReachable() {
		return hardReachable;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public void setNoisePollution(byte noisePollution) {
		this.noisePollution = noisePollution;
	}

	public void setChimicPollution(byte chimicPollution) {
		this.chimicPollution = chimicPollution;
	}

	public void setShopsNearby(boolean shopsNearby) {
		this.shopsNearby = shopsNearby;
	}

	public void setEntertainmentNearby(boolean entertainmentNearby) {
		this.entertainmentNearby = entertainmentNearby;
	}

	public void setBarsNearby(boolean barsNearby) {
		this.barsNearby = barsNearby;
	}

	public void setPublicTransportNearby(boolean publicTransportNearby) {
		this.publicTransportNearby = publicTransportNearby;
	}

	public void setGreatView(boolean greatView) {
		this.greatView = greatView;
	}

	public void setParking(boolean parking) {
		this.parking = parking;
	}

	public void setHardReachable(boolean hardReachable) {
		this.hardReachable = hardReachable;
	}
	
	private ZoneDTO(long id, int postalCode, double latitude, double longitude, byte wastePollution,
			byte noisePollution, byte chimicPollution, boolean shopsNearby, boolean entertainmentNearby,
			boolean barsNearby, boolean publicTransportNearby, boolean greatView, boolean parking,
			boolean hardReachable) {
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
		private int postalCode;
		private double latitude;
		private double longitude;
		private byte wastePollution;
		private byte noisePollution;
		private byte chimicPollution;
		private boolean shopsNearby;
		private boolean entertainmentNearby;
		private boolean barsNearby;
		private boolean publicTransportNearby;
		private boolean greatView;
		private boolean parking;
		private boolean hardReachable;

		public ZoneBuilder() {
		}

		public ZoneBuilder id(long id) {
			this.id = id;
			return this;
		}

		public ZoneBuilder postalCode(int postalCode) {
			this.postalCode = postalCode;
			return this;
		}

		public ZoneBuilder latitude(double latitude) {
			this.latitude = latitude;
			return this;
		}

		public ZoneBuilder longitude(double longitude) {
			this.longitude = longitude;
			return this;
		}

		public ZoneBuilder wastePollution(byte wastePollution) {
			this.wastePollution = wastePollution;
			return this;
		}

		public ZoneBuilder noisePollution(byte noisePollution) {
			this.noisePollution = noisePollution;
			return this;
		}

		public ZoneBuilder chimicPollution(byte chimicPollution) {
			this.wastePollution = chimicPollution;
			return this;
		}

		public ZoneBuilder shopsNearby(boolean shopsNearby) {
			this.shopsNearby = shopsNearby;
			return this;
		}

		public ZoneBuilder entertainmentNearby(boolean entertainmentNearby) {
			this.entertainmentNearby = entertainmentNearby;
			return this;
		}

		public ZoneBuilder barsNearby(boolean barsNearby) {
			this.barsNearby = barsNearby;
			return this;
		}

		public ZoneBuilder publicTransportNearby(boolean publicTransportNearby) {
			this.publicTransportNearby = publicTransportNearby;
			return this;
		}

		public ZoneBuilder greatView(boolean greatView) {
			this.greatView = greatView;
			return this;
		}

		public ZoneBuilder parking(boolean parking) {
			this.parking = parking;
			return this;
		}

		public ZoneBuilder hardReachable(boolean hardReachable) {
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