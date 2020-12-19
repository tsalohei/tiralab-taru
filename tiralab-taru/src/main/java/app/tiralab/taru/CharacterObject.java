package app.tiralab.taru;

/**
 * This class represents an object that is used when sorting characters based
 * on their frequencies.
 */
public class CharacterObject implements Comparable<CharacterObject> {

    private final char character;
    private final int frequency;
    
    /**
     * Constructor for CharacterObject.
     * @param character char
     * @param frequency int
     */
    public CharacterObject(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
    }
    
    /**
     * Character with smaller frequency comes first when ordering.
     * @param o CharacterObject
     * @return int
     */
    @Override
    public int compareTo(CharacterObject o) {
        return this.frequency - o.frequency;
    }
    
    /**
     * Getter for character
     * @return char
     */
    public char getCharacter() {
        return this.character;
    }   
    
    /**
     * Getter for frequency
     * @return int
     */
    public int getFrequency() {
        return this.frequency;
    }
}
