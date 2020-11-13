
import app.tiralab.taru.HuffmanNode;
import app.tiralab.taru.HuffmanTree;
import app.tiralab.taru.Input;
import java.util.PriorityQueue;
import static org.junit.Assert.*;
import org.junit.Test;

public class HuffmanTreeTest {

          
        
        @Test 
        public void buildMinHeapTest() {
            Input input = new Input("aabbabca");
            input.calculate();
            HuffmanTree tree = new HuffmanTree(input);
            char[] charArray = new char[]{'c', 'b', 'a'};
            int[] intArray = new int[]{1, 3, 4};
            //YLLÄOLEVAT KAIKILLE YHTEISIKSI?
            
            PriorityQueue<HuffmanNode> q = tree.buildMinHeap(charArray, intArray);
            
            HuffmanNode hf = q.peek();
            
            assertEquals(hf.getChar(), 'c');
            assertEquals(hf.getFreq(), 1);
            assertEquals(hf.getLeft(), null);
            assertEquals(hf.getRight(), null);
        }
    
        @Test 
        public void createInternalNodesTest() {
            Input input = new Input("aabbabca");
            input.calculate();
            HuffmanTree tree = new HuffmanTree(input);
            char[] charArray = new char[]{'c', 'b', 'a'};
            int[] intArray = new int[]{1, 3, 4};
            //ylläoleva toistoa
            
            PriorityQueue<HuffmanNode> q = tree.buildMinHeap(charArray, intArray);
           
            HuffmanNode rootNode = tree.createInternalNodes(q);
            
            assertEquals(rootNode.getFreq(), 8);
        }  
        
        
        
        @Test
        public void buildPrefixesTest() {
            //buildPrefixes(rootNode, "");
        }
        
}
