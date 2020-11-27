package app.tiralab.taru;

import java.util.HashMap;
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
    private Map<Character, String> map;
    
    public HuffmanTree(Input text) {
        this.input = text;
        this.root = null;
        this.map = new HashMap<Character, String>();
    }
    
    public HuffmanNode create() {
        input.calculate();
        this.charArray = input.getCharArray();
        this.charFreq = input.getCharFreq();
        
        PriorityQueue<HuffmanNode> q = buildMinHeap(this.charArray, this.charFreq);
        HuffmanNode rootNode = createInternalNodes(q);
     
        buildPrefixes(rootNode, "");
        
        return rootNode;
        
    }
    
    /**
     * This method creates a minimum priority queue where each unique 
     * character (represented by a HuffmanNode) is a leaf node.
     * @return min priority queue (heap where least frequent character is first)
     */
    public PriorityQueue<HuffmanNode> buildMinHeap(char[] x, int[] y) {
        int n = input.getNroOfUniqueCharacters();

        PriorityQueue<HuffmanNode> q = new PriorityQueue<>(n, new HuffmanComparator()); 
  
        for (int i = 0; i < n; i++) {             
            HuffmanNode node = new HuffmanNode(); 
            node.setChar(x[i]);
            node.setFreq(y[i]);
            
            node.setLeftNode(null);
            node.setRightNode(null);
            
            q.add(node); 
        }
        return q;
    }
    
    /**
     * This method creates new internal nodes to the minimum heap. When steps
     * in the method are completed the heap contains only one node. 
     * @param PriorityQueue where all Huffman nodes are leaves
     * @return the root node that is left in the end
     */
    public HuffmanNode createInternalNodes(PriorityQueue<HuffmanNode> q) {
        while (q.size() > 1) { 
            
            HuffmanNode firstNode = q.peek(); 
            q.poll(); 
  
            HuffmanNode secondNode = q.peek(); 
            q.poll(); 
  
            HuffmanNode internalNode = new HuffmanNode(); 

            internalNode.setFreq(firstNode.getFreq() + secondNode.getFreq());
            
            internalNode.setChar('\u0000');
            
            internalNode.setLeftNode(firstNode);

            internalNode.setRightNode(secondNode);
            
            root = internalNode; 
  
            q.add(internalNode); 
        } 
        
        return root;
    }
    
    /**
     * This method builds a unique prefix for each unique character.
     * @param root Root node 
     * @param s String Used in the recursive method to allocate the prefix 
     * for each character
     */
    public void buildPrefixes(HuffmanNode root, String s) {
        
        if (root == null) {
            return;
        }    
         
        if (root.getLeft() == null && root.getRight() == null  
            && ((int) root.getChar() > 31)) { //31-->visible ascii values
            
                
            map.put(root.getChar(), s);
            return; 
        } 
        buildPrefixes(root.getLeft(), s + "0"); 
        buildPrefixes(root.getRight(), s + "1");         
    }
    
    
    /**
     * Getter for the prefixes.
     * @return Map with Character-String -pairs where the String is the prefix
     */
    public Map<Character, String> getPrefixes() {
        return this.map;
    }

}
