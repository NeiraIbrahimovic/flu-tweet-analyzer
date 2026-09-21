package portfolio.analytics.datamanagement;

import portfolio.analytics.util.Tweet;
import java.io.*;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Reads tweets from a JSON file using the json-simple library.
 */
public class JsonFileTweetReader implements TweetReader {
	//Create a private variable for the input JSON file name
    private final String filename; 

    //Constructor to initialize the file name
    public JsonFileTweetReader(String filename) {
        this.filename = filename;
    }

    /**
     * Parses the JSON file and returns a list of Tweet objects.
     */
    public List<Tweet> getTweets() {
    	//Use Array List to store tweets to preserve the insertion order of the tweets
        List<Tweet> tweets = new ArrayList<>();
        //Use JSON library to parse the JSON
        try (FileReader reader = new FileReader(filename)) {
            JSONParser parser = new JSONParser();
            JSONArray array = (JSONArray) parser.parse(reader);
            for (Object obj : array) {
                JSONObject tweetObj = (JSONObject) obj;
                JSONArray loc = (JSONArray) tweetObj.get("location");
                double lat = ((Number) loc.get(0)).doubleValue();
                double lon = ((Number) loc.get(1)).doubleValue();
                String text = (String) tweetObj.get("text");
                //Add the tweet with the corresponding cooridnates and text
                tweets.add(new Tweet(lat, lon, text));
            }
        } catch (IOException | ParseException e) {
            throw new RuntimeException("Error reading JSON tweet file", e);
        }
        return tweets;
    }
}