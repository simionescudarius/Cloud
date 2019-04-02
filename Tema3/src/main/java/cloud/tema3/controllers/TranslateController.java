package cloud.tema3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cloud.tema3.DTOs.TranslateDTO;
import cloud.tema3.services.GoogleTranslateService;

@RestController
@RequestMapping(value = "/v1/translate")
public class TranslateController {

	@Autowired
	private GoogleTranslateService googleTranslateService;

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> post(@RequestBody TranslateDTO translateDto) {
		String translatedText = googleTranslateService.translateText(translateDto.getText(),
				translateDto.getSourceLanguage().name(), translateDto.getTargetLanguage().name());

		return new ResponseEntity<String>(translatedText, HttpStatus.OK);
	}
}
