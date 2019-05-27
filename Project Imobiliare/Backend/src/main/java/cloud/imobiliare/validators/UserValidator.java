package cloud.imobiliare.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import cloud.imobiliare.DTOs.UserDTO;
import cloud.imobiliare.enums.CountryPhoneEnum;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (target == null) {
			errors.reject("User is null !");
		}
		UserDTO user = (UserDTO) target;

		if (user.getEmail() == null || user.getFirstName() == null || user.getLastName() == null
				|| user.getPhoneNumber() == null) {
			errors.reject("User data is null !");
		}

		validatePhoneNumber(user.getPhoneNumber(), errors);
		validateEmail(user.getEmail(), errors);
		validateUserInfo(errors, user.getFirstName(), user.getLastName());
	}

	public void validatePhoneNumber(String phoneNumber, Errors errors) {
		if (!phoneNumber.matches("[0-9]+") || phoneNumber.length() != CountryPhoneEnum.ROMANIA.getPhoneNumberLength()) {
			errors.reject("Invalid phone number !");
		}
	}

	public void validateEmail(String email, Errors errors) {
		if (!email.matches("[a-zA-Z0-9]+@[a-zA-Z]+[.][a-zA-Z]+")) {
			errors.reject("Invalid email !");
		}
	}

	public void validateUserInfo(Errors errors, String... data) {
		for (String string : data) {
			if (!string.matches("[a-zA-Z]+")) {
				errors.reject("Invalid characters in user information !");
			}
		}
	}
}
