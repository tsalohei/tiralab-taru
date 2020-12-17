package app.tiralab.taru;


import app.tiralab.taru.HuffmanNode;
import app.tiralab.taru.HuffmanTree;
import app.tiralab.taru.Input;
import app.tiralab.taru.InputText;
import app.tiralab.taru.datastructures.MyMap;
import app.tiralab.taru.datastructures.MyMinHeap;
//import java.util.Map;
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
        this.input = new InputText("BCAADDDCCACACAC");
        //input.calculate();
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
        
        MyMap myMap = tree.getPrefixes();
        
        assertEquals("11", myMap.get('A'));
        assertEquals("100", myMap.get('B'));
        assertEquals("0", myMap.get('C'));
        assertEquals("101", myMap.get('D'));
    }
    
    
    
    @Test
    public void buildPrefixesTest2() {
       
        InputText input2 = new InputText("A_DEAD_DAD_CEDED_A_BAD_BABE_A_BEADED_ABACA_BED");
        
        HuffmanTree tree2 = new HuffmanTree(input2);
        char[] charArray2 = new char[]{'C', 'B', 'E', '_', 'D', 'A'};
        int []intArray2 = new int[]{2, 6, 7, 10, 10, 11};
        
        MyMinHeap q = tree2.buildMinHeap(charArray2, intArray2);
        HuffmanNode rootNode = tree2.createInternalNodes(q);
        
        tree2.buildPrefixes(rootNode, "");
        
        MyMap myMap = tree2.getPrefixes();
        String value = null;
        
        assertEquals("10", myMap.get('A'));
        assertEquals("1111", myMap.get('B'));
        assertEquals("1110", myMap.get('C'));
        assertEquals("110", myMap.get('E'));
    } 
    
}