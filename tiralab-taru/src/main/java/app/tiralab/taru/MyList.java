package app.tiralab.taru;

/**
 *
 * This class an own implementation of a list structure. Basis for this class:
 * https://tira-s19.mooc.fi/materiaali (material for week 4)
 */

// TODO insertion, size, sorting

public class MyList {
    
    private CharacterObject[] array;
    private int n;
    private int index;
    
    /**
     * Constructor. The initial size of the list is 10.
     */
    public MyList() {
        n = 10;
        array = new CharacterObject[n];
        index = 0;
    }
    
    /**
     * Adds an item to the list. Variable k has been initialized to 0 and 
     * denotes index in the list. Index is increased every time a 
     * CharacterObject is added to the list. If the list is full, the size of 
     * the list is doubled by making a new list and copying the values from the 
     * full list to the new list.
     * PROBLEM: NO RESIZING
     * @param co CharacterObject to be added to the list
     */
    public void add(CharacterObject co) {
        if (index == n) {
            CharacterObject[] u = new CharacterObject[2 * n];
            for (int i = 0; i < n; i++) {
                u[i] = array[i];
            }
            array = u;
            n = 2 * n;
        }
        array[index] = co;
        index++;
    }
    
    /**
     * Returns the CharacterObject instance at the index given as parameter.
     * @param a index
     * @return CharacterObject instance at index
     */
    public CharacterObject get(int a) {
        return array[a];
    }
    
    public void sort() {
        //lomitusjärjestäminen, "merge sort" would be efficient
    }
}
