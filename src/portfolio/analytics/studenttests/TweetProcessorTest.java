package portfolio.analytics.studenttests;

import portfolio.analytics.datamanagement.*;
import portfolio.analytics.logging.Logger;
import portfolio.analytics.processor.TweetProcessor;
import portfolio.analytics.util.*;
import org.junit.Test;
import java.io.*;
import java.util.*;
import static org.junit.Assert.*;

public class TweetProcessorTest {
    @Test
    public void testFluTweetDetectionAndStateMatching() throws Exception {
    	//Create test files for tweets, states and logging
        String tweetsFile = "test_tweets.txt";
        String statesFile = "test_states.csv";
        String logFile = "test_log.txt";

        //Write an example tweet to the tweets file
        PrintWriter tweetWriter = new PrintWriter(tweetsFile);
        tweetWriter.println("[39.95, -75.16]\tuser\ttime\tFlu cases rising");
        tweetWriter.close();

        //Write an example state to the states file
        PrintWriter stateWriter = new PrintWriter(statesFile);
        stateWriter.println("PA,39.95,-75.16");
        stateWriter.close();

        //Get an instance of the Logger and set the output file to write to
        Logger.getInstance().setOutputFile(logFile);
        
        //Pass the tweets and states files to the correct Readers and pass the readers to the processor
        TweetReader reader = new TextFileTweetReader(tweetsFile);
        StateFileReader stateReader = new StateFileReader(statesFile);
        TweetProcessor processor = new TweetProcessor(reader, stateReader);

        //Ensure the processor counted one flu tweet
        Map<String, Integer> result = processor.getFluTweetCounts();
        assertEquals(1, result.get("PA").intValue());

        //Delete all the files so they can be used again
        new File(tweetsFile).delete();
        new File(statesFile).delete();
        new File(logFile).delete();
    }
}
