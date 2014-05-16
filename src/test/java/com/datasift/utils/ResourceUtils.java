package com.datasift.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang.SystemUtils;

public class ResourceUtils {

	public static String INPUT_TEST_FILES_DIRECTORY = "/com/datasift/input/";
	public static String EXPECTED_OUTPUT_TEST_FILES_DIRECTORY = "/com/datasift/expected_output/";

	public static List<String> getInputTestFileNames() {
		List<String> fileNames = new ArrayList<String>();

		String inputFilesPath = adaptPathToOS(INPUT_TEST_FILES_DIRECTORY);
		Pattern pattern = Pattern.compile(".*" + inputFilesPath + ".*.txt");
		final Collection<String> filePaths = ResourceList.getResources(pattern);

		for (String filePath : filePaths) {
			String fileName = (new File(filePath)).getName();
			fileNames.add(fileName);
		}

		return fileNames;
	}

	protected static String adaptPathToOS(String path) {
		if (SystemUtils.IS_OS_WINDOWS) {
			return path.replaceAll("/", "\\\\\\\\");
		}
		return path;
	}

	public static String readResource(String file) throws IOException {
		InputStream inputStream = ClassLoader.class.getResourceAsStream(file);
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
