package com.imobiliare.controllers;

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

import com.imobiliare.DTOs.MeetingDTO;
import com.imobiliare.enums.UserRoles;
import com.imobiliare.models.Meeting;
import com.imobiliare.models.User;
import com.imobiliare.security.JwtUser;
import com.imobiliare.services.AnnouncementService;
import com.imobiliare.services.MeetingService;
import com.imobiliare.services.UserService;
import com.imobiliare.transformers.MeetingTransformer;

@CrossOrigin
@RestController
@RequestMapping(value = "/v1/meetings")
public class MeetingController extends Controller {
	@Autowired
	UserService userService;
	@Autowired
	MeetingService meetingService;
	@Autowired
	AnnouncementService announcementService;
	
	@Autowired
	MeetingTransformer meetingTransformer;

	@RequestMapping(method = RequestMethod.GET, value = "/myMeetings")
	public ResponseEntity<List<MeetingDTO>> getMyMeetings(HttpServletRequest request) {
		JwtUser sessionUser = (JwtUser) request.getAttribute("jwtUser");
		try {
			if (UserRoles.toEnum(sessionUser.getRole()).getRightsLevel() < LEVEL_1_AUTH) {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
		} catch (InvalidRoleInfoException | IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		List<Meeting> test = new ArrayList<>();
		test = meetingService.getMyMeetings(userService.getById(sessionUser.getId()));
		List<MeetingDTO> test2 = new ArrayList<>();
		test.forEach((k) -> test2.add(meetingTransformer.toDTO(k)));
		System.out.println("a");
		return new ResponseEntity<>(test2, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{userId}/{announcementId}")
	public ResponseEntity<?> addMeeting(@PathVariable("userId") Long userId,
			@PathVariable("announcementId") Long announcementId, HttpServletRequest request) {
		JwtUser sessionUser = (JwtUser) request.getAttribute("jwtUser");
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
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		Meeting meeting = new Meeting();
		meeting.setUser1(userService.getById(sessionUser.getId()));
		meeting.setUser2(userService.getById(userId));
		meeting.setAnnouncement(announcementService.getById(announcementId));
		meeting.setAccepted((byte) 0);
		meetingService.save(meeting);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{meetingId}")
	public ResponseEntity<?> acceptMeeting(@PathVariable("meetingId") Long meetingId, HttpServletRequest request) {
		JwtUser sessionUser = (JwtUser) request.getAttribute("jwtUser");
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
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		if (sessionUser.getId() != meeting.getUser1().getId()) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		meetingService.acceptMeeting(meetingId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
