package com.datasift.processors;

import java.io.IOException;

public class CharByCharConcordanceProcessorTest extends AbstractConcordanceProcessorTest {

	public CharByCharConcordanceProcessorTest(String fileName) throws IOException {
		super(fileName);
	}

	@Override
	protected AbstractConcordanceProcessor createConcordanceProcessor() {
		return new CharByCharConcordanceProcessor();
	}

}
