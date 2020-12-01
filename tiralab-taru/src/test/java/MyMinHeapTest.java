
import app.tiralab.taru.HuffmanComparator;
import app.tiralab.taru.HuffmanNode;
import app.tiralab.taru.MyMinHeap;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MyMinHeapTest { 
    
    @Test
    public void insertTest() {
        MyMinHeap heap = new MyMinHeap(5, new HuffmanComparator());
        
        heap.insert(new HuffmanNode('d', 4));
        heap.insert(new HuffmanNode('f', 6));
        heap.insert(new HuffmanNode('i', 9));
        heap.insert(new HuffmanNode('b', 2));
        heap.insert(new HuffmanNode('c', 3));      
        
        HuffmanNode[] array = heap.getMyMinHeapAsArray();
        
        assertEquals(2, array[1].getFreq());
        assertEquals(3, array[2].getFreq());
        assertEquals(9, array[3].getFreq());
        assertEquals(6, array[4].getFreq());
        assertEquals(4, array[5].getFreq());
        
    }
    @Test
    public void checkMinTest() {
        MyMinHeap heap = new MyMinHeap(5, new HuffmanComparator());
        
        heap.insert(new HuffmanNode('d', 4));
        heap.insert(new HuffmanNode('f', 6));
        heap.insert(new HuffmanNode('i', 9));
        heap.insert(new HuffmanNode('b', 2));
        heap.insert(new HuffmanNode('c', 3));
        
        assertEquals(2, heap.checkMin().getFreq());
    }
    
    @Test
    public void isEmptyTest() {
        MyMinHeap heap = new MyMinHeap(5, new HuffmanComparator());
        
        assertEquals(true, heap.isEmpty());
        
        heap.insert(new HuffmanNode('d', 4));
        
        assertEquals(false, heap.isEmpty());
    }
    
    @Test
    public void deleteMinTest() {
        MyMinHeap heap = new MyMinHeap(5, new HuffmanComparator());
        
        heap.insert(new HuffmanNode('d', 4));
        heap.insert(new HuffmanNode('f', 6));
        heap.insert(new HuffmanNode('i', 9));
        heap.insert(new HuffmanNode('b', 2));
        heap.insert(new HuffmanNode('c', 3));
        
        assertEquals(2, heap.deleteMin().getFreq());
        assertEquals(3, heap.deleteMin().getFreq());
        assertEquals(4, heap.deleteMin().getFreq());
        assertEquals(6, heap.deleteMin().getFreq());
        assertEquals(9, heap.deleteMin().getFreq());
        assertEquals(null, heap.deleteMin());
    }
   
    @Test
    public void getSizeTest() {
        MyMinHeap heap = new MyMinHeap(5, new HuffmanComparator());        
        assertEquals(0, heap.getSize());
        
        heap.insert(new HuffmanNode('d', 4));
        assertEquals(1, heap.getSize());
        
        heap.insert(new HuffmanNode('f', 6));
        assertEquals(2, heap.getSize());
    }
}
