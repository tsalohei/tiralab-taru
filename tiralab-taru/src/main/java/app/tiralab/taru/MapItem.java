
package app.tiralab.taru;

public class MapItem {
    
    private String key;
    private Character value;
    private MapItem nextItem;
    
    public MapItem(String key, Character value) {
        this.key = key;
        this.value = value;
        this.nextItem = null;
    }
    
    /*
    public void put(String key, Character value) { //overwrite?
        this.key = key;
        this.value = value;  
    }
    */
    
    public String getKey() {
        return this.key;
    }
    
    public Character getValue() {
        return this.value;
    }
    
    public MapItem getNext() {
        if (this.nextItem == null) {
            return null;
        } else {
            return this.nextItem;
        }
    }
    
    public void setValue(Character c) {
        this.value = c;
    }
    
    public void setKey(String s) {
        this.key = s;
    }
    
    public void setNext(MapItem item) {
        this.nextItem = item;
    }
}
