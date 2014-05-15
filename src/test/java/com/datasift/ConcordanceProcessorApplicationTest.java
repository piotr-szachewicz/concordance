package com.datasift;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class ConcordanceProcessorApplicationTest extends
		ConcordanceProcessorTest {

	private PrintStream originalOutputStream;

	public ConcordanceProcessorApplicationTest(String fileNameBeginning)
			throws IOException {
		super(fileNameBeginning);
	}

	protected String processInput() {
		setupInputStream();
		OutputStream outputStream = setupOutputStream();

		ConcordanceProcessorApplication.main(new String[0]);
		resetOutputStreamToDefaults();

		return outputStream.toString();
	}

	protected void setupInputStream() {
		InputStream inputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(inputStream);
	}

	protected OutputStream setupOutputStream() {
		OutputStream outputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outputStream, false);
		originalOutputStream = System.out;
		System.setOut(printStream);

		return outputStream;
	}

	protected void resetOutputStreamToDefaults() {
		System.setOut(originalOutputStream);
	}

}
