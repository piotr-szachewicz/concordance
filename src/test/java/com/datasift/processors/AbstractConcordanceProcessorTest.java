package com.datasift.processors;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.datasift.processors.AbstractConcordanceProcessor;
import com.datasift.processors.RegexConcordanceProcessorTest;
import com.datasift.utils.ResourceUtils;

@RunWith(Parameterized.class)
public abstract class AbstractConcordanceProcessorTest {

	protected String input;
	protected String expectedOutput;
	private AbstractConcordanceProcessor concordanceProcessor;

	protected static String[] TEST_FILE_NAMES = new String[] {
		"one_sentence", "two_sentences", "abbreviation", "quotation_marks",
		"word_with_a_hyphen", "long_text", "appostrophes", "empty",
		"one_word", "dot_only", "question_mark", "exclamation_mark", "multiple_dots",
		"multiple_punctuation_marks_with_spaces" };

	public AbstractConcordanceProcessorTest(String fileName)
			throws IOException {
		input = ResourceUtils.readResource("/input/" + fileName + ".txt");
		expectedOutput = ResourceUtils.readResource("/expected_output/" + fileName + ".txt");
		concordanceProcessor = createConcordanceProcessor();
	}

	protected abstract AbstractConcordanceProcessor createConcordanceProcessor();

	@Test
	public void testProcess() {
//		System.out.println("PROCESSING: " + input + "#");
		String actualOutput = processInput();
//
//		System.out.print("EXPECTED=" + expectedOutput + "#");
//		System.out.print("ACTUAL=" + actualOutput + "#");

		assertEquals(expectedOutput, actualOutput);
	}

	protected String processInput() {
		return concordanceProcessor.process(input);
	}

	@Parameters(name = "{index}: {0})")
	public static Collection<String[]> getFileNamesParameters() {
		List<String[]> parameters = new ArrayList<String[]>();
		for (String fileBeginning : TEST_FILE_NAMES) {
			parameters.add(new String[] { fileBeginning });
		}
		return parameters;
	}

}
