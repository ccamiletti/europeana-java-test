package eu.europeana.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.europeana.component.UpperNumberBean;

@Service
public class UpperNumberServiceImpl implements UpperNumberService {

	@Autowired
	private UpperNumberBean upperNumberBean;
	
	@Override
	public Optional<Long> getUpperNumber() {
		return this.upperNumberBean.getUpperNumber();
	}

	@Override
	public void setUpperNumber(Long upperNumber) {
		this.upperNumberBean.setUpperNumber(upperNumber);
	}

	@Override
	public Optional<Boolean> isUpperNumberNotPresent() {
		return this.getUpperNumber().filter(upperNumber -> upperNumber == 0).map(number -> {
			return Optional.of(Boolean.TRUE);
		}).orElseGet(() -> Optional.empty());
	}

	@Override
	public Boolean isUpperNumberPresent() {
		return this.getUpperNumber().filter(upperNumber -> upperNumber > 0).map(number -> {
			return Boolean.TRUE;
		}).orElseGet(() -> Boolean.FALSE);
	}

}
