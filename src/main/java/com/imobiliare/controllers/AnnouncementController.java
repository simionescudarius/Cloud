package com.imobiliare.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.management.relation.InvalidRoleInfoException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.imobiliare.DTOs.AnnouncementDTO;
import com.imobiliare.enums.UserRoles;
import com.imobiliare.models.Announcement;
import com.imobiliare.models.RealEstate;
import com.imobiliare.models.RealEstateType;
import com.imobiliare.models.Zone;
import com.imobiliare.security.JwtUser;
import com.imobiliare.services.AnnouncementService;
import com.imobiliare.services.RealEstateService;
import com.imobiliare.services.RealEstateTypeService;
import com.imobiliare.services.ZoneService;
import com.imobiliare.transformers.AnnouncementTransformer;
import com.imobiliare.transformers.RealEstateTransformer;
import com.imobiliare.transformers.ZoneTransformer;
import com.imobiliare.validators.AnnouncementValidator;

@CrossOrigin
@RestController
@RequestMapping("/v1/announcements")
public class AnnouncementController extends Controller {
	@Autowired
	AnnouncementService announcementService;
	@Autowired
	RealEstateService realEstateService;
	@Autowired
	RealEstateTypeService realEstateTypeService;
	@Autowired
	ZoneService zoneService;

	@Autowired
	AnnouncementTransformer announcementTransformer;
	@Autowired
	RealEstateTransformer realEstateTransformer;
	@Autowired
	ZoneTransformer zoneTransformer;

	@Autowired
	AnnouncementValidator announcementValidator;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AnnouncementDTO>> getAll() {
		List<Announcement> announcements = announcementService.getAll();
		if (announcements == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		List<AnnouncementDTO> announcementDTOs = new ArrayList<>();
		announcements.forEach((k) -> announcementDTOs.add(announcementTransformer.toDTO(k)));
		return new ResponseEntity<List<AnnouncementDTO>>(announcementDTOs, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/post")
	public ResponseEntity<AnnouncementDTO> save(@RequestBody AnnouncementDTO announcementDTO,
			BindingResult validationResult, HttpServletRequest request) {
		Zone zone;
		JwtUser sessionUser = (JwtUser) request.getAttribute("jwtUser");
		try {
			if (UserRoles.toEnum(sessionUser.getRole()).getRightsLevel() < 1) {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
		} catch (InvalidRoleInfoException e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		announcementValidator.validate(announcementDTO, validationResult);
		if (validationResult.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		try {
			zone = zoneTransformer.toModel(announcementDTO.getRealEstate().getZone());
		} catch (IllegalArgumentException exception) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		RealEstateType type = realEstateTypeService.getByName(announcementDTO.getRealEstate().getType().getName());
		if (type == null) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		zoneService.save(zone);
		announcementDTO.getRealEstate().getZone().setId(zone.getId());
		announcementDTO.getRealEstate().getType().setId(type.getId());

		RealEstate realEstate = realEstateTransformer.toModel(announcementDTO.getRealEstate());
		realEstateService.save(realEstate);
		announcementDTO.getRealEstate().setId(realEstate.getId());

		Announcement announcement = announcementTransformer.toModel(announcementDTO);
		announcementService.save(announcement);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/id={id}")
	public ResponseEntity<AnnouncementDTO> getById(@PathVariable("id") Long id) {
		try {
			validateNullData(id);
		} catch (IllegalArgumentException exception) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}

		Announcement announcement = announcementService.getById(id);
		if (announcement == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<AnnouncementDTO>(announcementTransformer.toDTO(announcement), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/type={type}")
	public ResponseEntity<List<AnnouncementDTO>> getByRealEstateType(@PathVariable("type") String type) {
		try {
			validateNullData(type);
		} catch (IllegalArgumentException exception) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}

		List<Announcement> announcements = announcementService.getByRealEstateType(type);
		if (announcements == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<AnnouncementDTO>>(announcementTransformer.toDTOList(announcements),
				HttpStatus.OK);
	}
}
