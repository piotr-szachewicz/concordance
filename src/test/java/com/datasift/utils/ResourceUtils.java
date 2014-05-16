package com.datasift.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ResourceUtils {

	public static String readResource(String file) throws IOException {
		InputStream inputStream = ClassLoader.class
				.getResourceAsStream("/com/datasift" + file);
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
