package app.tiralab.taru;

import java.util.ArrayList; //POISTA
import java.util.Collections; // POISTA
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author taru
 */
//https://www.geeksforgeeks.org/huffman-coding-greedy-algo-3/
//https://www.programiz.com/dsa/huffman-coding

public class Main {
    public static void main(String[] args) {
        
        /*
        HuffmanTree tree = new HuffmanTree(new Input("aabbabca"));
        
        HuffmanNode root = tree.create();
        
        Map<Character, String> map = tree.getPrefixes();
        
        //annetaan Output-oliolle root ja map, ja sitten tulostetaan...
        */
        
        
        
        int[] intArray = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,0,0,0,0,0,0,0,0,0,0,5};
        
       // public ArrayList<CharacterObject> createCharacterObjectList(int[] intArray) {
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
        
        
        
        
        
        
        
        for (CharacterObject co : list) {
            System.out.println(co.getCharacter() + ", " + co.getFrequency());
        }
        
        
        
        
        
        
        
        
    }    
}