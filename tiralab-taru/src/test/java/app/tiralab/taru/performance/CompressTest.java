package app.tiralan.taru.performance;

import app.tiralab.taru.ui.Main;
import java.io.IOException;
import org.junit.Test;

/**
 *
 * @author taru
 */
public class CompressTest {

    @Test(timeout = 5000)
    public void test() throws IOException {
        Main app = new Main();
        
        app.compress("src/test/resources/ulysses.txt");        
    }
}
