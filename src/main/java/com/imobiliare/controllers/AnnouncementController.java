package com.imobiliare.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.imobiliare.DTOs.AnnouncementDTO;
import com.imobiliare.DTOs.RealEstateDTO;
import com.imobiliare.DTOs.ZoneDTO;
import com.imobiliare.models.Announcement;
import com.imobiliare.models.RealEstate;
import com.imobiliare.models.RealEstateType;
import com.imobiliare.models.Zone;
import com.imobiliare.services.AnnouncementService;
import com.imobiliare.services.RealEstateService;
import com.imobiliare.services.RealEstateTypeService;
import com.imobiliare.services.ZoneService;
import com.imobiliare.transformers.Transformer;

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
	Transformer<Announcement, AnnouncementDTO> announcementTransformer;
	@Autowired
	Transformer<RealEstate, RealEstateDTO> realEstateTransformer;
	@Autowired
	Transformer<Zone, ZoneDTO> zoneTransformer;

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

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<AnnouncementDTO> save(@RequestBody AnnouncementDTO announcementDTO) {
		try {
			validateNullData(announcementDTO);
			validateNullData(announcementDTO.getOwner(), announcementDTO.getRealEstate(),
					announcementDTO.getPostDate());
		} catch (IllegalArgumentException exception) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		Zone zone = zoneTransformer.toModel(announcementDTO.getRealEstate().getZone());
		RealEstateType type = new RealEstateType(announcementDTO.getRealEstate().getType().getName());
		zoneService.save(zone);
		realEstateTypeService.save(type);
		announcementDTO.getRealEstate().getZone().setId(zone.getId());
		announcementDTO.getRealEstate().getType().setId(type.getId());
		
		RealEstate realEstate = realEstateTransformer.toModel(announcementDTO.getRealEstate());
		realEstateService.save(realEstate);
		announcementDTO.getRealEstate().setId(realEstate.getId());
		
		Announcement announcement = announcementTransformer.toModel(announcementDTO);
		announcementService.save(announcement);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
