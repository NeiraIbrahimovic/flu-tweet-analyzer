package portfolio.analytics.util;

/**
 * Represents a U.S. state with its name and geographic center coordinates.
 */
 
public class State {
	
	//Create variables to be used for this class
    private final String name;
    private final double latitude;
    private final double longitude;

    //Constructor to initialize state name and coordinates
    public State(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    //Getter for state name
    public String getName() {
        return name;
    }

    //Getter for state's latitude
    public double getLatitude() {
        return latitude;
    }

    //Getter for state's longitude
    public double getLongitude() {
        return longitude;
    }
}
