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

import com.datasift.utils.ResourceUtils;

@RunWith(Parameterized.class)
public abstract class AbstractConcordanceProcessorTest {

	protected String input;
	protected String expectedOutput;
	private AbstractConcordanceProcessor concordanceProcessor;

	public AbstractConcordanceProcessorTest(String fileName) throws IOException {
		input = ResourceUtils.readResource(ResourceUtils.INPUT_TEST_FILES_DIRECTORY + fileName);
		expectedOutput = ResourceUtils.readResource(ResourceUtils.EXPECTED_OUTPUT_TEST_FILES_DIRECTORY
				+ fileName);
		concordanceProcessor = createConcordanceProcessor();
	}

	protected abstract AbstractConcordanceProcessor createConcordanceProcessor();

	@Test
	public void testProcess() {
		// System.out.println("PROCESSING: " + input + "#");
		String actualOutput = processInput();
		//
		// System.out.print("EXPECTED=" + expectedOutput + "#");
		// System.out.print("ACTUAL=" + actualOutput + "#");

		assertEquals(expectedOutput, actualOutput);
	}

	protected String processInput() {
		return concordanceProcessor.process(input);
	}

	@Parameters(name = "{index}: {0})")
	public static Collection<String[]> getFileNamesParameters() {

		List<String[]> parameters = new ArrayList<String[]>();
		for (String fileName : ResourceUtils.getInputTestFileNames()) {
			parameters.add(new String[] { fileName });
		}
		return parameters;
	}

}
