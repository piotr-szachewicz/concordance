package com.datasift.model;

public class WordOccurance {

	private Integer sentenceNumber;

	/* If it is necessary, we can add other statistics about the 
	 * word occurance also such as pageNumber or lineNumber
	 */
	// private Integer pageNumber;
	// private Integer lineNumber;

	public WordOccurance(int sentenceNumber) {
		super();
		this.sentenceNumber = sentenceNumber;
	}

	public Integer getSentenceNumber() {
		return sentenceNumber;
	}
	
	@Override
	public String toString() {
		return sentenceNumber.toString();
	}
}
