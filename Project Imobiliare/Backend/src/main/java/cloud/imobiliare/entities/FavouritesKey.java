package cloud.imobiliare.entities;

import java.io.Serializable;

import javax.persistence.Column;

public class FavouritesKey implements Serializable {
	private static final long serialVersionUID = 2264828517610847802L;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "announcement_id")
	private Long announcementId;

	public Long getUserId() {
		return userId;
	}

	public Long getAnnouncementId() {
		return announcementId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setAnnouncementId(Long announcementId) {
		this.announcementId = announcementId;
	}
}
