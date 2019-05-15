package com.example.filedemo.model.response;

import java.util.ArrayList;

public class JammerResponse
{
    private Lr_classifier_2 lr_classifier_2;

    private Icsr_exclusions[] icsr_exclusions;

    private String user_id;

    private String requestId;

    private ArrayList<Classifier> classifier;

    private String id;

    private String text;

    private Annotated[] annotated;

    private Icsr_inclusions[] icsr_inclusions;

	public Lr_classifier_2 getLr_classifier_2() {
		return lr_classifier_2;
	}

	public void setLr_classifier_2(Lr_classifier_2 lr_classifier_2) {
		this.lr_classifier_2 = lr_classifier_2;
	}

	public Icsr_exclusions[] getIcsr_exclusions() {
		return icsr_exclusions;
	}

	public void setIcsr_exclusions(Icsr_exclusions[] icsr_exclusions) {
		this.icsr_exclusions = icsr_exclusions;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public ArrayList<Classifier> getClassifier() {
		return classifier;
	}

	public void setClassifier(ArrayList<Classifier> classifier) {
		this.classifier = classifier;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Annotated[] getAnnotated() {
		return annotated;
	}

	public void setAnnotated(Annotated[] annotated) {
		this.annotated = annotated;
	}

	public Icsr_inclusions[] getIcsr_inclusions() {
		return icsr_inclusions;
	}

	public void setIcsr_inclusions(Icsr_inclusions[] icsr_inclusions) {
		this.icsr_inclusions = icsr_inclusions;
	}

  
}