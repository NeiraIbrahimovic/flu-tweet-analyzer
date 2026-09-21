package portfolio.analytics.studenttests;

import portfolio.analytics.util.State;
import org.junit.Test;
import static org.junit.Assert.*;

public class StateTest {
    @Test
    public void testStateConstructorAndGetters() {
    	//Create a new instance of the State class
        State state = new State("PA", 41.2033, -77.1945);
        
        //Ensure the name, latitude, and longitude are accurate
        assertEquals("PA", state.getName());
        assertEquals(41.2033, state.getLatitude(), 0.001);
        assertEquals(-77.1945, state.getLongitude(), 0.001);
    }
}