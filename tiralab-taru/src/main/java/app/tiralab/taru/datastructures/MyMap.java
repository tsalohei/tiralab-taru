package app.tiralab.taru.datastructures;

/**
 * This class is an implementation of a Map structure. MyMap preserves
 * MapItems (i.e. character-String pairs). MyMap has an array of MapItems, and
 * within one array index there can be several MapItems in a linked list 
 * structure.
 */

public class MyMap {
    
    private static final int DEFAULT_SIZE = 97; // prime number
    private MapItem[] array;
    
    /**
     * Constructor for MyMap. Creates an array of MapItems.
     */
    public MyMap() {
        this.array = new MapItem[DEFAULT_SIZE];
    }
    
    /**
     * Getter for the value associated with the given key.
     * @param key char
     * @return String 
     */
    public String get(Character key) {
        int index = index(key);
        
        MapItem current = this.array[index];
        
        while (current != null) {
            if (current.getKey().equals(key)) {
                return current.getValue();
            }
            
            current = current.getNext();     
        }
             
        return null;
    }
    
    /**
     * Puts a MapItem to MyMap. If there already is a MapItem with the same key,
     * the value associated to that key is overwritten.
     * @param item MapItem that is placed to the MyMap
     */
    public void put(MapItem item) {
        int index = index(item.getKey());
        
        if (this.array[index] == null) {
            this.array[index] = item; 
        
        } else {
            MapItem current = this.array[index];
               
            
            while (true) {
                if (current.getKey().equals(item.getKey())) { 
                    current.setValue(item.getValue());   
                    return;
                }
                
                if (current.getNext() != null) { 
                    current = current.getNext();
                } else { 
                    break; 
                }                
            }
            current.setNext(item); 
        }
    }
    
    /**
     * Returns the index in array based on key.
     * @param key Key of MapItem
     * @return int index
     */
    private int index(Character key) {
        int index = key.hashCode() % DEFAULT_SIZE;
        return index;
    }
    
}
