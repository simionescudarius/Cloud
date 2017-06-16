package com.imobiliare.services;

import java.util.List;

import com.imobiliare.models.Meeting;
import com.imobiliare.models.User;

public interface MeetingService extends CrudService<Meeting, Long> {
	void acceptMeeting(Long id);
	List<Meeting> getMyMeetings(User user);
}
