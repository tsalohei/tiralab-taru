
package app.tiralab.taru.datastructures;

/**
 * Instances of this class are used in MyMap. 
 */
public class MapItem {
    
    private Character key;
    private String value;
    private MapItem nextItem;
    
    /**
     * Constructor for MapItem. 
     * @param key character (for example 'a')
     * @param value String (for example "101")
     */
    public MapItem(Character key, String value) {
        this.key = key;
        this.value = value;
        this.nextItem = null;
    }
    
    /**
     * Getter for key 
     * @return key (char)
     */
    public Character getKey() {
        return this.key;
    }
    
    /**
     * Getter for value
     * @return String (prefix)
     */
    public String getValue() {
        return this.value;
    }
    
    /**
     * Returns the next item associated with this MapItem. 
     * @return MapItem
     */
    public MapItem getNext() {
        if (this.nextItem == null) {
            return null;
        } else {
            return this.nextItem;
        }
    }
    
    /**
     * Setter for key.
     * @param c character
     */
    public void setKey(Character c) {
        this.key = c;
    }
    
    /**
     * Setter for value.
     * @param s String
     */
    public void setValue(String s) {
        this.value = s;
    }
    
    /**
     * Setter for next MapItem.
     * @param item MapItem
     */
    public void setNext(MapItem item) {
        this.nextItem = item;
    }
}
