package com.datasift.processors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
 * An implementation of concordance processor that analyzes the
 * input text using regular expressions.
 *
 * @author Piotr Szachewicz
 */
public class RegexConcordanceProcessor extends AbstractConcordanceProcessor {

	protected static String SENTENCE_REGEX = "([A-Za-z].*?)[.?!]+(?! ?[a-z:;,-])";

	protected void calculateConcordance(String text) {
		text = addFullStopIfNecessary(text);

		Pattern pattern = Pattern.compile(SENTENCE_REGEX, Pattern.DOTALL);
		Matcher matcher = pattern.matcher(text);

		while (matcher.find()) {
			String sentence = matcher.group(1);
			processSentence(sentence);
			currentSentenceNumber++;
		}
	}

	/**
	 * In case if the input text does not end with
	 * a fullstop, exclamation mark or question mark,
	 * this method adds a fullstop at the end of the text.
	 *
	 * @param text input text
	 * @return the input text that ends with some sentence-finishing
	 * symbol (fullstop, exclamation mark or question mark).
	 */
	protected String addFullStopIfNecessary(String text) {
		text = StringUtils.strip(text, "\\s");
		if (!StringUtils.endsWithAny(text, new String[] { ".", "!", "?" })) {
			text += '.'; // in case there is no dot at the end, we add it there
		}
		return text;
	}

	protected void processSentence(String sentence) {
		String[] words = sentence.split("\\s+");

		for (String word : words) {
			String strippedWord = StringUtils.strip(word, ",\"\'-:;()");
			addWordOccurance(strippedWord);
		}
	}

}
