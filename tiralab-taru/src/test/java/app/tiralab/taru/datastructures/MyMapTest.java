package app.tiralab.taru.datastructures;


import app.tiralab.taru.datastructures.MapItem;
import app.tiralab.taru.datastructures.MyMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyMapTest {
    
    MyMap map = new MyMap();
    
    @Test
    public void putAndGetTest() {
        MapItem item1 = new MapItem('a', "10");
        MapItem item2 = new MapItem('b', "001");
        MapItem item3 = new MapItem('c', "01");
        
        map.put(item1);
        map.put(item2);
        map.put(item3);
        map.put(item2);
        
        String s1 = "001";
        String s2 = map.get('b');
        
        assertEquals(s1, s2);
        
    }
    
}
