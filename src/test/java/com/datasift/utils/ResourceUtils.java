package com.datasift.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.datasift.ConcordanceProcessor;

public class ResourceUtils {

	public static String readResource(String file) throws IOException {
		InputStream inputStream = ConcordanceProcessor.class
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
