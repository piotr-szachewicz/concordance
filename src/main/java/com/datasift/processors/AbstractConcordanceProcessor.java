package com.datasift.processors;

import com.datasift.model.Concordance;
import com.datasift.model.WordOccurance;

public abstract class AbstractConcordanceProcessor {
	
	protected Concordance concordance;
	protected int currentSentenceNumber;

	public abstract String process(String text);
	
	protected void addWordOccurance(String word) {
		if (word.length() > 0) {
			concordance.addWordOccurance(word.toLowerCase(), new WordOccurance(currentSentenceNumber));
		}
	}

}
