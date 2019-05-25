package cloud.imobiliare.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "zone")
public class Zone {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "zone_id")
	private long id;
	
	@NotNull
	@Column(name = "name")
	private String name;
	
	@NotNull
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

	@NotNull
	@Column(name = "SHOPS_NEARBY")
	private byte shopsNearby;

	@NotNull
	@Column(name = "ENTERTAINMENT_NEARBY")
	private byte entertainmentNearby;

	@NotNull
	@Column(name = "BARS_NEARBY")
	private byte barsNearby;

	@NotNull
	@Column(name = "PUBLICTRANSPORT_NEARBY")
	private byte publicTransportNearby;

	@NotNull
	@Column(name = "GREAT_VIEW")
	private byte greatView;

	@NotNull
	@Column(name = "PARKING")
	private byte parking;

	@NotNull
	@Column(name = "HARD_REACHABLE")
	private byte hardReachable;

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

	public byte getShopsNearby() {
		return shopsNearby;
	}

	public byte getEntertainmentNearby() {
		return entertainmentNearby;
	}

	public byte getBarsNearby() {
		return barsNearby;
	}

	public byte getPublicTransportNearby() {
		return publicTransportNearby;
	}

	public byte getGreatView() {
		return greatView;
	}

	public byte getParking() {
		return parking;
	}

	public byte getHardReachable() {
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

	public void setWastePollution(byte wastePollution) {
		this.wastePollution = wastePollution;
	}

	public void setNoisePollution(byte noisePollution) {
		this.noisePollution = noisePollution;
	}

	public void setChimicPollution(byte chimicPollution) {
		this.chimicPollution = chimicPollution;
	}

	public void setShopsNearby(byte shopsNearby) {
		this.shopsNearby = shopsNearby;
	}

	public void setEntertainmentNearby(byte entertainmentNearby) {
		this.entertainmentNearby = entertainmentNearby;
	}

	public void setBarsNearby(byte barsNearby) {
		this.barsNearby = barsNearby;
	}

	public void setPublicTransportNearby(byte publicTransportNearby) {
		this.publicTransportNearby = publicTransportNearby;
	}

	public void setGreatView(byte greatView) {
		this.greatView = greatView;
	}

	public void setParking(byte parking) {
		this.parking = parking;
	}

	public void setHardReachable(byte hardReachable) {
		this.hardReachable = hardReachable;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}

	private Zone(Integer postalCode, double latitude, double longitude, byte wastePollution, byte noisePollution,
			byte chimicPollution, byte shopsNearby, byte entertainmentNearby, byte barsNearby,
			byte publicTransportNearby, byte greatView, byte parking, byte hardReachable, String name) {
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
		this.name = name;
	}

	public static class ZoneBuilder {
		private Integer postalCode;
		private double latitude;
		private double longitude;
		private byte wastePollution;
		private byte noisePollution;
		private byte chimicPollution;
		private byte shopsNearby;
		private byte entertainmentNearby;
		private byte barsNearby;
		private byte publicTransportNearby;
		private byte greatView;
		private byte parking;
		private byte hardReachable;
		private String name;

		public ZoneBuilder() {
		}

		public ZoneBuilder postalCode(Integer postalCode) {
			validateNullData(postalCode);
			this.postalCode = postalCode;
			return this;
		}
		
		public ZoneBuilder name(String name) {
			validateNullData(name);
			this.name = name;
			return this;
		}

		public ZoneBuilder latitude(Double latitude) {
			validateNullData(latitude);
			this.latitude = latitude;
			return this;
		}

		public ZoneBuilder longitude(Double longitude) {
			validateNullData(longitude);
			this.longitude = longitude;
			return this;
		}

		public ZoneBuilder wastePollution(Byte wastePollution) {
			validateNullData(wastePollution);
			this.wastePollution = wastePollution;
			return this;
		}

		public ZoneBuilder noisePollution(Byte noisePollution) {
			validateNullData(noisePollution);
			this.noisePollution = noisePollution;
			return this;
		}

		public ZoneBuilder chimicPollution(Byte chimicPollution) {
			validateNullData(chimicPollution);
			this.chimicPollution = chimicPollution;
			return this;
		}

		public ZoneBuilder shopsNearby(Boolean shopsNearby) {
			if (shopsNearby == null || shopsNearby == false) {
				this.shopsNearby = 0;
				return this;
			}
			this.shopsNearby = 1;
			return this;
		}

		public ZoneBuilder entertainmentNearby(Boolean entertainmentNearby) {
			if (entertainmentNearby == null || entertainmentNearby == false) {
				this.entertainmentNearby = 0;
				return this;
			}
			this.entertainmentNearby = 1;
			return this;
		}

		public ZoneBuilder barsNearby(Boolean barsNearby) {
			if (barsNearby == null || barsNearby == false) {
				this.barsNearby = 0;
				return this;
			}
			this.barsNearby = 1;
			return this;
		}

		public ZoneBuilder publicTransportNearby(Boolean publicTransportNearby) {
			if (publicTransportNearby == null || publicTransportNearby == false) {
				this.publicTransportNearby = 0;
				return this;
			}
			this.publicTransportNearby = 1;
			return this;
		}

		public ZoneBuilder parking(Boolean parking) {
			if (parking == null || parking == false) {
				this.parking = 0;
				return this;
			}
			this.parking = 1;
			return this;
		}

		public ZoneBuilder greatView(Boolean greatView) {
			if (greatView == null || greatView == false) {
				this.greatView = 0;
				return this;
			}
			this.greatView = 1;
			return this;
		}

		public ZoneBuilder hardReachable(Boolean hardReachable) {
			if (hardReachable == null || hardReachable == false) {
				this.hardReachable = 0;
				return this;
			}
			this.hardReachable = 1;
			return this;
		}

		public Zone create() {
			return new Zone(postalCode, latitude, longitude, wastePollution, noisePollution, chimicPollution,
					shopsNearby, entertainmentNearby, barsNearby, publicTransportNearby, greatView, parking,
					hardReachable, name);
		}

		private void validateNullData(Object object) {
			if (object == null) {
				throw new IllegalArgumentException("Data is null !");
			}
		}
	}

}
