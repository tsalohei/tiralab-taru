
import app.tiralab.taru.CharacterObject;
import app.tiralab.taru.Input;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;


public class InputTest {
     
    @Test 
    public void charFrequency() {
        Input input = new Input("aabbabca");
        input.calculate();
        assertArrayEquals(new int[]{1, 3, 4}, input.getCharFreq()); 
    }
   
    @Test 
    public void getCharArrayTest() {
        Input input = new Input("aabbabca");
        input.calculate();
        assertArrayEquals(new char[]{'c', 'b', 'a'}, input.getCharArray());       
    }
    
    @Test 
    public void createCharacterObjectListTest() {
        Input input = new Input("aaab");
        int[] intArray = new int[256];
        intArray[97] = 3;
        intArray[98] = 1;
        List<CharacterObject> list = input.createCharacterObjectList(intArray);
        assertEquals(3, list.get(1).getFrequency()); 
        assertEquals('a', list.get(1).getCharacter());
    }    
    
    @Test 
    public void makeArrayFromStringTest() {
        Input input = new Input("aabbabca"); 
        int[] intArray = input.makeArrayFromString(); 
        assertEquals(4, intArray[97]);
    }
    
    
    @Test 
    public void getNroOfUniqueCharacters() {
        Input input = new Input("aabbabca");
        input.calculate();
        assertEquals(3, input.getNroOfUniqueCharacters());
       
    }
   
}
