
import app.tiralab.taru.HuffmanTree;
import app.tiralab.taru.Input;
import app.tiralab.taru.Output;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OutputTest {

    @Mock
    HuffmanTree tree;
    
 
    Input input;    
    Output output;
    
    
    @Before
    public void setup() {
        this.input = new Input("BCAADDDCCACACAC");
        Map<Character, String> myMap = new HashMap<>();
        myMap.put('A', "11");
        myMap.put('B', "100");
        myMap.put('C', "0");
        myMap.put('D', "101");
        
        when(tree.getPrefixes()).thenReturn(myMap);

        output = new Output(tree.getPrefixes(), input, "output-file");
        
    }
    
    @Test
    public void findPrefixForCharacterTest() {       
        assertEquals("100", this.output.findPrefixForCharacter('B'));
        assertEquals("0", this.output.findPrefixForCharacter('C'));      
    }
    
    @Test
    public void createPrefixStringTest() {
        assertEquals("1000111110110110100110110110", 
                this.output.createPrefixString());
    }
}
