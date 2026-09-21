package portfolio.analytics.studenttests;

import portfolio.analytics.datamanagement.*;
import portfolio.analytics.processor.*;
import portfolio.analytics.ui.*;
import portfolio.analytics.logging.Logger;
import org.junit.Test;
import java.io.*;

public class UserInterfaceTest {
    @Test
    public void testEndToEndApp() throws Exception {
    	//Create test files for the tweets, state, and logs
        String tweetFile = "test_cli_tweets.txt";
        String stateFile = "test_cli_states.csv";
        String logFile = "test_cli_log.txt";

        //Write an example tweet to the tweet file
        PrintWriter tweetWriter = new PrintWriter(tweetFile);
        tweetWriter.println("[40.0, -75.0]\tuser\ttime\tI got the flu today");
        tweetWriter.close();

        //Write an example state to the state file
        PrintWriter stateWriter = new PrintWriter(stateFile);
        stateWriter.println("PA,40.0,-75.0");
        stateWriter.close();

        //Set the output file for the logs to be written to
        Logger.getInstance().setOutputFile(logFile);
        
        //Pass the files to the tweet and state readers
        TweetReader tweetReader = new TextFileTweetReader(tweetFile);
        StateFileReader stateReader = new StateFileReader(stateFile);
        
        //Process the information
        TweetProcessor processor = new TweetProcessor(tweetReader, stateReader);
        
        //Run the user interface
        UserInterface ui = new UserInterface(processor);
        ui.start(); //This just ensures it runs, the visual output isn't captured

        //Deelte the files so they can be used again
        new File(tweetFile).delete();
        new File(stateFile).delete();
        new File(logFile).delete();
    }
}

