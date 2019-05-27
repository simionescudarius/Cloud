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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cloud.imobiliare.DTOs.UserDTO;
import cloud.imobiliare.entities.User;
import cloud.imobiliare.enums.UserRoles;
import cloud.imobiliare.enums.UserUpdateEnum;
import cloud.imobiliare.security.JWebTokenUser;
import cloud.imobiliare.services.UserService;
import cloud.imobiliare.transformers.UserTransformer;

@CrossOrigin
@RestController
@RequestMapping(value = "/v1/users")
public class UserController extends Controller {
	@Autowired
	private UserService userService;

	@Autowired
	private UserTransformer userTransformer;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> getAll(HttpServletRequest request) {
		JWebTokenUser sessionUser = (JWebTokenUser) request.getAttribute("jwtUser");
		try {
			if (sessionUser == null || UserRoles.toEnum(sessionUser.getRole()).getRightsLevel() < LEVEL_5_AUTH) {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
		} catch (InvalidRoleInfoException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		List<User> users = userService.getAll();
		if (users == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		List<UserDTO> usersDTOs = new ArrayList<>();
		users.forEach((k) -> usersDTOs.add(userTransformer.toDTO(k)));
		return new ResponseEntity<List<UserDTO>>(usersDTOs, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/myInfos")
	public ResponseEntity<UserDTO> getInfos(HttpServletRequest request) {
		JWebTokenUser sessionUser = (JWebTokenUser) request.getAttribute("jwtUser");
		try {
			if (UserRoles.toEnum(sessionUser.getRole()).getRightsLevel() < LEVEL_1_AUTH) {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
		} catch (InvalidRoleInfoException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		User user = userService.getById(sessionUser.getId());
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		UserDTO userDTO = userTransformer.toDTO(user);
		return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/id={userId}")
	public ResponseEntity<UserDTO> getUser(@PathVariable("userId") Long userId, HttpServletRequest request) {
		JWebTokenUser sessionUser = (JWebTokenUser) request.getAttribute("jwtUser");
		try {
			if (UserRoles.toEnum(sessionUser.getRole()).getRightsLevel() < LEVEL_1_AUTH) {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
		} catch (InvalidRoleInfoException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		User user = userService.getById(userId);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		UserDTO userDTO = userTransformer.toDTO(user);
		return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/email={email}/")
	public ResponseEntity<UserDTO> getByEmail(@PathVariable("email") String email, HttpServletRequest request) {
		User user;
		JWebTokenUser sessionUser = (JWebTokenUser) request.getAttribute("jwtUser");
		try {
			if (UserRoles.toEnum(sessionUser.getRole()).getRightsLevel() < LEVEL_5_AUTH) {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
		} catch (InvalidRoleInfoException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		try {
			validateNullData(email);
			user = userService.getByEmail(email);
		} catch (IllegalArgumentException exception) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		UserDTO userDTO = userTransformer.toDTO(user);
		return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/id={userId}/{option}")
	public ResponseEntity<UserDTO> update(@PathVariable("userId") Long id, @PathVariable("option") String option,
			@RequestBody String data, HttpServletRequest request) {
		JWebTokenUser sessionUser = (JWebTokenUser) request.getAttribute("jwtUser");
		try {
			validateNullData(id, option, data);
			if (UserRoles.toEnum(sessionUser.getRole()).getRightsLevel() < UserUpdateEnum.toEnum(option)
					.getReqAuthLevel()) {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
		} catch (IllegalArgumentException | InvalidRoleInfoException exception) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		User user = userService.getById(id);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		try {
			switch (UserUpdateEnum.toEnum(option)) {
			case FIRSTNAME:
				userService.updateFirstName(id, data);
				break;
			case EMAIL:
				userService.updateEmail(id, data);
				break;
			case LASTNAME:
				userService.updateLastName(id, data);
				break;
			case PHONENUMBER:
				userService.updatePhoneNumber(id, data);
				break;
			}
		} catch (IllegalArgumentException exception) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/id={userId}")
	public ResponseEntity<UserDTO> deleteById(@PathVariable("userId") Long id, HttpServletRequest request) {
		JWebTokenUser sessionUser = (JWebTokenUser) request.getAttribute("jwtUser");
		try {
			if (UserRoles.toEnum(sessionUser.getRole()).getRightsLevel() < LEVEL_5_AUTH) {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
		} catch (InvalidRoleInfoException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		try {
			validateNullData(id);
		} catch (IllegalArgumentException exception) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		userService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
