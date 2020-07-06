package eu.europeana.component;

import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class UpperNumberBean {

	private Long upperNumber = 0L;

	public Optional<Long> getUpperNumber() {
		return Optional.ofNullable(upperNumber);
	}

	public void setUpperNumber(Long upperNumber) {
		this.upperNumber = upperNumber;
	}
	
	 
	
}
