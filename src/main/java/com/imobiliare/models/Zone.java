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

	@Column(name = "post_code")
	private Integer postalCode;

	@NotNull
	@Column(name = "latitude")
	private double latitude;

	@NotNull
	@Column(name = "longitude")
	private double longitude;

	@NotNull
	@Column(name = "WASTE_POLLUTION")
	private byte wastePollution;

	@NotNull
	@Column(name = "NOISE_POLLUTION")
	private byte noisePollution;

	@NotNull
	@Column(name = "CHIMIC_POLLUTION")
	private byte chimicPollution;

	@Column(name = "SHOPS_NEARBY")
	private Byte shopsNearby;

	@Column(name = "ENTERTAINMENT_NEARBY")
	private Byte entertainmentNearby;

	@Column(name = "BARS_NEARBY")
	private Byte barsNearby;

	@Column(name = "PUBLICTRANSPORT_NEARBY")
	private Byte publicTransportNearby;

	@Column(name = "GREAT_VIEW")
	private Byte greatView;

	@Column(name = "PARKING")
	private Byte parking;

	@Column(name = "HARD_REACHABLE")
	private Byte hardReachable;

	public Zone() {
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

	public byte getNoisePollution() {
		return noisePollution;
	}

	public byte getChimicPollution() {
		return chimicPollution;
	}

	public Byte getShopsNearby() {
		return shopsNearby;
	}

	public Byte getEntertainmentNearby() {
		return entertainmentNearby;
	}

	public Byte getBarsNearby() {
		return barsNearby;
	}

	public Byte getPublicTransportNearby() {
		return publicTransportNearby;
	}

	public Byte getGreatView() {
		return greatView;
	}

	public Byte getParking() {
		return parking;
	}

	public Byte getHardReachable() {
		return hardReachable;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public void setWastePollution(byte wastePollution) {
		this.wastePollution = wastePollution;
	}

	public void setNoisePollution(byte noisePollution) {
		this.noisePollution = noisePollution;
	}

	public void setChimicPollution(byte chimicPollution) {
		this.chimicPollution = chimicPollution;
	}

	public void setShopsNearby(Byte shopsNearby) {
		this.shopsNearby = shopsNearby;
	}

	public void setEntertainmentNearby(Byte entertainmentNearby) {
		this.entertainmentNearby = entertainmentNearby;
	}

	public void setBarsNearby(Byte barsNearby) {
		this.barsNearby = barsNearby;
	}

	public void setPublicTransportNearby(Byte publicTransportNearby) {
		this.publicTransportNearby = publicTransportNearby;
	}

	public void setGreatView(Byte greatView) {
		this.greatView = greatView;
	}

	public void setParking(Byte parking) {
		this.parking = parking;
	}

	public void setHardReachable(Byte hardReachable) {
		this.hardReachable = hardReachable;
	}

	private Zone(Integer postalCode, double latitude, double longitude, byte wastePollution,
			byte noisePollution, byte chimicPollution, Byte shopsNearby, Byte entertainmentNearby, Byte barsNearby,
			Byte publicTransportNearby, Byte greatView, Byte parking, Byte hardReachable) {
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
		private Integer postalCode;
		private double latitude;
		private double longitude;
		private byte wastePollution;
		private byte noisePollution;
		private byte chimicPollution;
		private Byte shopsNearby;
		private Byte entertainmentNearby;
		private Byte barsNearby;
		private Byte publicTransportNearby;
		private Byte greatView;
		private Byte parking;
		private Byte hardReachable;

		public ZoneBuilder() {
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

		public ZoneBuilder wastePollution(byte wastePollution) {
			this.wastePollution = wastePollution;
			return this;
		}

		public ZoneBuilder noisePollution(byte noisePollution) {
			this.noisePollution = noisePollution;
			return this;
		}

		public ZoneBuilder chimicPollution(byte chimicPollution) {
			this.chimicPollution = chimicPollution;
			return this;
		}

		public ZoneBuilder shopsNearby(boolean shopsNearby) {
			if (shopsNearby == true) {
				this.shopsNearby = 1;
				return this;
			}
			this.shopsNearby = 0;
			return this;
		}

		public ZoneBuilder entertainmentNearby(boolean entertainmentNearby) {
			if (entertainmentNearby == true) {
				this.entertainmentNearby = 1;
				return this;
			}
			this.entertainmentNearby = 0;
			return this;
		}

		public ZoneBuilder barsNearby(boolean barsNearby) {
			if (barsNearby == true) {
				this.barsNearby = 1;
				return this;
			}
			this.barsNearby = 0;
			return this;
		}

		public ZoneBuilder publicTransportNearby(boolean publicTransportNearby) {
			if (publicTransportNearby == true) {
				this.publicTransportNearby = 1;
				return this;
			}
			this.publicTransportNearby = 0;
			return this;
		}

		public ZoneBuilder parking(boolean parking) {
			if (parking == true) {
				this.parking = 1;
				return this;
			}
			this.parking = 0;
			return this;
		}

		public ZoneBuilder greatView(boolean greatView) {
			if (greatView == true) {
				this.greatView = 1;
				return this;
			}
			this.greatView = 0;
			return this;
		}

		public ZoneBuilder hardReachable(boolean hardReachable) {
			if (hardReachable == true) {
				this.hardReachable = 1;
				return this;
			}
			this.hardReachable = 0;
			return this;
		}

		public Zone create() {
			return new Zone(postalCode, latitude, longitude, wastePollution, noisePollution, chimicPollution,
					shopsNearby, entertainmentNearby, barsNearby, publicTransportNearby, greatView, parking,
					hardReachable);
		}
	}

}
