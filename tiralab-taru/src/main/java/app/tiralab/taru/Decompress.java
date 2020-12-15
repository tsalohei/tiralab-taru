package app.tiralab.taru;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This is the first version for decompression. First we just read the coded 
 * String input (for example "1011001.."), and re-create the input String from 
 * that with the help of the HuffmanTree/root node associated with the input.
 */
public class Decompress {
    
    private final String s;
    private final HuffmanTree tree;
    File myFileObj;
    String fileName; //UUSI
    
    public Decompress(String s, HuffmanTree tree, String inputFilename) { //filename UUSI!!
        this.s = s;
        this.tree = tree;
        this.fileName = inputFilename.substring(0, inputFilename.lastIndexOf("."));
    }
    
    /**
     * Takes in prefix String ("01010111...") and turns it into a String
     * ("some random text...").
     * @return String 
     */
    public String process() throws IOException {
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
        
        createNewFile();
        writeToFile(builder.toString());
        
        return builder.toString();
    }
    
    public void writeToFile(String s) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(this.fileName + ".dc"));
        writer.write(s);
    
        writer.close();
    }
    
    public void createNewFile() {
        try {
            this.myFileObj = new File(this.fileName + ".dc"); // tähän filen oikea nimi mukaan
            
            if (myFileObj.createNewFile() == false) {
                System.out.println("File " + this.fileName + ".dc already "
                        + "exists. Delete the file to make a new one.");
            }
            
        } catch (IOException e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
    }
}
