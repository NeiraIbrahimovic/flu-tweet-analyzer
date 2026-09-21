package portfolio.analytics.datamanagement;

import portfolio.analytics.util.Tweet;
import java.util.List;

/**
 * Interface for reading tweet data from different file formats.
 */
public interface TweetReader {
	//Returns list of Tweet objects
    List<Tweet> getTweets();  
}
