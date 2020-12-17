
import app.tiralab.taru.Decompress;
import app.tiralab.taru.HuffmanTree;
import app.tiralab.taru.InputText;
import app.tiralab.taru.MyMap;
import app.tiralab.taru.Output;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Test;



public class DecompressTest {

    /* String result on boolean. Keksi tähän jotain.
    @After
    public void cleanup() throws IOException {
        Files.deleteIfExists(Paths.get("dummy2.dc"));
    }
    
    @Test 
    public void processTest() throws IOException {
        InputText input = new InputText("abbacabba55");
        HuffmanTree tree = new HuffmanTree(input);
        tree.create();
        tree.getPrefixes();       
        Output output = new Output(tree, input, "dummy1");
        String s = output.createPrefixString();
        
        Decompress dc = new Decompress(s, tree, "dummy2.huff");
        String result = dc.process();
        
        assertEquals("abbacabba55", result);               
    }    
    */
}
