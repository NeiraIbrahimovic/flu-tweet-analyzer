package portfolio.analytics;

/*
 * I attest that the code in this file is entirely my own except for the starter
 * code provided with the assignment and the following exceptions:
 * <
 * Enter all external resources and collaborations here. Note external code may
 * reduce your score but appropriate citation is required to avoid academic
 * integrity violations. Please see the Course Syllabus as well as the
 * university code of academic integrity:
 *  
 *  I attended TA Office Hours to help me work through bugs. 
 *  I used Regex 101 to help me build the regular expression.
 *  I used online Google search sources to help me use the JSON library to parse the JSON file. 
 *  
 * >
 * Signed,
 * Author: NEIRA IBRAHIMOVIC
 * Date: <2025-04-06>
 */

import portfolio.analytics.datamanagement.*;
import portfolio.analytics.processor.*;
import portfolio.analytics.ui.*;
import portfolio.analytics.logging.Logger;

/**
 * Main entry point for the flu tweet analyzer application.
 * Sets up readers, processor, UI, and launches the program.
 */

public class Main {
    public static void main(String[] args) {
    	//Check that all the correct arguments are given when launching the program
        if (args.length != 3) {
            System.err.println("Usage: java Main <tweets file> <states file> <log file>");
            return;
        }

        //Assign the arguments to the associated variables
        String tweetFile = args[0];
        String stateFile = args[1];
        String logFile = args[2];

        //Get the Logger instance using the Singleton getInstance method
        try {
            Logger.getInstance().setOutputFile(logFile); //Set the output file to the text file specified in the arguments

            //Create a TweetReader variable
            TweetReader tweetReader;
            
            //If the tweetFile is a text file, create an instance of the TextFileTweetReader class
            if (tweetFile.toLowerCase().endsWith(".txt")) {
                tweetReader = new TextFileTweetReader(tweetFile);
                
            //If the tweetFile is a JSON file, create an instance of the JsonFileTweetReader class
            } else if (tweetFile.toLowerCase().endsWith(".json")) {
                tweetReader = new JsonFileTweetReader(tweetFile);
                
            //If the tweet file is neither a text file or JSON, print an error
            } else {
                System.err.println("Unsupported tweet file type.");
                return;
            }

            //Create an instance of the StateFileReader
            StateFileReader stateReader = new StateFileReader(stateFile);
            
            //Create an instance of the TweetProcessor, passing in the correct tweetReader and stateReader
            TweetProcessor processor = new TweetProcessor(tweetReader, stateReader);
            
            //Create an instance of the UserInterface
            UserInterface ui = new UserInterface(processor);
            
            //Start the user interface
            ui.start();
            
        //If the code in the try block doesn't work, catch the exception and print the error
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

