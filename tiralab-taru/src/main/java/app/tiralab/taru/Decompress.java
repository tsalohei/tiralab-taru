package app.tiralab.taru;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class creates a String (for example "hello...") out of a prefix String 
 * ("01101100..") with the help of a HuffmanTree, and is responsible for
 * writing the String to file. 
 */
public class Decompress {
    
    private final String s;
    private final HuffmanTree tree;
    File myFileObj;
    String fileName; 
    
    /**
     * Constructor for Decompress
     * @param s String
     * @param tree HuffmanTree
     * @param inputFilename String
     */
    public Decompress(String s, HuffmanTree tree, String inputFilename) {
        this.s = s;
        this.tree = tree;
        this.fileName = inputFilename.substring(0, inputFilename.lastIndexOf("."));
    }
    
    /**
     * Takes in prefix String ("01010111..."), turns it into a String
     * ("hello..."), and writes to file.
     * @return true if writing to file is successful, false otherwise 
     * @throws IOException if writing to file fails
     */
    public boolean process() throws IOException {
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
     
        boolean newFileWasCreated = createNewFile();
        writeToFile(builder.toString());        
        return newFileWasCreated;
    }
    
    /**
     * Writes a String (for example "Hello...") to file.
     * @param s String
     * @throws IOException if writing to file fails
     */
    void writeToFile(String s) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(this.fileName 
                + ".dc"));
        writer.write(s);
        writer.close();
    }
    
    /**
     * Creates a new file that ends in .dc (for example file.dc).
     * @return true if new file is created, false otherwise
     */
    private boolean createNewFile() {
        try {
            this.myFileObj = new File(this.fileName + ".dc"); 
            
            if (myFileObj.createNewFile() == false) {
                System.out.println("A compressed version of your file already "
                        + "exists (" + this.fileName + ".dc).");
                return false;
            } else {
                return true;
            }
            
        } catch (IOException e) {
            System.out.println("Error!");
            e.printStackTrace();
            return false;
        }
    }
}
