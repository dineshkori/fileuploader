package com.example.filedemo.model.response;

public class Annotated {
	private Phrases[] phrases;

	private String utterance;

	public Phrases[] getPhrases() {
		return phrases;
	}

	public void setPhrases(Phrases[] phrases) {
		this.phrases = phrases;
	}

	public String getUtterance() {
		return utterance;
	}

	public void setUtterance(String utterance) {
		this.utterance = utterance;
	}

	@Override
	public String toString() {
		return "ClassPojo [phrases = " + phrases + ", utterance = " + utterance + "]";
	}
}