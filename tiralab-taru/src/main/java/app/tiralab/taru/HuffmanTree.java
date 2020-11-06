package app.tiralab.taru;

import java.util.Map;
import java.util.PriorityQueue;

/**
 * This class builds a Huffman Tree based on input.
 */

public class HuffmanTree {
    
    private final Input input;
    private char[] charArray;
    private int[] charFreq;
    private HuffmanNode root;
    
    public HuffmanTree(Input text) {
        //this.n = this.input.getNroOfUniqueChars();
        //this.charArray = this.input.getCharArray();
        //this.charFreq = this.input.getCharFreq();
        this.input = text;
        this.root = null;
    }
    
    public HuffmanNode create() {
        // input = aaaaabbbcc    
        // [a,b,c]
        // [4,3,2]
        
        input.calculate();
        this.charArray = input.getCharArray();
        this.charFreq = input.getCharFreq();
        
        PriorityQueue<HuffmanNode> q = buildMinHeap(this.charArray, this.charFreq);
        HuffmanNode rootNode = createInternalNodes(q);
     
        Map<Character, String> huffmanPrefixes = buildPrefixes(rootNode);
        
        //FIX THIS
        return null;
        
    }
    
    //IMPLEMENT THIS!
    public Map<Character, String> buildPrefixes(HuffmanNode node) {
        return null;
    }
    
    /**
     * This method creates a minimum priority queue where each unique 
     * character is a leaf node.
     * @return min priority queue (heap where least frequent character is at 
     * top)
     */
    public PriorityQueue<HuffmanNode> buildMinHeap(char[] x, int[] y) {
        int n = input.getNroOfUniqueChars();
        PriorityQueue q = new PriorityQueue<>(n, new HuffmanComparator()); 
  
        for (int i = 0; i < n; i++) { 
            
            HuffmanNode node = new HuffmanNode(); 
  
            node.c = x[i]; 
            node.freq = y[i]; 
  
            node.left = null; 
            node.right = null; 
  
            q.add(node); 
            
          
        }
        return q;
    }
    
    //metodi ottaa inputtina array (character, frequency -> palauttaa priorityququen)
    
    /**
     * This method creates new internal nodes to the min heap. When steps
     * in the method are completed the heap contains only one node. 
     */
    public HuffmanNode createInternalNodes(PriorityQueue<HuffmanNode> q) {
        while (q.size() > 1) { 
            
            HuffmanNode firstNode = q.peek(); 
            q.poll(); 
  
            HuffmanNode secondNode = q.peek(); 
            q.poll(); 
  
            HuffmanNode internalNode = new HuffmanNode(); 

            internalNode.freq = firstNode.freq + secondNode.freq; 
            internalNode.c = '-'; 
  
            internalNode.left = firstNode; 

            internalNode.right = secondNode; 
  
            root = internalNode; 
  
            q.add(internalNode); 
        } 
        
        //FIX THIS
        return null;
    }
    
}
