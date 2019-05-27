package cloud.imobiliare.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cloud.imobiliare.DTOs.TranslateDTO;
import cloud.imobiliare.DTOs.TranslateResultDTO;
import cloud.imobiliare.services.GoogleTranslateService;

@RestController
@RequestMapping(value = "/v1/translate")
public class TranslateController {

	@Autowired
	private GoogleTranslateService googleTranslateService;

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<TranslateResultDTO> post(@RequestBody TranslateDTO translateDto) {
		if(translateDto.getSourceLanguage().getDescription().equalsIgnoreCase(translateDto.getTargetLanguage().getDescription())) {
			return new ResponseEntity<TranslateResultDTO>(HttpStatus.BAD_REQUEST);
		}
		
		String translatedText = googleTranslateService.translateText(translateDto.getText(),
				translateDto.getSourceLanguage().name(), translateDto.getTargetLanguage().name());

		TranslateResultDTO result = new TranslateResultDTO();
		result.setTextResult(translatedText);

		return new ResponseEntity<TranslateResultDTO>(result, HttpStatus.OK);
	}
}
