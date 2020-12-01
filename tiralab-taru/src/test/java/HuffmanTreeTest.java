
import app.tiralab.taru.HuffmanNode;
import app.tiralab.taru.HuffmanTree;
import app.tiralab.taru.Input;
import app.tiralab.taru.MyMinHeap;
import java.util.Map;
//import java.util.PriorityQueue;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class HuffmanTreeTest {

    Input input;
    HuffmanTree tree;
    char[] charArray;
    int[] intArray;
    
    
    @Before
    public void setup() {
        this.input = new Input("BCAADDDCCACACAC");
        input.calculate();
        this.tree = new HuffmanTree(input);
        this.charArray = new char[]{'B','D', 'A', 'C'};
        this.intArray = new int[]{1, 3, 5, 6};
    }
    
    @Test 
    public void buildMinHeapTest() {
        MyMinHeap q = tree.buildMinHeap(charArray, intArray);
  
        HuffmanNode hf = q.checkMin();

        assertEquals(hf.getChar(), 'B');
        assertEquals(hf.getFreq(), 1);
        assertEquals(hf.getLeft(), null);
        assertEquals(hf.getRight(), null);
    }
    /*
    public void buildMinHeapTest() {
        PriorityQueue<HuffmanNode> q = tree.buildMinHeap(charArray, intArray);
  
        HuffmanNode hf = q.peek();

        assertEquals(hf.getChar(), 'B');
        assertEquals(hf.getFreq(), 1);
        assertEquals(hf.getLeft(), null);
        assertEquals(hf.getRight(), null);
    }
    */

   
    @Test 
    public void createInternalNodesTest() {
        MyMinHeap q = tree.buildMinHeap(charArray, intArray);

        HuffmanNode rootNode = tree.createInternalNodes(q);

        assertEquals(rootNode.getFreq(), 15);
    }
    /*
    public void createInternalNodesTest() {
        PriorityQueue<HuffmanNode> q = tree.buildMinHeap(charArray, intArray);

        HuffmanNode rootNode = tree.createInternalNodes(q);

        assertEquals(rootNode.getFreq(), 15);
    } 
    */
  
    @Test
    public void buildPrefixesTest1() {
        MyMinHeap q = tree.buildMinHeap(this.charArray, this.intArray);
        HuffmanNode rootNode = tree.createInternalNodes(q);
     
        tree.buildPrefixes(rootNode, "");
        
        Map<Character, String> map = tree.getPrefixes();
        String value = null;
        for (Map.Entry<Character, String> entry : map.entrySet()) {
            
            if (entry.getKey() == 'A') {
                value = entry.getValue();
                assertEquals("11", value);
            } else if (entry.getKey() == 'B') {
                value = entry.getValue();
                assertEquals("100", value);
            } else if (entry.getKey() == 'C') {
                value = entry.getValue();
                assertEquals("0", value);
            } else if (entry.getKey() == 'D') {
                value = entry.getValue();
                assertEquals("101", value);
            }
        }      
        
    }
    /*
    public void buildPrefixesTest1() {
        PriorityQueue<HuffmanNode> q = tree.buildMinHeap(this.charArray, this.intArray);
        HuffmanNode rootNode = tree.createInternalNodes(q);
     
        tree.buildPrefixes(rootNode, "");
        
        Map<Character, String> map = tree.getPrefixes();
        String value = null;
        for (Map.Entry<Character, String> entry : map.entrySet()) {
            
            if (entry.getKey() == 'A') {
                value = entry.getValue();
                assertEquals("11", value);
            } else if (entry.getKey() == 'B') {
                value = entry.getValue();
                assertEquals("100", value);
            } else if (entry.getKey() == 'C') {
                value = entry.getValue();
                assertEquals("0", value);
            } else if (entry.getKey() == 'D') {
                value = entry.getValue();
                assertEquals("101", value);
            }
        }      
        
    }
    */
    @Test
    public void buildPrefixesTest2() {
       
        Input input2 = new Input("A_DEAD_DAD_CEDED_A_BAD_BABE_A_BEADED_ABACA_BED");
        input2.calculate();
        HuffmanTree tree2 = new HuffmanTree(input2);
        char[] charArray2 = new char[]{'C', 'B', 'E', '_', 'D', 'A'};
        int []intArray2 = new int[]{2, 6, 7, 10, 10, 11};
        
        MyMinHeap q = tree2.buildMinHeap(charArray2, intArray2);
        HuffmanNode rootNode = tree2.createInternalNodes(q);
        
        tree2.buildPrefixes(rootNode, "");
        
        Map<Character, String> map = tree2.getPrefixes();
        String value = null;
        for (Map.Entry<Character, String> entry : map.entrySet()) {
            
            if (entry.getKey() == 'A') {
                value = entry.getValue();
                assertEquals("10", value);
            } else if (entry.getKey() == 'B') {
                value = entry.getValue();
                assertEquals("1111", value);
            } else if (entry.getKey() == 'C') {
                value = entry.getValue();
                assertEquals("1110", value);
            } else if (entry.getKey() == 'E') {
                value = entry.getValue();
                assertEquals("110", value);
            }  
        }       
    }
    /*
    public void buildPrefixesTest2() {
       
        Input input2 = new Input("A_DEAD_DAD_CEDED_A_BAD_BABE_A_BEADED_ABACA_BED");
        input2.calculate();
        HuffmanTree tree2 = new HuffmanTree(input2);
        char[] charArray2 = new char[]{'C', 'B', 'E', '_', 'D', 'A'};
        int []intArray2 = new int[]{2, 6, 7, 10, 10, 11};
        
        PriorityQueue<HuffmanNode> q = tree2.buildMinHeap(charArray2, intArray2);
        HuffmanNode rootNode = tree2.createInternalNodes(q);
        
        tree2.buildPrefixes(rootNode, "");
        
        Map<Character, String> map = tree2.getPrefixes();
        String value = null;
        for (Map.Entry<Character, String> entry : map.entrySet()) {
            
            if (entry.getKey() == 'A') {
                value = entry.getValue();
                assertEquals("10", value);
            } else if (entry.getKey() == 'B') {
                value = entry.getValue();
                assertEquals("1111", value);
            } else if (entry.getKey() == 'C') {
                value = entry.getValue();
                assertEquals("1110", value);
            } else if (entry.getKey() == 'E') {
                value = entry.getValue();
                assertEquals("110", value);
            }  
        }       
    }
    */

}




