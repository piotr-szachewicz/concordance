package com.datasift;

import java.io.IOException;

import org.apache.commons.io.IOUtils;

import com.datasift.processors.AbstractConcordanceProcessor;
import com.datasift.processors.RegexConcordanceProcessor;

public class ConcordanceProcessorApplication {

	public static void main(String args[]) {

		try {

			String input = IOUtils.toString(System.in);

			//AbstractConcordanceProcessor concordanceProcessor = new ConcordanceProcessor();
			AbstractConcordanceProcessor concordanceProcessor = new RegexConcordanceProcessor();
			String output = concordanceProcessor.process(input);

			System.out.print(output);

		} catch (IOException e) {
			System.err.println("There was an error reading the stdin:");
			e.printStackTrace();
		}

	}

}
