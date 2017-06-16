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

import com.imobiliare.DTOs.AnnouncementDTO;
import com.imobiliare.embeddables.FavouritesKey;
import com.imobiliare.enums.UserRoles;
import com.imobiliare.models.FavouriteAnnouncement;
import com.imobiliare.security.JwtUser;
import com.imobiliare.services.AnnouncementService;
import com.imobiliare.services.FavouriteAnnouncementService;
import com.imobiliare.services.UserService;
import com.imobiliare.transformers.AnnouncementTransformer;

@CrossOrigin
@RestController
@RequestMapping("v1/favourites")
public class FavouritesController extends Controller {
	@Autowired
	FavouriteAnnouncementService favouriteAnnouncementService;

	@Autowired
	AnnouncementService announcementService;

	@Autowired
	UserService userSevice;

	@Autowired
	AnnouncementTransformer announcementTransformer;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AnnouncementDTO>> getFavourites(HttpServletRequest request) {
		JwtUser sessionUser = (JwtUser) request.getAttribute("jwtUser");
		try {
			if (UserRoles.toEnum(sessionUser.getRole()).getRightsLevel() < LEVEL_1_AUTH) {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
		} catch (InvalidRoleInfoException e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}

		List<FavouriteAnnouncement> list = new ArrayList<>(
				this.favouriteAnnouncementService.getFavourites(sessionUser.getId()));
		List<AnnouncementDTO> dtos = new ArrayList<>();
		list.forEach((k) -> dtos.add(announcementTransformer.toDTO(k.getAnnouncement())));
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/exists/{announcementId}")
	public ResponseEntity<?> exists(HttpServletRequest request, @PathVariable("announcementId") Long announcementId) {
		JwtUser sessionUser = (JwtUser) request.getAttribute("jwtUser");
		try {
			if (UserRoles.toEnum(sessionUser.getRole()).getRightsLevel() < LEVEL_1_AUTH) {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
		} catch (InvalidRoleInfoException e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}

		List<FavouriteAnnouncement> list = new ArrayList<>(
				this.favouriteAnnouncementService.getFavourites(sessionUser.getId()));
		try {
			list.forEach((k) -> {
				if (k.getAnnouncement().getId() == announcementId) {
					throw new IllegalArgumentException();
				}
			});
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{announcementId}")
	public ResponseEntity<?> getFavourites(HttpServletRequest request,
			@PathVariable("announcementId") Long announcementId) {
		JwtUser sessionUser = (JwtUser) request.getAttribute("jwtUser");
		try {
			if (UserRoles.toEnum(sessionUser.getRole()).getRightsLevel() < LEVEL_1_AUTH) {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
			validateNullData(announcementId);
		} catch (InvalidRoleInfoException | IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		FavouriteAnnouncement x = new FavouriteAnnouncement();
		FavouritesKey k = new FavouritesKey();
		k.setAnnouncementId(announcementId);
		k.setUserId(sessionUser.getId());
		x.setKey(k);
		x.setUser(this.userSevice.getById(sessionUser.getId()));
		x.setAnnouncement(this.announcementService.getById(announcementId));
		this.favouriteAnnouncementService.save(x);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
