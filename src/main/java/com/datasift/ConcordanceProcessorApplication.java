package com.datasift;

import java.io.IOException;

import org.apache.commons.io.IOUtils;

public class ConcordanceProcessorApplication {

	public static void main(String args[]) {

		try {

			String input = IOUtils.toString(System.in);

			ConcordanceProcessor concordanceProcessor = new ConcordanceProcessor();
			String output = concordanceProcessor.process(input);

			System.out.print(output);

		} catch (IOException e) {
			System.err.println("There was an error reading the stdin:");
			e.printStackTrace();
		}

	}

}
