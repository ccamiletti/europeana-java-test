package eu.europeana.controller;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eu.europeana.exception.ApiError;
import eu.europeana.service.UpperNumberService;
import eu.europeana.utils.EuropeanaUtils;

@RestController
@RequestMapping("/upperNumber")
public class UpperNumberController {

	private static Logger logger = LoggerFactory.getLogger(UpperNumberController.class);

	private final UpperNumberService upperNumberService;
	
	public UpperNumberController(UpperNumberService upperNumberService) {
		this.upperNumberService = upperNumberService;
	}
	
	
	private void validateUpperNumber(Long upperNumber) throws ApiError {
		if (upperNumber > 25) {
			throw new ApiError(EuropeanaUtils.MAX_UPPER_NUMBER_VALUE_ERROR);
		}else if (upperNumber < 1)
			throw new ApiError(EuropeanaUtils.MIN_UPPER_NUMBER_VALUE_ERROR);
	}
	
	@PostMapping("/set")
	public ResponseEntity<String> setUpperNumber(@RequestParam("upperNumber") Long upperNumber) throws ApiError {
		try {
			this.validateUpperNumber(upperNumber);
			return this.upperNumberService.isUpperNumberNotPresent().map(s -> {
				this.upperNumberService.setUpperNumber(upperNumber);
				return new ResponseEntity<String>(
						"the Upper number ".concat(String.valueOf(upperNumber)).concat(" was setted correctly"), HttpStatus.OK);
				
			}).orElseThrow(() -> new ApiError(HttpStatus.BAD_REQUEST, EuropeanaUtils.UPPER_NUMBER_PRESENT_ERROR));
		}catch(Exception e) {
			logger.error(EuropeanaUtils.SET_UPPER_NUMBER_ERROR, e.getMessage());
			throw new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
	
}
