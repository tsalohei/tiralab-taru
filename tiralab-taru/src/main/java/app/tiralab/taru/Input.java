package app.tiralab.taru;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class input handles the String input. This class processes information about
 * the String so that the information is available in the correct format to the 
 * HuffmanTree. 
 */
public class Input {
       
    private final String s;
    private char[] chars;
    private int[] frequencies;
    int n;
    
    public Input(String input) { 
        this.s = input;
    }
    
    /**
     * This method makes two arrays based on input. A char array contains the 
     * unique characters in the input, and an integer array their respective 
     * frequencies.
     */
    public void calculate() {
        int[] intarray = makeArrayFromString(); 
        ArrayList<CharacterObject> arraylist = createCharacterObjectList(intarray);
        setCharFreq(arraylist);
        setCharArray(arraylist);
        this.n = arraylist.size();    
    }
    
    /**
     * This method takes a String as input and makes an array out of it. The
     * array has information about what the unique characters in the String are,
     * and what is their frequency in the String. 
     * @param s input String
     * @return array with the abovementioned information
     */ 
    public int[] makeArrayFromString() {
        
        /*
        for (byte b : s.getBytes()) {
            array[((int) b) + 128]++;
        }*/
         //TODO: support also others than ASCII 
         
        int[] array = new int[256]; 
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);      
            int index = (int) current;
            //extra due to non-ascii stuff
            if (index >= 0 && index <= 255) {
                array[index]++;     
            }            
        }
        return array;
    } 
    
    /**
     * This method returns a char array.
     * @return char array
     */
    public char[] getCharArray() {
        return this.chars;
    }
    
    /**
     * This method returns an integer array.
     * @return int array
     */
    public int[] getCharFreq() {
        return this.frequencies;
    } 
    
    /**
     * This method returns the number of unique characters in the input.
     * @return integer
     */
    public int getNroOfUniqueCharacters() {
        return this.n;
    }
    
    /**
     * Creates a char array. One unique character occupies one index in array. 
     * If there are for example 4 unique characters, the length of the array 
     * will be 4. Characters are in increasing order of frequency.
     * @param list Index means which character is in question, and value 
     * tells the frequency of the alphabet. 
     */
    public void setCharArray(ArrayList<CharacterObject> list) {
        int n = list.size();
        this.chars = new char[n]; 
        for (int i = 0; i < n; i++) {
            chars[i] = list.get(i).getCharacter();
        }       
    }
    
    /**
     * Creates an integer array. Length of the array equals the amount of unique
     * characters. Value equals the frequency of one unique character in input. 
     * The values are in increasing order of frequency.
     * @param list 
     */
    public void setCharFreq(ArrayList<CharacterObject> list) {
        int n = list.size();
        this.frequencies = new int[n]; 
        for (int i = 0; i < n; i++) {
            frequencies[i] = list.get(i).getFrequency();
        }          
    }
    
    /**
     * This method makes a list of CharacterObject instances where the objects
     * are in increasing order based on frequency. 
     * @param intArray
     * @return list of CharacterObject instances
     */
    public ArrayList<CharacterObject> createCharacterObjectList(int[] intArray) {
        ArrayList<CharacterObject> list = new ArrayList<>();
        for (int i = 0; i < intArray.length; i++) { 
         
            if (i > 31 && intArray[i] > 0) { //visible ascii characters start from index 32
                char c = (char) (i);
                int j = intArray[i];
                CharacterObject co = new CharacterObject(c, j);
                list.add(co);
            }
        }
        Collections.sort(list);
        return list;
    }
    
    public String getString() {
        return this.s;
    }
}
