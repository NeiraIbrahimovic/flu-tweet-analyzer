package portfolio.analytics.studenttests;

import org.junit.Test;
import static org.junit.Assert.*;
import portfolio.analytics.processor.TweetProcessor;

public class FluDetectionTest {
	
	@Test
    public void testAssignmentExamples() {
    // Valid flu tweets (should return true)
    assertTrue(TweetProcessor.isFluTweet("flu"));
    assertTrue(TweetProcessor.isFluTweet("#flu"));
    assertTrue(TweetProcessor.isFluTweet("flu2020"));
    assertTrue(TweetProcessor.isFluTweet("flu4me&u"));
    assertTrue(TweetProcessor.isFluTweet("Feeling sick with the FLU!"));
    assertTrue(TweetProcessor.isFluTweet("I feel like I have the flu and I hate it"));
    assertTrue(TweetProcessor.isFluTweet("Flu symptoms are the worst"));
    assertTrue(TweetProcessor.isFluTweet("I definitely have the flu"));
    assertTrue(TweetProcessor.isFluTweet("I think I have the #flu I'm so sick"));
    assertTrue(TweetProcessor.isFluTweet("How do I know if I have the flu?"));
    assertTrue(TweetProcessor.isFluTweet("Five days I've had the flu! so sad"));
    

    // Invalid flu tweets (should return false)
    assertFalse(TweetProcessor.isFluTweet("influence"));
    assertFalse(TweetProcessor.isFluTweet("influenza"));
    assertFalse(TweetProcessor.isFluTweet("fluent"));
    assertFalse(TweetProcessor.isFluTweet("That bunny is so fluffy I want to squeeze it"));
    assertFalse(TweetProcessor.isFluTweet("Don't be influenced by fake news"));
    assertFalse(TweetProcessor.isFluTweet("ugh, I got #fluvid-19, shoulda taken the vax"));
    assertFalse(TweetProcessor.isFluTweet("so sick with the #flue gonna go home now"));

	}
}
