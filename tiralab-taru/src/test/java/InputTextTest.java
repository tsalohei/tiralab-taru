
import app.tiralab.taru.CharacterObject;
import app.tiralab.taru.InputText;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;


public class InputTextTest {
     
    @Test 
    public void charFrequency() {
        InputText input = new InputText("aabbabca");
        //input.calculate();
        assertArrayEquals(new int[]{1, 3, 4}, input.getCharFreq()); 
    }
   
    @Test 
    public void getCharArrayTest() {
        InputText input = new InputText("aabbabca");
        //input.calculate();
        assertArrayEquals(new char[]{'c', 'b', 'a'}, input.getCharArray());       
    }
    
    @Test 
    public void createCharacterObjectListTest() {
        InputText input = new InputText("aaab");
        int[] intArray = new int[256];
        intArray[97] = 3;
        intArray[98] = 1;
        List<CharacterObject> list = input.createCharacterObjectList(intArray);
        assertEquals(3, list.get(1).getFrequency()); 
        assertEquals('a', list.get(1).getCharacter());
    }    
    
    @Test 
    public void makeArrayFromStringTest() {
        InputText input = new InputText("aabbabca"); 
        int[] intArray = input.makeArrayFromString(); 
        assertEquals(4, intArray[97]);
    }
    
    
    /*
    @Test 
    public void getNroOfUniqueCharacters() {
        InputText input = new InputText("aabbabca");
        //input.calculate();
        assertEquals(3, input.getNroOfUniqueCharacters());
       
    }
    */
   
}
