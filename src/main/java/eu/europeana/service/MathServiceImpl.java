package eu.europeana.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import eu.europeana.exception.ApiError;

@Service
public class MathServiceImpl implements MathService {
	
	@Override
	public Optional<Long> getLeastCommonMultiple(Long upperNumber) throws ApiError {
		Long i = upperNumber - 1;
		for (; i > 1; i--) {
			upperNumber = this.getLcm(upperNumber,i);
		}
		return Optional.ofNullable(upperNumber);
	}

	private Long getLcm(Long upperNumber, Long number) {
		Long lcm = upperNumber;
	    while (lcm % number != 0) {
	        lcm += upperNumber;
	    }
	    return lcm;
	}	
	

}
