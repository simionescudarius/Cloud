package com.imobiliare.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.imobiliare.DTOs.AnnouncementDTO;

@Component
public class AnnouncementValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return AnnouncementDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (target == null) {
			errors.reject("Announcement is null !");
		}

		AnnouncementDTO announcement = (AnnouncementDTO) target;

		if (announcement.getPostDate() == null) {
			errors.rejectValue("PostDate", "Post date is null !");
		}
		if (announcement.getRealEstate() == null || announcement.getRealEstate().getType() == null
				|| announcement.getRealEstate().getType().getName() == null
				|| announcement.getRealEstate().getZone() == null) {
			errors.rejectValue("RealEstate", "Real Estate data is null !");
		}
	}

}
