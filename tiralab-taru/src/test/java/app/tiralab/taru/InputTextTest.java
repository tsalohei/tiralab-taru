package app.tiralab.taru;


import app.tiralab.taru.CharacterObject;
import app.tiralab.taru.InputText;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;


public class InputTextTest {
    @Test 
    public void charFrequency() {
        InputText input = new InputText("aabbabca");    
        assertArrayEquals(new int[]{1, 3, 4}, input.getCharFreq()); 
    }
   
    @Test 
    public void getCharArrayTest() {
        InputText input = new InputText("aabbabca");     
        assertArrayEquals(new char[]{'c', 'b', 'a'}, input.getCharArray());       
    }
        
    @Test 
    public void makeArrayFromStringTest() {
        InputText input = new InputText("aabbabca"); 
        int[] intArray = input.makeArrayFromString(); 
        assertEquals(4, intArray[97]);
    }
    
    @Test
    public void mergeSortTest() {
        CharacterObject[] array = new CharacterObject[5];
        array[0] = new CharacterObject('c', 5);
        array[1] = new CharacterObject('b', 4);
        array[2] = new CharacterObject('d', 8);
        array[3] = new CharacterObject('a', 1);
        array[4] = new CharacterObject('k', 15);
        
        InputText input = new InputText("dummy");
        
        input.mergeSort(array);
        
        assertEquals(1, array[0].getFrequency());
        assertEquals(4, array[1].getFrequency());
        assertEquals(15, array[4].getFrequency());
    }
    
    
    @Test 
    public void createCharacterObjectListTest() {
        InputText input = new InputText("aaab");
        int[] intArray = new int[256];
        intArray[97] = 3;
        intArray[98] = 1;
        CharacterObject[] list = input.createCharacterObjectList(intArray);
        
        assertEquals(1, list[0].getFrequency()); 
        assertEquals('b', list[0].getCharacter());
        assertEquals(3, list[1].getFrequency()); 
        assertEquals('a', list[1].getCharacter());
    }    
   
}
