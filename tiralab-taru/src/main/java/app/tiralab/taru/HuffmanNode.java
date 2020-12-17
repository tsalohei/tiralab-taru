package app.tiralab.taru;

import java.io.Serializable;

/**
 * This class represents one node used in a HuffmanTree.
 */
public class HuffmanNode implements Serializable {
    private char c;
    private int freq;
    private HuffmanNode left;
    private HuffmanNode right;
    
    public HuffmanNode(char c, int f) {
        this.c = c;
        this.freq = f;
    }
    
    public void setChar(char c) {
        this.c = c;
    }
    
    public char getChar() {
        return this.c;
    }
    
    public void setFreq(int freq) {
        this.freq = freq;
    }
    
    public int getFreq() {
        return this.freq;
    }
    
    public void setLeftNode(HuffmanNode left) {
        this.left = left;
    }
    
    public void setRightNode(HuffmanNode right) {
        this.right = right;
    }
    
    public HuffmanNode getLeft() {
        return this.left;
    }
    
    public HuffmanNode getRight() {
        return this.right;
    }
    
    public boolean isLeafNode() {
        return this.left == null && this.right == null;
    }
}
