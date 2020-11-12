package app.tiralab.taru;

/**
 * This class represents one node used in a Huffman Tree (minimum heap).
 */
public class HuffmanNode {
    private char c;
    private int freq;
    private HuffmanNode left;
    private HuffmanNode right;
    
    HuffmanNode () {
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
}
