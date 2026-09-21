package portfolio.analytics.ui;

import portfolio.analytics.processor.TweetProcessor;
import java.util.Map;

/**
 * UI class to display the flu tweet counts to the user.
 */
public class UserInterface {
	//Create a private TweetProcessor instance
    private final TweetProcessor processor;

    //Constructor to initialize the processor
    public UserInterface(TweetProcessor processor) {
        this.processor = processor;
    }

    /**
     * Starts the app and prints out flu tweet counts by state.
     */
    public void start() {
    	//Use the method in the processor to get the flu tweet counts
        Map<String, Integer> results = processor.getFluTweetCounts();
        
        //For every state in the results, print the state and corresponding flu count
        for (String state : results.keySet()) {
            System.out.println(state + ": " + results.get(state));
        }
    }
}