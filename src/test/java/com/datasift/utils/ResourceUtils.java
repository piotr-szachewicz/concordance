package com.datasift.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.datasift.ConcordanceProcessorTest;
import com.datasift.processors.ConcordanceProcessor;

public class ResourceUtils {

	public static String readResource(String file) throws IOException {
		InputStream inputStream = ConcordanceProcessorTest.class
				.getResourceAsStream(file);
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				inputStream));

		StringBuilder stringBuilder = new StringBuilder();
		String line;
		do {
			line = reader.readLine();
			if (line != null) {
				stringBuilder.append(line);
				stringBuilder.append("\n");
			}
		} while (line != null);

		return stringBuilder.toString();
	}
}
