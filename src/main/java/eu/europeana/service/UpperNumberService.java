package eu.europeana.service;

import java.util.Optional;

public interface UpperNumberService {

	Optional<Long> getUpperNumber();
	void setUpperNumber(Long upperNumber);
	Optional<Boolean> isUpperNumberNotPresent();
	Boolean isUpperNumberPresent();
}
