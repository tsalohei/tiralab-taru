
import app.tiralab.taru.CharacterObject;
import app.tiralab.taru.Input;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author taru
 */
public class InputTest {
     
    @Test //TOIMII
    public void charFrequency() {
        Input input = new Input("aabbabca");
        input.calculate();
        assertArrayEquals(new int[]{1, 3, 4}, input.getCharFreq()); 
    }
   
    @Test //TOIMII
    public void getCharArrayTest() {
        Input input = new Input("aabbabca");
        input.calculate();
        assertArrayEquals(new char[]{'c', 'b', 'a'}, input.getCharArray());       
    }
    
    @Test //TOIMII
    public void createCharacterObjectListTest() {
        Input input = new Input("aaab");
        int[] intArray = new int[256];
        intArray[97] = 3;
        intArray[98] = 1;
        List<CharacterObject> list = input.createCharacterObjectList(intArray);
        assertEquals(3, list.get(1).getFrequency()); 
        assertEquals('a', list.get(1).getCharacter());
    }    
    
    @Test //TOIMII
    public void makeArrayFromStringTest() {
        Input input = new Input("aabbabca"); 
        int[] intArray = input.makeArrayFromString(); 
        assertEquals(4, intArray[97]);
    }
    
    
    @Test //TOIMII
    public void getNroOfUniqueCharacters() {
        Input input = new Input("aabbabca");
        input.calculate();
        assertEquals(3, input.getNroOfUniqueCharacters());
       
    }
   
}
