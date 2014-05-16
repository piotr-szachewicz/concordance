package com.datasift.processors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.datasift.model.Concordance;

public class RegexConcordanceProcessor extends AbstractConcordanceProcessor {

	protected static String SENTENCE_REGEX = "([A-Za-z].*?)[.?!]+(?! ?[a-z:;,-])";

	public String process(String text) {
		currentSentenceNumber = 0;
		concordance = new Concordance();
		text = addFullStopIfNecessary(text);

		Pattern pattern = Pattern.compile(SENTENCE_REGEX, Pattern.DOTALL);
		Matcher matcher = pattern.matcher(text);

		while (matcher.find()) {
			String sentence = matcher.group(1);
			processSentence(sentence);
			currentSentenceNumber++;
		}

		return concordance.toString();
	}

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