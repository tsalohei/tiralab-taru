package app.tiralab.taru.performance;

import app.tiralab.taru.ui.Main;
import java.io.IOException;
import org.junit.Test;

public class DecompressTest {
    
    @Test(timeout = 5000)
    public void test() throws IOException {
        Main app = new Main();        
        app.decompress("src/test/resources/ulysses-decompress.huff");        
    }
}
