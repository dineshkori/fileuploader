package com.example.filedemo.model.response;

public class Icsr_inclusions
{
    private String confidence_score;

    private String inclusion_status;

    public String getInclusion_status() {
		return inclusion_status;
	}

	public void setInclusion_status(String inclusion_status) {
		this.inclusion_status = inclusion_status;
	}

	private String type;

	public String getConfidence_score() {
		return confidence_score;
	}

	public void setConfidence_score(String confidence_score) {
		this.confidence_score = confidence_score;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}