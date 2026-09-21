package portfolio.analytics.studenttests;

import portfolio.analytics.Main;
import org.junit.Test;

public class FullDatasetJsonIntegrationTest {
    @Test
    public void testWithFullDataset() {
    	//Launch the program with data provided
        String[] args = {"flu_tweets.json", "states.csv", "log.txt"};
        Main.main(args);
        //This will print output and create a log file â€” check manually to ensure output and log file are shown as expected
    }
}
