package eu.europeana.service;

import java.util.Optional;

import eu.europeana.exception.ApiError;

public interface MathService {

	Optional<Long> getLeastCommonMultiple(Long upperNumber) throws ApiError;
	
	
}
