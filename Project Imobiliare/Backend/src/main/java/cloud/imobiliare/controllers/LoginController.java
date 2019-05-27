package cloud.imobiliare.controllers;

import org.apache.http.auth.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cloud.imobiliare.DTOs.AuthDTO;
import cloud.imobiliare.DTOs.UserDTO;
import cloud.imobiliare.security.JWebTokenUser;
import cloud.imobiliare.security.JwtService;
import cloud.imobiliare.services.UserService;
import cloud.imobiliare.transformers.UserTransformer;
import cloud.imobiliare.validators.UserValidator;

@CrossOrigin
@RestController
@RequestMapping("/v1/auth")
public class LoginController {
	@Autowired
	private UserService userService;

	@Autowired
	private UserTransformer userTransformer;

	@Autowired
	private UserValidator userValidator;

	@Autowired
	private JwtService jwtService;

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public ResponseEntity<?> auth(@RequestBody AuthDTO auth) {
		try {
			userService.validateCredentials(auth.getUsername(), auth.getPassword());
		} catch (IllegalArgumentException exception) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (InvalidCredentialsException exception) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		String email = auth.getUsername();
		JWebTokenUser jwtUser = new JWebTokenUser(userService.getId(email).toString(), email, userService.getRole(email));
		return new ResponseEntity<>(jwtService.getToken(jwtUser), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/verify")
	public ResponseEntity<?> verify() {
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/register")
	public ResponseEntity<?> save(@RequestBody UserDTO userDto, BindingResult validationResult) {
		userValidator.validate(userDto, validationResult);
		if (validationResult.hasErrors()) {
			return new ResponseEntity<>(validationResult.getAllErrors().get(0).getCode(), HttpStatus.BAD_REQUEST);
		}
		
		if (userService.getByEmail(userDto.getEmail()) != null) {
			return new ResponseEntity<>(HttpStatus.IM_USED);
		}
		userService.save(userTransformer.toModel(userDto));
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}