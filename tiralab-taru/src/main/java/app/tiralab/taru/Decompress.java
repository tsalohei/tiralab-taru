package app.tiralab.taru;

/**
 * This is the first version for decompression. First we just read the coded 
 * String input (for example "1011001.."), and re-create the input String from 
 * that with the help of the HuffmanTree/root node associated with the input.
 */
public class Decompress {
    
    private final String s;
    private final HuffmanTree tree;
    
    public Decompress(String s, HuffmanTree tree) {
        this.s = s;
        this.tree = tree;
    }
    
    /**
     * Takes in prefix String ("01010111...") and turns it into a String
     * ("some random text...").
     * @return String 
     */
    public String process() {
        HuffmanNode root = tree.getRoot();
        StringBuilder builder = new StringBuilder();
        
        HuffmanNode currentNode = root;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                currentNode = currentNode.getLeft();                
            } else if ((s.charAt(i) == '1')) {
                currentNode = currentNode.getRight();                
            } else {
                System.out.println("There should be only 1's and 0's but seems"
                        + "there is something else too");
            }
            if (currentNode.isLeafNode()) {
                builder.append(currentNode.getChar());
                currentNode = root;
            }
        }
        
        return builder.toString();
    }
}
