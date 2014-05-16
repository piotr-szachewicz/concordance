package com.datasift;

import java.io.IOException;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.io.IOUtils;

import com.datasift.processors.AbstractConcordanceProcessor;
import com.datasift.processors.CharByCharConcordanceProcessor;
import com.datasift.processors.RegexConcordanceProcessor;

/**
 * This class contains the entry point of the program.
 *
 * @author Piotr Szachewicz
 *
 */
public class ConcordanceProcessorApplication {

	public static void main(String args[]) {

		try {

			String input = IOUtils.toString(System.in);

			AbstractConcordanceProcessor concordanceProcessor = getConcordanceProcessors(args);
			String output = concordanceProcessor.process(input);

			System.out.print(output);

		} catch (IOException e) {
			System.err.println("There was an error reading the stdin:");
			e.printStackTrace();
		}

	}

	protected static AbstractConcordanceProcessor getConcordanceProcessors(
			String[] args) {
		Options options = new Options();
		options.addOption(new Option(
				"c",
				"Use ConcordanceProcessor which parses the input string char by char (deprecated)."));
		CommandLineParser parser = new BasicParser();

		try {
			CommandLine cmd = parser.parse(options, args);
			if (cmd.hasOption("c")) {
				System.err.println("Using deprecated CharByCharConcordanceProcessor!");
				return new CharByCharConcordanceProcessor();
			}
		} catch (ParseException e) {
			System.err.println("Error parsing command line arguments - will use RegexConcordanceProcessor");
		}
		return new RegexConcordanceProcessor();
	}

}
