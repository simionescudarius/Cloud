package cloud.imobiliare.services;

import java.util.List;

import cloud.imobiliare.entities.Meeting;
import cloud.imobiliare.entities.User;
import cloud.imobiliare.services.common.CrudService;

public interface MeetingService extends CrudService<Meeting, Long> {
	void acceptMeeting(Long id);
	List<Meeting> getMyMeetings(User user);
}
