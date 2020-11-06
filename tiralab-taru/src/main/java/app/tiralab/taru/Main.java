package app.tiralab.taru;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author taru
 */
//https://www.geeksforgeeks.org/huffman-coding-greedy-algo-3/
//https://www.programiz.com/dsa/huffman-coding

public class Main {
    public static void main(String[] args) {
        
        
        HuffmanTree tree = new HuffmanTree(new Input("aabbabca"));
        
        HuffmanNode root = tree.create();
        
        printCode(root, "");
        
    }    
    
    public static void printCode(HuffmanNode root, String s) 
    { 
  
        // base case; if the left and right are null 
        // then its a leaf node and we print 
        // the code s generated by traversing the tree. 
        if (root.left 
                == null
            && root.right 
                   == null
            && Character.isLetter(root.c)) { 
  
            // c is the character in the node 
            System.out.println(root.c + ":" + s); 
  
            return; 
        } 
  
        // if we go to left then add "0" to the code. 
        // if we go to the right add"1" to the code. 
  
        // recursive calls for left and 
        // right sub-tree of the generated tree. 
        printCode(root.left, s + "0"); 
        printCode(root.right, s + "1"); 
    } 
    
}
    
    
    
    


