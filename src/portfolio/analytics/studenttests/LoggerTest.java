package portfolio.analytics.studenttests;

import portfolio.analytics.logging.Logger;
import org.junit.Test;
import java.io.*;
import static org.junit.Assert.*;

public class LoggerTest {
    @Test
    public void testLoggerSingletonAndLogging() throws IOException {
    	//Create a test log file
        // Give this test its own output so earlier logger tests cannot contaminate it.
        File isolatedLog = File.createTempFile("logger-regression-", ".log");
        isolatedLog.deleteOnExit();
        String logFile = isolatedLog.getAbsolutePath();
        
        //Get an instance of the Singleton logger
        Logger logger = Logger.getInstance();
        
        //Set the output file to the test_log.txt file
        logger.setOutputFile(logFile);
        
        //Print a test message in the log
        logger.log("test message");

        //Read the log file
        BufferedReader reader = new BufferedReader(new FileReader(logFile));
        String line = reader.readLine();
        reader.close();

        //Ensure the test message is there
        assertEquals("test message", line);

        //Delete the log file so it could be used again
        new File(logFile).delete();
    }
}
