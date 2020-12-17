
package app.tiralab.taru.datastructures;

public class MapItem {
    
    private Character key;
    private String value;
    private MapItem nextItem;
    
    public MapItem(Character key, String value) {
        this.key = key;
        this.value = value;
        this.nextItem = null;
    }
    
    public Character getKey() {
        return this.key;
    }
    
    public String getValue() {
        return this.value;
    }
    
    public MapItem getNext() {
        if (this.nextItem == null) {
            return null;
        } else {
            return this.nextItem;
        }
    }
    
    public void setKey(Character c) {
        this.key = c;
    }
    
    public void setValue(String s) {
        this.value = s;
    }
    
    public void setNext(MapItem item) {
        this.nextItem = item;
    }
}
