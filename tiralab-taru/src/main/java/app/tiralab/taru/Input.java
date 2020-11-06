/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.tiralab.taru;

/**
 * This class handles String input (later also text files). Stuff given to 
 * a HuffmanTree.
 */
public class Input {
    
    //https://www.ascii-code.com/
    
    private final String s;
    private char[] chars;
    private int[] frequencies;
    
    public Input(String input) { 
        this.s = input;
    }
    
    //String --> array of unique chars, and array of their frequencies
    
    //3 DUMMY METHODS TO HELP GET STARTED. This could be used in testing? 
    public char[] getCharArray() {
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' }; 
        return charArray;
    }
    
    public int[] getCharFreq() {
        int[] charFreq = { 5, 9, 12, 13, 16, 45 };
        return charFreq;
    }
    
    public int getNroOfUniqueChars() {
        return 6;
    }
    
    public void calculate() {
        makeArrayFromString();
        // create char array
        // calculate frequencies
        
    }
    /**
     * This method takes a String as input and makes an array out of it. The
     * array has information about what the unique characters in the array are,
     * and what is their frequency in the String.
     * NOTE: first implemented for lowercase letters only! 
     * (ascii 97...122) = 26 letters
     * @param s input String
     * @return array with the abovementioned information
     */ 
    private int[] makeArrayFromString() {
        int[] array = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            int index = (int) current;
            if (index >= 97 && index <= 122) {
                array[index - 97]++;
            }
        }
        return array;
    }
    
    
        
    
    
}
