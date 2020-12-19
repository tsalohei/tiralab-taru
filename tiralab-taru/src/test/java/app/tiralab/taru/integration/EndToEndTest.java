package app.tiralab.taru.integration;

import app.tiralab.taru.ui.FileInput;
import app.tiralab.taru.ui.Main;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class EndToEndTest {
    
    @Test
    public void endToEndTest() throws IOException {
        Main app = new Main();
        
        app.compress("src/test/resources/book.txt");   
        app.decompress("src/test/resources/book.huff");
        
        FileInput fileInput = new FileInput();
        
        String original = fileInput.getFile("src/test/resources/book.txt");
        String compressed = fileInput.getFile("src/test/resources/book.dc");

        assertEquals(original, compressed);
        
    }
}
