package eu.europeana.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eu.europeana.dto.LeastCommonMultipleDTO;
import eu.europeana.exception.ApiError;
import eu.europeana.service.MathService;
import eu.europeana.service.UpperNumberService;
import eu.europeana.utils.EuropeanaUtils;

@RestController
@RequestMapping("/math")
public class MathController {

	private static Logger logger = LoggerFactory.getLogger(MathController.class);

	public final MathService mathService;

	public final UpperNumberService upperNumberService;


	public MathController(MathService mathService, UpperNumberService upperNumberService) {
		this.mathService = mathService;
		this.upperNumberService = upperNumberService;
	}

	private LeastCommonMultipleDTO createLCMOutput(Long time, Long lcm) {
		return new LeastCommonMultipleDTO(lcm, (System.currentTimeMillis() - time));
	}
	
	private ResponseEntity<LeastCommonMultipleDTO> getLCMOutput(Long time) throws ApiError {
		Long upperNumber = this.upperNumberService.getUpperNumber().get();
		return this.mathService.getLeastCommonMultiple(upperNumber).map(lcm -> {
			LeastCommonMultipleDTO leastCommonMultipleDTO =  this.createLCMOutput(time, lcm);
			return new ResponseEntity<LeastCommonMultipleDTO>(leastCommonMultipleDTO, HttpStatus.OK);
		}).orElseThrow(() -> new ApiError(HttpStatus.NOT_FOUND, EuropeanaUtils.UPPER_NUMBER_NOT_PRESENT_ERROR));
	}
	
	/**
	 * Get Least Common Multiple
	 * 
	 * @param upperNumber
	 * @return Least Common Multiple
	 * @throws ApiError
	 */
	@RequestMapping(value = "/getLeastCommonMultiple", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = MediaType.ALL_VALUE)
	public ResponseEntity<LeastCommonMultipleDTO> getLCM() throws ApiError {
		ResponseEntity<LeastCommonMultipleDTO> respose = null;
		try {
			long time = System.currentTimeMillis();
			if (this.upperNumberService.isUpperNumberPresent()) {
				respose =  this.getLCMOutput(time);
				this.upperNumberService.setUpperNumber(0L);
				return respose;
			}else {
				throw new ApiError(HttpStatus.NOT_FOUND, EuropeanaUtils.UPPER_NUMBER_NOT_PRESENT_ERROR);
			}
			
		} catch (Exception e) {
			logger.error(EuropeanaUtils.GETTIN_LEAST_COMMON_MULTIPLE_ERROR, e);
			throw e;
		}
	}

}
