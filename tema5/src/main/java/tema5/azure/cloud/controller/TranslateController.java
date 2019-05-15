package tema5.azure.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tema5.azure.cloud.DTOs.TranslateDTO;
import tema5.azure.cloud.services.AzureTranslateService;

@RestController
@RequestMapping(value = "/v1/translate")
public class TranslateController {

	@Autowired
	private AzureTranslateService azureTranslateService;

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> post(@RequestBody TranslateDTO translateDto) {
		String translatedText = azureTranslateService.translateText(translateDto.getText(),
				translateDto.getSourceLanguage().name(), translateDto.getTargetLanguage().name());

		if (translatedText == null) {
			return new ResponseEntity<String>(translatedText, HttpStatus.NOT_ACCEPTABLE);
		}

		return new ResponseEntity<String>(translatedText, HttpStatus.OK);
	}
}
