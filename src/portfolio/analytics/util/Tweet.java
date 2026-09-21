package portfolio.analytics.util;

/**
 * Represents a single tweet.
 * Immutable data class for storing tweet info: location and content.
 */

public class Tweet {
	
	//Create variables to be used for this class
    private final double latitude;
    private final double longitude;
    private final String text;

    //Constructor to initialize tweet data
    public Tweet(double latitude, double longitude, String text) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.text = text;
    }

    //Getter for latitude
    public double getLatitude() {
        return latitude;
    }

    //Getter for longitude
    public double getLongitude() {
        return longitude;
    }

    //Getter for tweet text
    public String getText() {
        return text;
    }
}
