package portfolio.analytics.logging;

import java.io.*;

/**
 * Singleton Logger for writing flu tweet logs to a file.
 * Only one logger instance should exist during runtime.
 */
public class Logger {
	//Create a single Logger instance
    private static Logger instance; 
    //Create a writer used to write log messages
    private PrintWriter writer;           

    //Private constructor to enforce singleton pattern
    private Logger() {}

    //Static method to get the global Logger instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    /**
     * Sets the output file for logging. Appends to the file if it exists.
     * If a previous file is open, it closes it first.
     */
    public void setOutputFile(String filename) throws IOException {
        //If PrintWriter is already in use, close it before opening a new one
    	if (writer != null) {
            writer.close();
        }
    	//Open the file in append mode
        FileWriter fw = new FileWriter(filename, true); 
        //Create a PrintWriter object with auto-flush enabled (write to the file every time instead of waiting for the buffer to fill up)
        writer = new PrintWriter(fw, true);             
    }

    /**
     * Logs a message to the configured log file.
     */
    public void log(String message) {
    	//If there is content in the writer instance, print the message to the log
        if (writer != null) {
            writer.println(message);
        }
    }
}
