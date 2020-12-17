package app.tiralab.taru;

import java.io.File;    
import java.io.FileNotFoundException;
import java.io.IOException; 

/**
 * This class is responsible for printing and saving the output.
 */
public class Output {
    
    private final InputText input;
    private final String inputFilename;
    private final HuffmanTree huffmanTree;
    private File myFileObj;
    
    public Output(HuffmanTree tree, InputText input, String inputFilename) {
        this.huffmanTree = tree;
        this.huffmanTree.create();
        this.input = input;
        
        if (inputFilename.contains(".")) {
            this.inputFilename = inputFilename.substring(0, inputFilename.lastIndexOf("."));    
        } else {
            this.inputFilename = inputFilename;
        }
    }
    
    /**
     * Creates a compressed file. The file has information about the text input,
     * and has necessary header information needed for decompression.
     * @return true is a new file is made, false otherwise
     * @throws IOException if there is an error with writing to file
     * @throws FileNotFoundException if myFileObj is not found
     */
    public boolean process() throws FileNotFoundException, IOException {
        boolean newFileIsCreated = createNewFile();
        String s = createPrefixString();
        
        BitWriter bitWriter = new BitWriter(myFileObj);
        
        bitWriter.writeNumberOfCharacters(huffmanTree.getCharArray().length);
              
        bitWriter.writeCharArray(huffmanTree.getCharArray());
        
        bitWriter.writeFreqArray(huffmanTree.getFreqArray());
        
        bitWriter.writeBitsInString(s);
        bitWriter.stop();
        
        bitWriter.writeHowManyBits();
        bitWriter.closeStream();
        
        return newFileIsCreated;
    }
    
    /**
     * Finds the unique prefix for each unique character.
     * @param c character
     * @return prefix 
     */
    String findPrefixForCharacter(char c) {
        return this.huffmanTree.getPrefixes().get(c);
    }
    
    /**
     * Creates a string that represents the entire input in the coded form.
     */
    String createPrefixString() {
        String s = this.input.getString();
        StringBuilder codedInput = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            codedInput.append(findPrefixForCharacter(c));
        }   
        return codedInput.toString();
    }
    
    /**
     * Creates a new file where the bytes are written. File name ends in 
     * ".huff".
     * @return true if new file is created, false if there already is a 
     * compressed file for the same file name
     */    
    private boolean createNewFile() {
        try {
            this.myFileObj = new File(inputFilename + ".huff");
            
            if (myFileObj.createNewFile() == false) {
                System.out.println("A compressed version of your file already "
                        + "exists (" + inputFilename + ".huff).");
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
