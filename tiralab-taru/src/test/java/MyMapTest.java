
import app.tiralab.taru.MapItem;
import app.tiralab.taru.MyMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyMapTest {
    
    MyMap map = new MyMap();
    
    @Test
    public void putTest() {
        MapItem item1 = new MapItem("10", 'a');
        MapItem item2 = new MapItem("001", 'b');
        MapItem item3 = new MapItem("01", 'c');
        
        map.put(item1);
        map.put(item2);
        map.put(item3);
        map.put(item2);
        
        Character c1 = 'b';
        Character c2 = map.get("001");
        
        assertEquals(c1, c2);
        
    }
    
}
