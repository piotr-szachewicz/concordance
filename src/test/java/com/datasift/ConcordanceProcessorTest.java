package com.datasift;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;
import static org.junit.Assert.*;

public class ConcordanceProcessorTest {

	private static int NUMBER_OF_TESTS = 6;

	@Test
	public void testProcess() throws IOException {
		for (int i = 0; i < NUMBER_OF_TESTS; i++) {
			test(i);
		}
	}

	protected void test(int number) throws IOException {
		// System.out.println("\nTEST " + number);
		// System.out.println("-----------");

		String input = readResource("test" + number + "_input.txt");
		String expectedOutput = readResource("test" + number
				+ "_expected_output.txt");

		test(input, expectedOutput);
	}

	protected void test(String input, String expectedOutput) {
		ConcordanceProcessor processor = new ConcordanceProcessor();
		String actualOutput = processor.process(input);
		//
		// System.out.println("INPUT: " + input + "#");
		// System.out.println("EXPECTED: " + expectedOutput + "#");
		// System.out.println("ACTUAL: " + actualOutput + "#");

		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	public void testApostrophes() {
		String input = "We'll go fishing. She said 'I love fishing'.";
		String expectedOutput = "fishing {2:0,1}\n" + "go {1:0}\n"
				+ "i {1:1}\n" + "love {1:1}\n" + "said {1:1}\n" + "she {1:1}\n"
				+ "we'll {1:0}\n";

		test(input, expectedOutput);
	}

	protected String readResource(String file) throws IOException {
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
