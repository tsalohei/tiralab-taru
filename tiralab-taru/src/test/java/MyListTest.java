import app.tiralab.taru.CharacterObject;
import app.tiralab.taru.MyList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class MyListTest {
    
    //private MyList list;
    
    /*
    private CharacterObject[] t;
    private int n;
    private int k;
    */       

    /*
    @Before
    public void setup() {
        this.list = new MyList();
    }
    */
                
    @Test
    public void addAndGetTest() {
        MyList list = new MyList();
        CharacterObject obj1 = new CharacterObject('a', 5);
        CharacterObject obj2 = new CharacterObject('b', 2);
        
        list.add(obj1);
        list.add(obj2);
        
        assertEquals(obj1, list.get(0));
        assertEquals(obj2, list.get(1));
        
    }
    
    
    
}
