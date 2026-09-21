package portfolio.analytics.studenttests;

import portfolio.analytics.datamanagement.TextFileTweetReader;
import portfolio.analytics.util.Tweet;
import org.junit.Test;
import java.io.*;
import java.util.List;
import static org.junit.Assert.*;

public class TextFileTweetReaderTest {
    @Test
    public void testReadValidTweet() throws Exception {
    	//Create a file for test tweets
        File testFile = new File("test_tweets.txt");
        
        //Print a test tweet to the file
        PrintWriter pw = new PrintWriter(testFile);
        pw.println("[39.95, -75.16]\tuser\ttime\tFeeling sick with the flu today.");
        pw.close();

        //Read the tweets in the file using the TextFileTweetReader
        TextFileTweetReader reader = new TextFileTweetReader("test_tweets.txt");
        List<Tweet> tweets = reader.getTweets();
        
        //Ensure there is only one tweet in the file
        assertEquals(1, tweets.size());
        
        //Ensure the correct tweet was recorded
        assertEquals("Feeling sick with the flu today.", tweets.get(0).getText());

        //Delete the file so it could be used again
        testFile.delete();
    }
}

