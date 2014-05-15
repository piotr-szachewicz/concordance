package com.datasift;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.datasift.utils.ResourceUtils;

@RunWith(Parameterized.class)
public class ConcordanceProcessorTest {

	private String input;
	private String expectedOutput;
	private ConcordanceProcessor concordanceProcessor;

	public ConcordanceProcessorTest(String fileNameBeginning)
			throws IOException {
		input = ResourceUtils.readResource(fileNameBeginning + "_input.txt");
		expectedOutput = ResourceUtils.readResource(fileNameBeginning
				+ "_expected_output.txt");
		concordanceProcessor = new ConcordanceProcessor();
	}

	@Test
	public void test() {
		String actualOutput = concordanceProcessor.process(input);
		//
		// System.out.println("INPUT: " + input + "#");
		// System.out.println("EXPECTED: " + expectedOutput + "#");
		// System.out.println("ACTUAL: " + actualOutput + "#");

		assertEquals(expectedOutput, actualOutput);
	}

	@Parameterized.Parameters
	public static Collection getFileNameBeginnings() {
		return Arrays
				.asList(new Object[][] { { "one_sentence" },
						{ "two_sentences" }, { "abbreviation" },
						{ "quotation_marks" }, { "word_with_a_hyphen" },
						{ "long_text" }, { "appostrophes" } });
	}

}