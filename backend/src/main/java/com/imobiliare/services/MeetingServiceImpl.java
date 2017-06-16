package com.imobiliare.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imobiliare.models.Meeting;
import com.imobiliare.models.User;
import com.imobiliare.repositories.MeetingRepository;

@Service
@Transactional
public class MeetingServiceImpl implements MeetingService {
	@Autowired
	MeetingRepository meetingRepository;

	@Override
	public void save(Meeting object) {
		meetingRepository.save(object);
	}

	@Override
	public List<Meeting> getAll() {
		return meetingRepository.findAll();
	}

	@Override
	public Meeting getById(Long id) {
		return meetingRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		meetingRepository.delete(id);
	}

	@Override
	public void acceptMeeting(Long id) {
		this.meetingRepository.acceptMeeting(id);
	}

	@Override
	public List<Meeting> getMyMeetings(User user) {
		return this.meetingRepository.findAllByUser1(user);
	}

}
