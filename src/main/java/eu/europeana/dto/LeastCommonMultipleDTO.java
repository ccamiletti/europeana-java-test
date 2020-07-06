package eu.europeana.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LeastCommonMultipleDTO {

	private Long leastCommonMultiple;
	private long executionTime;
	
	public LeastCommonMultipleDTO() {}
	
	public LeastCommonMultipleDTO(Long leastCommonMultiple, long executionTime) {
		super();
		this.leastCommonMultiple = leastCommonMultiple;
		this.executionTime = executionTime;
	}
	
	public Long getLeastCommonMultiple() {
		return leastCommonMultiple;
	}
	public void setLeastCommonMultiple(Long leastCommonMultiple) {
		this.leastCommonMultiple = leastCommonMultiple;
	}

	public long getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(long executionTime) {
		this.executionTime = executionTime;
	}
	
	
}
