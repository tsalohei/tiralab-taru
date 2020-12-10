package app.tiralab.taru;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * This class is an implementation of a Map structure.
 */

//In class huffmantree: put
//in Output: iterate map (get map from tree and findPrefixForCharacter)
//what is preserved in the map: character-string-pairs
public class MyMap {
    
    private final int defaultSize;
    private MapItem[] array;
    //total amount of MapItems/size of MyMap
    
    
    public MyMap() {
       this.defaultSize = 100;
       this.array = new MapItem[defaultSize];
    }
    
    
    public Character get(String key) {
        int index = index(key);
        
        //mennään arrayssä oikeaan indexiin
        MapItem current = this.array[index];
        
        //käydään läpi alkiot ko. indeksistä
        while (current != null) {
            if (current.getKey().equals(key)) {
                return current.getValue();
            }
            
            current = current.getNext();     
        }
         //keissi: key:tä ei löydy       
        return null;
    }
    
    public void put(MapItem item) {
        int index = index(item.getKey());
        
        //if there is NO item in index
        if (this.array[index] == null) {
            this.array[index] = item; 
        
        //if there IS an item at the index
        } else {
            MapItem current = this.array[index];
               
            
            while (true) {
                if (current.getKey().equals(item.getKey())) { //sama key eli esim. "1011"
                    current.setValue(item.getValue());   
                    return;
                }
                
                if (current.getNext() != null) { //seuraava on olemassa
                    current = current.getNext();
                } else { //ei seuraavaa eli ollaan vikassa itemissa
                    break; //ja siirrytään ulos loopista
                }                
            }
            current.setNext(item); //ja asetetaan seuraava
        }
    }
    
    /**
     * Returns the index in array based on key.
     * @param key Key of MapItem
     * @return int index
     */
    private int index(String key) {
        int index = key.hashCode() % this.defaultSize;
        return index;
        //pitääkö varautua siihen että key on null?
        //return indeksi > 0 ? indeksi : -indeksi;
    }
    
}
