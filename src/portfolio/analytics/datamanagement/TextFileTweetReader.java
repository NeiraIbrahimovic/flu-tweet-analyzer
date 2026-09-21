package portfolio.analytics.datamanagement;

import portfolio.analytics.util.Tweet;
import java.io.*;
import java.util.*;

/**
 * Reads tweets from a tab-separated text file.
 */
public class TextFileTweetReader implements TweetReader {
	//Create private variable for input file name
	private final String filename; 

	//Constructor to initialize the file name
    public TextFileTweetReader(String filename) {
        this.filename = filename;
    }

    /**
     * Parses the .txt file and returns a list of Tweet objects.
     */
    public List<Tweet> getTweets() {
    	//Use Array List to store tweets to preserve the insertion order of the tweets
        List<Tweet> tweets = new ArrayList<>(); 
        //Read the tweets
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            //While the next line in the Buffered Reader is not null, split the tweet information into Strings separated by tabs
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                //Ensure the line has all the required information (at least 4 columns)
                if (parts.length >= 4) {
                	//Get the latitude and longitude from the first column by 
                	//removing the brackets and splitting on the comma
                    String[] coords = parts[0].replace("[", "").replace("]", "").split(", ");
                    double lat = Double.parseDouble(coords[0]);
                    double lon = Double.parseDouble(coords[1]);
                    //Get the text by looking for the content in the third column
                    String text = parts[3];
                    //Create a new tweet with the correct latitude, longitude, and content
                    tweets.add(new Tweet(lat, lon, text));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading tab-separated tweet file", e);
        }
        return tweets;
    }
}

