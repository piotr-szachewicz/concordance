package com.datasift.processors;

import com.datasift.model.Concordance;
import com.datasift.model.WordOccurance;

public abstract class AbstractConcordanceProcessor {

	protected Concordance concordance;
	protected int currentSentenceNumber;

	protected void reset() {
		currentSentenceNumber = 0;
		concordance = new Concordance();
	}

	public String process(String text) {
		reset();
		calculateConcordance(text);
		return concordance.toString();
	}

	protected abstract void calculateConcordance(String text);

	protected void addWordOccurance(String word) {
		if (word.length() > 0) {
			concordance.addWordOccurance(word.toLowerCase(), new WordOccurance(
					currentSentenceNumber));
		}
	}

}
