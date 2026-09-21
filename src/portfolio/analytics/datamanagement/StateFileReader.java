package portfolio.analytics.datamanagement;

import portfolio.analytics.util.State;
import java.io.*;
import java.util.*;

/**
 * Reads the states file (CSV format) containing state centers.
 */
public class StateFileReader {
	//Create a private object for the input CSV file
    private final String filename; 

    //Constructor to initialize the file name
    public StateFileReader(String filename) {
        this.filename = filename;
    }

    /**
     * Parses the states CSV and returns a list of State objects.
     */
    public List<State> getStates() {
    	//Use Array List to store states to preserve the insertion order of the states
        List<State> states = new ArrayList<>();
        //Create a BufferedReader object
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            //While the next line isn't null, split the line by commas and store in array of Strings
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                //Get the name (first column)
                String name = parts[0];
                //Get the latitude (second column)
                double lat = Double.parseDouble(parts[1]);
                //Get the longitude (third column)
                double lon = Double.parseDouble(parts[2]);
                //Add the state with the corresponding name and coordinates
                states.add(new State(name, lat, lon));
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading states file", e);
        }
        return states;
    }
}