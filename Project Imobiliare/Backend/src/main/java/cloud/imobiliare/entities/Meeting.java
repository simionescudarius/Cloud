package cloud.imobiliare.entities;

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
@Table(name = "meetings")
public class Meeting {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "meeting_id")
	private long id;

	@ManyToOne
	@JoinColumn(name = "user_id_1")
	private User user1;

	@ManyToOne
	@JoinColumn(name = "user_id_2")
	private User user2;
	
	@ManyToOne
	@JoinColumn(name = "announcement_id")
	private Announcement announcement;

	@NotNull
	@Column(name = "accepted")
	private byte accepted;

	public long getId() {
		return id;
	}

	public User getUser1() {
		return user1;
	}

	public User getUser2() {
		return user2;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

	public byte getAccepted() {
		return accepted;
	}

	public void setAccepted(byte accepted) {
		this.accepted = accepted;
	}

	public Announcement getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(Announcement announcement) {
		this.announcement = announcement;
	}
}
