package com.datasift.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Concordance {

	private HashMap<String, List<WordOccurance>> citationsMap = new HashMap<String, List<WordOccurance>>();

	public List<String> getWords() {
		List<String> words = new ArrayList<String>(citationsMap.keySet());
		Collections.sort(words);
		return words;
	}

	public List<WordOccurance> getWordOccurances(String word) {
		if (citationsMap.containsKey(word)) {
			return citationsMap.get(word);
		}
		return new ArrayList<WordOccurance>();
	}

	public void addWordOccurance(String word, WordOccurance occurance) {
		List<WordOccurance> wordOccurances = getWordOccurances(word);
		wordOccurances.add(occurance);
		citationsMap.put(word, wordOccurances);
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		
		for (String word: getWords()) {
			List<WordOccurance> wordOccurances = getWordOccurances(word);
			stringBuilder.append(word).append(" {").append(wordOccurances.size()).append(":");
			for (int i = 0; i < wordOccurances.size(); i++) {
				stringBuilder.append(wordOccurances.get(i));
				if (i < wordOccurances.size()-1)
					stringBuilder.append(',');
			}
			stringBuilder.append("}\n");
		}
		return stringBuilder.toString();
	}
}
