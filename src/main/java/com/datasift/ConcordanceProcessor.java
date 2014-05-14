package com.datasift;

import com.datasift.model.Concordance;
import com.datasift.model.WordOccurance;

public class ConcordanceProcessor {

	private char[] text;
	private int currentPosition;
	private int currentSentenceNumber;
	private StringBuilder currentWord;
	private Concordance concordance;

	public String process(String text) {
		// StringTokenizer tokenizer = new StringTokenizer(input, " "); -
		// another possible solution would be to use StringTokenizer

		this.text = text.toCharArray();
		currentSentenceNumber = 0;
		resetCurrentWord();
		concordance = new Concordance();

		for (currentPosition = 0; currentPosition < this.text.length; currentPosition++) {
			processCurrentCharacter();
		}
		return concordance.toString();
	}

	protected void processCurrentCharacter() {
		char c = text[currentPosition];

		if (Character.isLetter(c)) {
			currentWord.append(c);
		} else {
			if (c == '.') {
				if (isSentenceEnd()) {
					addWordOccurance();
					currentSentenceNumber++;
				} else {
					currentWord.append(c);
				}
			} else if ((c == '-' || c == '\'') && currentPosition > 0
					&& Character.isLetter(text[currentPosition - 1])
					&& text.length > currentPosition + 1
					&& Character.isLetter(text[currentPosition + 1])) {
				currentWord.append(c);
			} else {
				addWordOccurance();
			}
		}
	}

	protected boolean isSentenceEnd() {
		if (text.length - currentPosition > 1) {
			for (int i = currentPosition + 1; i < text.length; i++) {
				char c = text[i];
				if (Character.isLetter(c)) {
					return Character.isUpperCase(c);
				}
			}
			return true;
		}
		return false;
	}

	protected void addWordOccurance() {
		if (currentWord.length() > 0) {
			concordance.addWordOccurance(currentWord.toString().toLowerCase(),
					new WordOccurance(currentSentenceNumber));
			resetCurrentWord();
		}
	}

	protected void resetCurrentWord() {
		currentWord = new StringBuilder();
	}

	public static void main(String[] args) {
		System.out.println("Test");
	}
}
