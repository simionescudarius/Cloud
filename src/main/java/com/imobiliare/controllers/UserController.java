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

import com.imobiliare.DTOs.UserDTO;
import com.imobiliare.enums.UserRoles;
import com.imobiliare.enums.UserUpdateEnum;
import com.imobiliare.models.User;
import com.imobiliare.security.JwtUser;
import com.imobiliare.services.UserService;
import com.imobiliare.transformers.UserTransformer;
import com.imobiliare.validators.UserValidator;

@CrossOrigin
@RestController
@RequestMapping(value = "/v1/users")
public class UserController extends Controller {
	@Autowired
	UserService userService;

	@Autowired
	UserTransformer userTransformer;

	@Autowired
	UserValidator userValidator;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> getAll(HttpServletRequest request) {
		JwtUser sessionUser = (JwtUser) request.getAttribute("jwtUser");
		try {
			if (UserRoles.toEnum(sessionUser.getRole()).getRightsLevel() < LEVEL_5_AUTH) {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
		} catch (InvalidRoleInfoException e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
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
	public ResponseEntity<UserDTO> getById(HttpServletRequest request) {
		JwtUser sessionUser = (JwtUser) request.getAttribute("jwtUser");
		try {
			if (UserRoles.toEnum(sessionUser.getRole()).getRightsLevel() < LEVEL_1_AUTH) {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
		} catch (InvalidRoleInfoException e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		User user = userService.getById(sessionUser.getId());
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		UserDTO userDTO = userTransformer.toDTO(user);
		return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/email={email}/")
	public ResponseEntity<UserDTO> getByEmail(@PathVariable("email") String email, HttpServletRequest request) {
		User user;
		JwtUser sessionUser = (JwtUser) request.getAttribute("jwtUser");
		try {
			if (UserRoles.toEnum(sessionUser.getRole()).getRightsLevel() < LEVEL_5_AUTH) {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
		} catch (InvalidRoleInfoException e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		try {
			validateNullData(email);
			user = userService.getByEmail(email);
		} catch (IllegalArgumentException exception) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		UserDTO userDTO = userTransformer.toDTO(user);
		return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/register")
	public ResponseEntity<UserDTO> save(@RequestBody UserDTO userDto, BindingResult validationResult) {
		userValidator.validate(userDto, validationResult);
		if (validationResult.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		userService.save(userTransformer.toModel(userDto));
		return new ResponseEntity<UserDTO>(HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/id={userId}/{option}")
	public ResponseEntity<UserDTO> update(@PathVariable("userId") Long id, @PathVariable("option") String option,
			@RequestBody String data, HttpServletRequest request) {
		JwtUser sessionUser = (JwtUser) request.getAttribute("jwtUser");
		try {
			validateNullData(id, option, data);
			if (UserRoles.toEnum(sessionUser.getRole()).getRightsLevel() < UserUpdateEnum.toEnum(option)
					.getReqAuthLevel()) {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
		} catch (IllegalArgumentException | InvalidRoleInfoException exception) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
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
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/id={userId}")
	public ResponseEntity<UserDTO> deleteById(@PathVariable("userId") Long id, HttpServletRequest request) {
		JwtUser sessionUser = (JwtUser) request.getAttribute("jwtUser");
		try {
			if (UserRoles.toEnum(sessionUser.getRole()).getRightsLevel() < LEVEL_5_AUTH) {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
		} catch (InvalidRoleInfoException e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		try {
			validateNullData(id);
		} catch (IllegalArgumentException exception) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}

		userService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
