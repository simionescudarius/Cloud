package cloud.imobiliare.controllers;

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

import cloud.imobiliare.DTOs.AnnouncementDTO;
import cloud.imobiliare.DTOs.UserDTO;
import cloud.imobiliare.DTOs.ZoneDTO;
import cloud.imobiliare.entities.RealEstateType;
import cloud.imobiliare.enums.UserRoles;
import cloud.imobiliare.security.JWebTokenUser;
import cloud.imobiliare.services.AnnouncementService;
import cloud.imobiliare.services.RealEstateService;
import cloud.imobiliare.services.RealEstateTypeService;
import cloud.imobiliare.services.ZoneService;
import cloud.imobiliare.validators.AnnouncementValidator;

@CrossOrigin
@RestController
@RequestMapping("/v1/announcements")
public class AnnouncementController extends Controller {

	@Autowired
	private AnnouncementService announcementService;

	@Autowired
	private RealEstateService realEstateService;

	@Autowired
	private RealEstateTypeService realEstateTypeService;

	@Autowired
	private ZoneService zoneService;

	@Autowired
	private AnnouncementValidator announcementValidator;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AnnouncementDTO>> getAll() {
		List<AnnouncementDTO> announcements = announcementService.getAll();
		if (announcements.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<AnnouncementDTO>>(announcements, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/myAnnouncements")
	public ResponseEntity<List<AnnouncementDTO>> getUserAnnouncements(HttpServletRequest request) {
		JWebTokenUser sessionUser = (JWebTokenUser) request.getAttribute("jwtUser");
		try {
			if (UserRoles.toEnum(sessionUser.getRole()).getRightsLevel() < 1) {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
		} catch (InvalidRoleInfoException e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}

		List<AnnouncementDTO> announcements = announcementService.getMyAnnouncements(sessionUser.getId());
		return new ResponseEntity<List<AnnouncementDTO>>(announcements, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/popular")
	public ResponseEntity<List<AnnouncementDTO>> getMostPopular() {
		List<AnnouncementDTO> announcements = announcementService.getMostPopular();
		if (announcements.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<AnnouncementDTO>>(announcements, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/post")
	public ResponseEntity<AnnouncementDTO> save(@RequestBody AnnouncementDTO announcementDTO,
			BindingResult validationResult, HttpServletRequest request) {
		ZoneDTO zone = announcementDTO.getRealEstate().getZone();
		JWebTokenUser sessionUser = (JWebTokenUser) request.getAttribute("jwtUser");

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

		RealEstateType type = realEstateTypeService.getByName(announcementDTO.getRealEstate().getType().getName());

		if (type == null) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}

		zoneService.save(zone);
		announcementDTO.getRealEstate().getZone().setId(zone.getId());
		announcementDTO.getRealEstate().getType().setId(type.getId());

		realEstateService.save(announcementDTO.getRealEstate());
		announcementDTO.getRealEstate().setId(announcementDTO.getRealEstate().getId());

		announcementDTO.setOwner(new UserDTO());
		announcementDTO.getOwner().setId(sessionUser.getId());
		announcementService.save(announcementDTO);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/id={id}")
	public ResponseEntity<AnnouncementDTO> getById(@PathVariable("id") Long id) {
		try {
			validateNullData(id);
		} catch (IllegalArgumentException exception) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}

		AnnouncementDTO announcement = announcementService.getById(id);
		if (announcement == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		announcementService.incViewNumber(id);
		announcement.setViewNumber(announcement.getViewNumber() + 1);
		return new ResponseEntity<AnnouncementDTO>(announcement, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/type={type}")
	public ResponseEntity<List<AnnouncementDTO>> getByRealEstateType(@PathVariable("type") String type) {
		try {
			validateNullData(type);
		} catch (IllegalArgumentException exception) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}

		List<AnnouncementDTO> announcements = announcementService.getByRealEstateType(type);
		if (announcements.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<AnnouncementDTO>>(announcements, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/type={type}/roomNumber={roomNumber}")
	public ResponseEntity<List<AnnouncementDTO>> getByRealEstateTypeAndRoomNumber(@PathVariable("type") String type,
			@PathVariable("roomNumber") Integer roomNumber) {
		try {
			validateNullData(type, roomNumber);
		} catch (IllegalArgumentException exception) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}

		List<AnnouncementDTO> announcements = announcementService.getByRealEstateRoomNumberAndType(roomNumber, type);
		if (announcements.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<AnnouncementDTO>>(announcements, HttpStatus.OK);
	}

	public AnnouncementService getAnnouncementService() {
		return announcementService;
	}

	public void setAnnouncementService(AnnouncementService announcementService) {
		this.announcementService = announcementService;
	}

	public RealEstateService getRealEstateService() {
		return realEstateService;
	}

	public void setRealEstateService(RealEstateService realEstateService) {
		this.realEstateService = realEstateService;
	}

	public RealEstateTypeService getRealEstateTypeService() {
		return realEstateTypeService;
	}

	public void setRealEstateTypeService(RealEstateTypeService realEstateTypeService) {
		this.realEstateTypeService = realEstateTypeService;
	}

	public ZoneService getZoneService() {
		return zoneService;
	}

	public void setZoneService(ZoneService zoneService) {
		this.zoneService = zoneService;
	}

	public AnnouncementValidator getAnnouncementValidator() {
		return announcementValidator;
	}

	public void setAnnouncementValidator(AnnouncementValidator announcementValidator) {
		this.announcementValidator = announcementValidator;
	}
}
