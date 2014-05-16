package com.datasift.processors;

import java.io.IOException;

public class RegexConcordanceProcessorTest extends AbstractConcordanceProcessorTest {

	public RegexConcordanceProcessorTest(String fileName) throws IOException {
		super(fileName);
	}

	@Override
	protected AbstractConcordanceProcessor createConcordanceProcessor() {
		return new RegexConcordanceProcessor();
	}

}
