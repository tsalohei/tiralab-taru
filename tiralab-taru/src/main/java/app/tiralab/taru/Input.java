/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.tiralab.taru;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class handles String input (later also text files). Stuff given to 
 * a HuffmanTree.
 */
public class Input {
    
    //https://www.ascii-code.com/
    
    private final String s;
    private char[] chars;
    private int[] frequencies;
    int n;
    
    public Input(String input) { 
        this.s = input;
    }
    
    
    public void calculate() {
        int[] intarray = makeArrayFromString(); 
        ArrayList<CharacterObject> arraylist = createCharacterObjectList(intarray);
        setCharFreq(arraylist);
        setCharArray(arraylist);
        this.n = arraylist.size();
        
    }
    
    public char[] getCharArray() {
        return this.chars;
    }
    
    public int[] getCharFreq() {
        return this.frequencies;
    } 
    
    public int getNroOfUniqueCharacters() {
        return this.n;
    }
    
    /**
     * Creates an array with the unique characters in the input. If there are 
     * for example 4 unique characters, the length of the array will be 4.
     * @param intArray Index means which character is in question, and value 
     * tells the frequency of the alphabet. 
     */
    public void setCharArray(ArrayList<CharacterObject> list) {
        int n = list.size();
        this.chars = new char[n]; 
        for (int i = 0; i < n; i++) {
            chars[i] = list.get(i).getCharacter();
        }   
        
    }
    //JATKA TÄSTÄ!!!!!!!
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
    
    /**
     * This method takes a String as input and makes an array out of it. The
     * array has information about what the unique characters in the String are,
     * and what is their frequency in the String. 
     * @see https://www.ascii-code.com/
     * @param s input String
     * @return array with the abovementioned information
     */ 
    public int[] makeArrayFromString() {
        int[] array = new int[256]; 
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);            
            int index = (int) current;
            array[index]++; 
        }
        return array;
    }   
}
