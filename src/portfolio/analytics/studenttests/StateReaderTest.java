package portfolio.analytics.studenttests;

import portfolio.analytics.datamanagement.StateFileReader;
import portfolio.analytics.util.State;
import org.junit.Test;
import java.io.*;
import java.util.List;
import static org.junit.Assert.*;

public class StateReaderTest {
    @Test
    public void testStateParsing() throws Exception {
    	//Create a test states file
        String filename = "test_states.csv";
        
        //Print some test coordinates to the state file
        PrintWriter pw = new PrintWriter(filename);
        pw.println("PA,41.2033,-77.1945");
        pw.close();

        //Read the content of the state file using the StateFileReader
        StateFileReader reader = new StateFileReader(filename);
        List<State> states = reader.getStates();

        //Ensure there is only one state in the file
        assertEquals(1, states.size());
        
        //Ensure the correct state was added
        assertEquals("PA", states.get(0).getName());

        //Delete the file so it could be used again
        new File(filename).delete();
    }
}

