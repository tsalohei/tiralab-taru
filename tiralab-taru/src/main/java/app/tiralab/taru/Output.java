package app.tiralab.taru;

import java.util.Map;

import java.io.File;    
import java.io.FileNotFoundException;
import java.io.IOException; 
import java.io.FileWriter; 

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
        // TODO add getters in huffmantree for char and freq arrays - DONE
        
        // write huffmanTree.getCharArray().length as int to this.myFileObj
        bitWriter.writeNumberOfCharacters(huffmanTree.getCharArray().length);
        System.out.println("Output: char/freq-Array length: " + huffmanTree.getCharArray().length);
               
        // write huffmanTree.getCharArray() to file
        bitWriter.writeCharArray(huffmanTree.getCharArray());
        
        // write huffmanTree.getFreqArray() to file
        bitWriter.writeFreqArray(huffmanTree.getFreqArray());
        
        bitWriter.writeBitsInString(s);
        bitWriter.stop();
        
        //how many "real" bits, excluding possible zeros from end
        bitWriter.writeHowManyBits();
        bitWriter.closeStream();
        
        
        System.out.println("Output-class: File length: " + myFileObj.length());
        
        //savePrefixesToFile(s);
        
    }
    
    /**
     * Saves the coded input (prefixes) to a file in readable format.
     * @param s String that contains the coded input
     *
    public void savePrefixesToFile(String s) {
        try {
            FileWriter myWriter = new FileWriter("bookCoded.huff");
            myWriter.write(s);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
    }*/
    
    
    /**
     * Finds the unique prefix for each unique character.
     * @param c character
     * @return prefix 
     */
    public String findPrefixForCharacter(char c) {
        String prefix = "";
        for (Map.Entry<Character, String> entry : this.huffmanTree.getPrefixes().entrySet()) {
            
            if (entry.getKey() == c) {
                prefix = entry.getValue();
            } 
        } 
        return prefix;
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
     * Creates a new file called bookCoded.txt.
     */
    public void createNewFile() {
        try {
            this.myFileObj = new File(inputFilename + ".huff");
            
            if (myFileObj.createNewFile() == false) {
                System.out.println("File " + inputFilename + ".huff already exists. Delete "
                        + "the file to make a new one.");
            }
            
        } catch (IOException e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
    }
    
    
}
