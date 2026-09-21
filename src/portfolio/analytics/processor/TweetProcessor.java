package portfolio.analytics.processor;

	import portfolio.analytics.datamanagement.*;
	import portfolio.analytics.util.*;
	import portfolio.analytics.logging.Logger;
	import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

	/**
	 * Processor class responsible for detecting flu tweets,
	 * mapping them to states, and logging them.
	 */
	public class TweetProcessor {
		
		//Create the variables that will be used by the processor
	    private final TweetReader tweetReader;
	    private final StateFileReader stateReader;
	    private final List<Tweet> tweets;
	    private final List<State> states;
	    
	    //Get an instance of the Logger using Singleton
	    private final Logger logger = Logger.getInstance();

	    //Constructor to initialize the variables
	    public TweetProcessor(TweetReader tweetReader, StateFileReader stateReader) {
	        this.tweetReader = tweetReader;
	        this.stateReader = stateReader;
	        //Get the tweets and states as lists using the methods provided in the corresponding classes
	        this.tweets = tweetReader.getTweets();
	        this.states = stateReader.getStates();
	    }

	    /**
	     * Returns a mapping of state names to the number of flu-related tweets.
	     */
	    public Map<String, Integer> getFluTweetCounts() {
	    	//Use a TreeMap so the output of state names can be put in alphabetical order
	        Map<String, Integer> counts = new TreeMap<>(); 
	        
	        //For every tweet, check if it is a flu tweet
	        for (Tweet tweet : tweets) {
	            if (isFluTweet(tweet.getText())) {
	            	//If it is a flu tweet, get the corresponding state
	                String state = findClosestState(tweet);
	                //Put the state in the TreeMap and increment the count (start at 0 if state doesn't already exist in the Map)
	                counts.put(state, counts.getOrDefault(state, 0) + 1);
	                
	              //Log flu tweet to file (includes state and text)
	                logger.log(state + "\t" + tweet.getText());
	            }
	        }
	        return counts;
	    }

	    //Checks if tweet contains the word "flu" (hashtag or not)
	    public static boolean isFluTweet(String text) {
	    	//Make the text lowercase 
	        String lower = text.toLowerCase();
	        //Use regex pattern to find the flu tweets
	        Pattern pattern = Pattern.compile("\\b#?flu([^a-zA-Z]|$)");
	        //Use the Matcher object to check whether the text matches the pattern
	        Matcher matcher = pattern.matcher(lower);
	        //Return true if match was found, false if not
	        return matcher.find();  
	    }

	    //Finds the nearest state to a given tweet using flat-Earth distance
	    private String findClosestState(Tweet tweet) {
	    	//Initialize the minimum distance to an arbitrarily high value
	        double minDist = Double.MAX_VALUE;
	        //Initialize the closest state to be unknown
	        String closestState = "Unknown";
	        //For every state, compute the distance between the tweet and the state using the helper method and store in variable
	        for (State state : states) {
	            double d = distance(
	                tweet.getLatitude(), tweet.getLongitude(),
	                state.getLatitude(), state.getLongitude()
	            );
	            //If the distance for that state is less than the current minimum distance,
	            //replace the minimum distance and get the state's name
	            if (d < minDist) {
	                minDist = d;
	                closestState = state.getName();
	            }
	        }
	        return closestState;
	    }

	    //Helper method to compute Euclidean distance
	    private double distance(double lat1, double lon1, double lat2, double lon2) {
	        return Math.sqrt(Math.pow(lat2 - lat1, 2) + Math.pow(lon2 - lon1, 2));
	    }

}
