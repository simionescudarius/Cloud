package cloud.imobiliare.entities;

import java.util.Date;

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
@Table(name = "announcements")
public class Announcement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "announcement_id")
	private long id;

	@NotNull
	@Column(name = "name")
	private String name;

	@NotNull
	@Column(name = "user_id")
	private Long ownerId;

	@ManyToOne
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private User owner;

	@NotNull
	@Column(name = "realestate_id")
	private Long realEstateId;

	@ManyToOne
	@JoinColumn(name = "realestate_id", insertable = false, updatable = false)
	private RealEstate realEstate;

	@NotNull
	@Column(name = "post_date")
	private Date postDate;

	@Column(name = "expire_date")
	private Date expireDate;

	@NotNull
	@Column(name = "view_number")
	private long viewNumber;

	@NotNull
	@Column(name = "description")
	private String description;

	@NotNull
	@Column(name = "price")
	private int price;

	public Announcement() {
	}

	public long getId() {
		return id;
	}

	public User getOwner() {
		return owner;
	}

	public RealEstate getRealEstate() {
		return realEstate;
	}

	public Date getPostDate() {
		return postDate;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public long getViewNumber() {
		return viewNumber;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public Long getRealEstateId() {
		return realEstateId;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public void setRealEstate(RealEstate realEstate) {
		this.realEstate = realEstate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public void setViewNumber(long viewNumber) {
		this.viewNumber = viewNumber;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public void setRealEstateId(Long realEstateId) {
		this.realEstateId = realEstateId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private Announcement(Long ownerId, String name, Long realEstateId, Date postDate, Date expireDate, long viewNumber,
			String description, int price) {
		this.ownerId = ownerId;
		this.name = name;
		this.realEstateId = realEstateId;
		this.postDate = postDate;
		this.expireDate = expireDate;
		this.viewNumber = viewNumber;
		this.description = description;
		this.price = price;
	}

	public static class AnnouncementBuilder {
		private Long ownerId;
		private String name;
		private Long realEstateId;
		private Date postDate;
		private Date expireDate;
		private long viewNumber = 0l;
		private String description;
		private int price;

		public AnnouncementBuilder() {
		}

		public AnnouncementBuilder ownerId(Long ownerId) {
			this.ownerId = ownerId;
			return this;
		}
		
		public AnnouncementBuilder price(int price) {
			this.price = price;
			return this;
		}


		public AnnouncementBuilder name(String name) {
			this.name = name;
			return this;
		}

		public AnnouncementBuilder realEstateId(Long realEstateId) {
			this.realEstateId = realEstateId;
			return this;
		}

		public AnnouncementBuilder postDate(Date postDate) {
			this.postDate = postDate;
			return this;
		}

		public AnnouncementBuilder expireDate(Date expireDate) {
			this.expireDate = expireDate;
			return this;
		}
		
		public AnnouncementBuilder description(String description) {
			this.description = description;
			return this;
		}

		public Announcement create() {
			return new Announcement(ownerId, name, realEstateId, postDate, expireDate, viewNumber, description, price);
		}

	}
}
