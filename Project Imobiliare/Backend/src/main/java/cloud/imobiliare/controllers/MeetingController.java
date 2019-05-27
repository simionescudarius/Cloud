package cloud.imobiliare.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.management.relation.InvalidRoleInfoException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cloud.imobiliare.DTOs.MeetingDTO;
import cloud.imobiliare.entities.Meeting;
import cloud.imobiliare.entities.User;
import cloud.imobiliare.enums.UserRoles;
import cloud.imobiliare.security.JWebTokenUser;
import cloud.imobiliare.services.AnnouncementService;
import cloud.imobiliare.services.MeetingService;
import cloud.imobiliare.services.UserService;
import cloud.imobiliare.transformers.AnnouncementTransformer;
import cloud.imobiliare.transformers.MeetingTransformer;

@CrossOrigin
@RestController
@RequestMapping(value = "/v1/meetings")
public class MeetingController extends Controller {

	@Autowired
	private UserService userService;

	@Autowired
	private MeetingService meetingService;

	@Autowired
	private AnnouncementService announcementService;

	@Autowired
	private MeetingTransformer meetingTransformer;

	@Autowired
	private AnnouncementTransformer announcementTransformer;

	@RequestMapping(method = RequestMethod.GET, value = "/myMeetings")
	public ResponseEntity<List<MeetingDTO>> getMyMeetings(HttpServletRequest request) {
		JWebTokenUser sessionUser = (JWebTokenUser) request.getAttribute("jwtUser");
		try {
			if (UserRoles.toEnum(sessionUser.getRole()).getRightsLevel() < LEVEL_1_AUTH) {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
		} catch (InvalidRoleInfoException | IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		List<Meeting> test = new ArrayList<>();
		test = meetingService.getMyMeetings(userService.getById(sessionUser.getId()));

		List<MeetingDTO> test2 = new ArrayList<>();
		test.forEach((k) -> test2.add(meetingTransformer.toDTO(k)));
		return new ResponseEntity<>(test2, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{userId}/{announcementId}")
	public ResponseEntity<?> addMeeting(@PathVariable("userId") Long userId,
			@PathVariable("announcementId") Long announcementId, HttpServletRequest request) {
		JWebTokenUser sessionUser = (JWebTokenUser) request.getAttribute("jwtUser");
		User user2;
		try {
			if (UserRoles.toEnum(sessionUser.getRole()).getRightsLevel() < LEVEL_1_AUTH) {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
			validateNullData(userId);
			user2 = userService.getById(userId);
			if (user2 == null) {
				throw new IllegalArgumentException();
			}
		} catch (InvalidRoleInfoException | IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Meeting meeting = new Meeting();
		meeting.setUser1(userService.getById(sessionUser.getId()));
		meeting.setUser2(userService.getById(userId));
		meeting.setAnnouncement(announcementTransformer.toModel(announcementService.getById(announcementId)));
		meeting.setAccepted((byte) 0);
		meetingService.save(meeting);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{meetingId}")
	public ResponseEntity<?> acceptMeeting(@PathVariable("meetingId") Long meetingId, HttpServletRequest request) {
		JWebTokenUser sessionUser = (JWebTokenUser) request.getAttribute("jwtUser");
		Meeting meeting;
		try {
			if (UserRoles.toEnum(sessionUser.getRole()).getRightsLevel() < LEVEL_1_AUTH) {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
			validateNullData(meetingId);
			meeting = meetingService.getById(meetingId);
			if (meeting == null) {
				throw new IllegalArgumentException();
			}
		} catch (InvalidRoleInfoException | IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if (sessionUser.getId() != meeting.getUser1().getId()) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		meetingService.acceptMeeting(meetingId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public MeetingService getMeetingService() {
		return meetingService;
	}

	public void setMeetingService(MeetingService meetingService) {
		this.meetingService = meetingService;
	}

	public AnnouncementService getAnnouncementService() {
		return announcementService;
	}

	public void setAnnouncementService(AnnouncementService announcementService) {
		this.announcementService = announcementService;
	}

	public MeetingTransformer getMeetingTransformer() {
		return meetingTransformer;
	}

	public void setMeetingTransformer(MeetingTransformer meetingTransformer) {
		this.meetingTransformer = meetingTransformer;
	}

	public AnnouncementTransformer getAnnouncementTransformer() {
		return announcementTransformer;
	}

	public void setAnnouncementTransformer(AnnouncementTransformer announcementTransformer) {
		this.announcementTransformer = announcementTransformer;
	}
}
