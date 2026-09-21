package portfolio.analytics.studenttests;

import portfolio.analytics.util.Tweet;
import org.junit.Test;
import static org.junit.Assert.*;

public class TweetTest {
    @Test
    public void testTweetConstructorAndGetters() {
    	//Create a new tweet
        Tweet tweet = new Tweet(39.95, -75.16, "Feeling sick with the flu today.");
        
        //Ensure the correct latitude, longitude, and text are returned
        assertEquals(39.95, tweet.getLatitude(), 0.001);
        assertEquals(-75.16, tweet.getLongitude(), 0.001);
        assertEquals("Feeling sick with the flu today.", tweet.getText());
    }
}
