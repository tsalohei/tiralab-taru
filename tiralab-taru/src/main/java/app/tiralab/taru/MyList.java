package app.tiralab.taru;

/**
 *
 * This class an own implementation of a list structure. Basis for this class:
 * https://tira-s19.mooc.fi/materiaali (material for week 4)
 */

// TODO insertion, size, sorting

public class MyList {
    
    private CharacterObject[] t;
    private int n;
    private int k;
    
    /**
     * Constructor. The initial size of the list is 10.
     */
    public MyList() {
        n = 10;
        t = new CharacterObject[n];
        k = 0;
    }
    
    /**
     * Adds an item to the list. Variable k has been initialized to 0 and 
     * denotes index in the list. Index is increased every time a 
     * CharacterObject is added to the list. If the list is full, the size of 
     * the list is doubled by making a new list and copying the values from the 
     * full list to the new list.
     * @param co CharacterObject to be added to the list
     */
    public void add(CharacterObject co) {
        if (k == n) {
            CharacterObject[] u = new CharacterObject[2 * n];
            for (int i = 0; i < n; i++) {
                u[i] = t[i];
            }
            t = u;
            n = 2 * n;
        }
        t[k] = co;
        k++;
    }
    
    public int getSize() {
        return -99;
    }
    
    public void sort() {
        
    }
}
