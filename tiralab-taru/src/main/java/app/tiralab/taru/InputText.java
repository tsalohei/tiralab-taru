package app.tiralab.taru;

/**
 * Class Input handles the String input. This class processes information about
 * the String so that the information is available in the correct format to the 
 * HuffmanTree class. 
 */
public class InputText implements Input {
       
    private final String s;
    private char[] chars;
    private int[] frequencies;
    
    public InputText(String input) { 
        this.s = input;
        calculate(); 
    }
    
    /**
     * This method makes two arrays based on input text. A char array contains 
     * the unique characters in the input text, and an integer array their 
     * respective frequencies.
     */
    private void calculate() {
        int[] intarray = makeArrayFromString(); 
        CharacterObject[] coArray = createCharacterObjectList(intarray);
        setCharFreq(coArray);
        setCharArray(coArray);
    }
    
    /**
     * This method takes a String as input and makes an array out of it. The
     * array has information about what the unique characters in the String are,
     * and what is their frequency in the String. 
     * @param s input String
     * @return int[] array with the abovementioned information
     */ 
    int[] makeArrayFromString() {      
        int[] array = new int[256]; 
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);      
            int index = (int) current;
            
            if (index >= 0 && index <= 255) {
                array[index]++;     
            }            
        }
        return array;
    } 
    
    /**
     * This method returns a char array.
     * @return char array
     */
    public char[] getCharArray() {
        return this.chars;
    }
    
    /**
     * This method returns an integer array.
     * @return int array
     */
    public int[] getCharFreq() {
        return this.frequencies;
    } 
    
    /**
     * Creates a char array. One unique character occupies one index in array. 
     * If there are for example 4 unique characters, the length of the array 
     * will be 4. Characters are in increasing order of frequency.
     * @param coArray Index means which character is in question, and value 
     * tells the frequency of the alphabet. 
     */
    private void setCharArray(CharacterObject[] coArray) {
        int n = coArray.length;
        this.chars = new char[n]; 
        for (int i = 0; i < n; i++) {
            chars[i] = coArray[i].getCharacter();
        }       
    }
    
    /**
     * Creates an integer array. Length of the array equals the amount of unique
     * characters. Value equals the frequency of one unique character in input. 
     * The values are in increasing order of frequency.
     * @param coArray 
     */
    private void setCharFreq(CharacterObject[] coArray) {
        int n = coArray.length;
        this.frequencies = new int[n]; 
        for (int i = 0; i < n; i++) {
            frequencies[i] = coArray[i].getFrequency();
        }          
    }
    
    /**
     * This method makes a list of CharacterObject instances where the objects
     * are in increasing order based on frequency. 
     * @param intArray
     * @return array of CharacterObject instances
     */
    CharacterObject[] createCharacterObjectList(int[] intArray) {
        int calculator = 0;
        for (int j = 32; j < intArray.length; j++) {
            if (intArray[j] > 0) { 
                calculator++;
            }
        }
        
        CharacterObject[] coArray = new CharacterObject[calculator];
        int k = 0;
        
        for (int i = 0; i < intArray.length; i++) { 
         
            if (i > 31 && intArray[i] > 0) { //visible ascii characters 
                char c = (char) (i);
                int j = intArray[i];
                CharacterObject co = new CharacterObject(c, j);
                coArray[k] = co; 
                k++;
            }
        }

        mergeSort(coArray);
        return coArray;
    }
    
    /**
     * Getter for input text.
     * @return String
     */
    public String getString() {
        return this.s;
    }
    
    /**
     * Algorithm that sorts an array of CharacterObject instances into 
     * increasing order of frequency.
     * @param a an array of CharacterObjects.
     */
    void mergeSort(CharacterObject[] a) {
        CharacterObject[] tmpArray = new CharacterObject[a.length];
        mergeSortRoutine(a, tmpArray, 0, a.length-1);
    }
    
    /**
     * Internal helper for method mergeSort. Makes recursive calls.
     * @param a an array of CharacterObjects.
     * @param tmpArray an array where the merged result is placed.
     * @param left the leftmost index of the subarray.
     * @param right the rightmost index of the subarray.
     */
    private void mergeSortRoutine(CharacterObject[] a, CharacterObject[] 
            tmpArray, int left, int right) {
        
        if (left < right) {
            int center = (left + right) / 2;
            mergeSortRoutine(a, tmpArray, left, center);
            mergeSortRoutine(a, tmpArray, center + 1, right);
            merge(a, tmpArray, left, center + 1, right);
        }
    }
    
    /**
     * Internal helper for method mergeSort and mergeSortRoutine. 
     * @param a an array of CharacterObjects
     * @param tmpArray an array where the merged result is placed.
     * @param leftPos
     * @param rightPos
     * @param rightEnt 
     */
    private void merge(CharacterObject[] a, CharacterObject[] tmpArray, 
            int leftPos, int rightPos, int rightEnd) {
        
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;
        
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (a[leftPos].compareTo(a[rightPos]) <= 0) {
                tmpArray[tmpPos++] = a[leftPos++];
            } else {
                tmpArray[tmpPos++] = a[rightPos++];
            }
        }
        
        while (leftPos <= leftEnd) {
            tmpArray[tmpPos++] = a[leftPos++];
        }
        
        while (rightPos <= rightEnd) {
            tmpArray[tmpPos++] = a[rightPos++];
        }
        
        for (int i = 0; i < numElements; i++, rightEnd--) {
            a[rightEnd] = tmpArray[rightEnd];
        }
    }
    
}
