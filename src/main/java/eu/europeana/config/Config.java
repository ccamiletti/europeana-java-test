package eu.europeana.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import eu.europeana.component.UpperNumberBean;

@Configuration
public class Config {

	@Bean
	public UpperNumberBean getUpperNumberBean() {
		return new UpperNumberBean(); 
	}
	
}
