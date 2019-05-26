package cloud.imobiliare.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import cloud.imobiliare.DTOs.UserDTO;

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

		if (user.getEmail() == null || user.getFirstName() == null
				|| user.getLastName() == null || user.getPhoneNumber() == null) {
			errors.reject("User data is null !");
		}
	}

}
