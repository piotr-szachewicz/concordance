CONCORDANCE
===============================

This repository contains a program that is able to calculate a concordance for
a given input text. 

E.g. for the text:

	This is a repository. This repository contains a program.
	
it outputs:
	
	a {2:0,1}
	contains {1:1}
	is {1:0}
	program {1:1}
	repository {2:0,1}
	this {2:0,1}

In each `{x:a,b,c,..}`, `x` represents the number of times the given word occured in the sentence
and `a,b,c,...` are the sentence numbers in which the word occured. 	


1. HOW TO USE
------------------------

Download the source code:

    git clone https://github.com/piotr-szachewicz/concordance.git

Compile and package the code:

    cd concordance
	mvn package

This creates a concordance.jar file in the target directory.
To run the program:
	
	cd target/
	java -jar concordance.jar
	
Now you can input some text, press `Ctrl-D` to finish and the concordance for the text will be displayed.

Another use case is to display concordance for a given file:

    java -jar concordance.jar < file_name

2. IMPLEMENTATION DETAILS
-------------------------

The program contains two implementations that are able to calculate the concordance of a given text input:

* `CharByCharConcordanceProcessor` - analyzes the input text character after character in order to determine where the senetences and words end. This is the first implementation I developed. However, at some point it became hard to maintain and understand the code and add more functionality. That is why I implementated a second approach presented below. To use this implementation, add a `-c` command line argument when running the program.
* `RegexConcordanceProcessor` - analyzes the text using regular expressions. First it splits the text into sentences using a regex pattern. Then splits the sentence into words by whitespace characters. Each word is stripped from characters such as `"`,`'`, or `(` and stored in a concordance hash map. This is the default implementation that is run when the program is started.

3. WORK TO DO
-------------
There are several improvements that can be done to the program.

First of all the `CharByCharConcordanceProcessor` should be removed. I left it here so that it is possible to see two different approaches to solve the problem. It is possible to introduce some changes to the `RegexConcordanceProcessor` that would expand the set of inputs for which it is able to calculate the concordance correctly. However, as we use the same set of unit tests for both implementations, it is cumbersome to maintain the older one, for which the changes are more difficult.
