package portfolio.analytics.studenttests;

import portfolio.analytics.datamanagement.JsonFileTweetReader;
import portfolio.analytics.util.Tweet;
import org.junit.Test;
import java.io.*;
import java.util.List;
import static org.junit.Assert.*;

public class JsonFileTweetReaderTest {
    @Test
    public void testReadJsonTweet() throws Exception {
    	//Create a json String
        String json = "[{\"location\": [39.95, -75.16], \"text\": \"#flu season is here!\"}]";
        
        //Create a file
        String filename = "test_tweets.json";
        
        //Create a PrintWriter object and write the json to the file
        PrintWriter pw = new PrintWriter(filename);
        pw.write(json);
        pw.close();

        //Create a JsonFileTweetReader object to read the file
        JsonFileTweetReader reader = new JsonFileTweetReader(filename);
        
        //Get the tweets from the file as a list
        List<Tweet> tweets = reader.getTweets();
        
        //Ensure there is only one tweet in the list
        assertEquals(1, tweets.size());
        
        //Esnure the correct tweet was written into the file
        assertEquals("#flu season is here!", tweets.get(0).getText());

        //Delete the file so this test could be used again
        new File(filename).delete();
    }
}
