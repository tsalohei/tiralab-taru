
import app.tiralab.taru.Decompress;
import app.tiralab.taru.HuffmanTree;
import app.tiralab.taru.InputText;
import app.tiralab.taru.Output;
import java.util.Map;
import static org.junit.Assert.*;
import org.junit.Test;



public class DecompressTest {


    @Test 
    public void processTest() {
        InputText input = new InputText("abbacabba55");
        HuffmanTree tree = new HuffmanTree(input);
        tree.create();
        Map<Character, String> map = tree.getPrefixes();       
        Output output = new Output(tree, input, "dummy");
        String s = output.createPrefixString();
        
        Decompress dc = new Decompress(s, tree);
        String result = dc.process();
        
        assertEquals("abbacabba55", result);               
    }    
}
