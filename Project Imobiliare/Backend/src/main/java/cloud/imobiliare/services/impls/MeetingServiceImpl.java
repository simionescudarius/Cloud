package cloud.imobiliare.services.impls;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cloud.imobiliare.entities.Meeting;
import cloud.imobiliare.entities.User;
import cloud.imobiliare.repositories.MeetingRepository;
import cloud.imobiliare.services.MeetingService;

@Service
@Transactional
public class MeetingServiceImpl implements MeetingService {
	@Autowired
	private MeetingRepository meetingRepository;

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
		Optional<Meeting> meeting = meetingRepository.findById(id);

		if (meeting.isPresent()) {
			return meeting.get();
		}

		return null;
	}

	@Override
	public void delete(Long id) {
		meetingRepository.deleteById(id);
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
