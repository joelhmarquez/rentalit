package com.rentalit.resources;

public enum Condition {
	NEW("NEW"),
	GOOD("GOOD"),
	USED("USED"),
	BAD("BAD"),
	ANY("ANY");

	private final String text;


    Condition(final String text) {
		this.text = text;
	}


	@Override
	public String toString() {
		return text;

	}
}
