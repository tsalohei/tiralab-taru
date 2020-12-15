package app.tiralab.taru;

import java.io.File;    
import java.io.FileNotFoundException;
import java.io.IOException; 

/**
 * This class is responsible for printing and saving the output.
 */
public class Output {
    
    InputText input;
    File myFileObj;
    String inputFilename;
    
    private HuffmanTree huffmanTree;
    
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
    
    public void process() throws FileNotFoundException, IOException {
        createNewFile();
        String s = createPrefixString();
        
        BitWriter bitWriter = new BitWriter(myFileObj);
        
        bitWriter.writeNumberOfCharacters(huffmanTree.getCharArray().length);
              
        bitWriter.writeCharArray(huffmanTree.getCharArray());
        
        bitWriter.writeFreqArray(huffmanTree.getFreqArray());
        
        bitWriter.writeBitsInString(s);
        bitWriter.stop();
        
        bitWriter.writeHowManyBits();
        bitWriter.closeStream();
        
    }
    
    /**
     * Finds the unique prefix for each unique character.
     * @param c character
     * @return prefix 
     */
    public String findPrefixForCharacter(char c) {
        return this.huffmanTree.getPrefixes().get(c);
    }
    
    /**
     * Creates a string that represents the entire input in the coded form.
     */
    public String createPrefixString() {
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
     */
    public void createNewFile() {
        try {
            this.myFileObj = new File(inputFilename + ".huff");
            
            if (myFileObj.createNewFile() == false) {
                System.out.println("File " + inputFilename + ".huff already "
                        + "exists. Delete the file to make a new one.");
            }
            
        } catch (IOException e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
    }
    
    
}
