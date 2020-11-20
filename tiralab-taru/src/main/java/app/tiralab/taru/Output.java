package app.tiralab.taru;

import java.util.Map;

import java.io.File;    
import java.io.IOException; 
import java.io.FileWriter; 

/**
 * This class is responsible for printing and saving the output.
 */
public class Output {
    
    Map<Character, String> map;
    Input input;
    File myFileObj;

    
    public Output(Map<Character, String> map, Input input) {
        this.map = map;
        this.input = input;
    }
     
    public void process() {
        createNewFile();
        String s = createPrefixString();
        savePrefixesToFile(s);
    }
    
    /**
     * Saves the coded input (prefixes) to a file. 
     */
    public void savePrefixesToFile(String s) {
        try {
            FileWriter myWriter = new FileWriter("bookCoded.txt");
            myWriter.write(s);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
    }
    
    /**
     * Finds the unique prefix for each unique character.
     * @param c character
     * @return prefix 
     */
    public String findPrefixForCharacter(char c) {
        String prefix = "";
        for (Map.Entry<Character, String> entry : map.entrySet()) {
            
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
        String codedInput = "";
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            codedInput = codedInput + findPrefixForCharacter(c);
        }   
        return codedInput;
    }
    
    /**
     * Creates a new file called bookCoded.txt.
     */
    public void createNewFile() {
        try {
            this.myFileObj = new File("bookCoded.txt");
            
            if (myFileObj.createNewFile() == false) {
                System.out.println("File bookCoded.txt already exists. Delete "
                        + "the file to make a new one.");
            }
            
        } catch (IOException e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
    }
    
    
    /* Can be deleted
    public void printPrefixes() {
        for (Map.Entry<Character, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
    
    public void printCodedInput() {
        String s = this.input.getString();
        String codedInput = "";
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            codedInput = codedInput + findPrefixForCharacter(c);
        }
        System.out.println(codedInput);
    }
    */
}
