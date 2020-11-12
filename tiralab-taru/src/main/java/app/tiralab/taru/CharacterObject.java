package app.tiralab.taru;

public class CharacterObject implements Comparable<CharacterObject> {

    private char character;
    private int frequency;
    
    public CharacterObject(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
    }
    
    @Override
    public int compareTo(CharacterObject o) {
        return this.frequency - o.frequency;
    }
    
    
    public char getCharacter() {
        return this.character;
    }   
    
    public int getFrequency() {
        return this.frequency;
    }
}
