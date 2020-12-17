package app.tiralab.taru;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;

/**
 * Class CompressedInput gets as parameter the name of a compressed file 
 * (for example "book.huff") and re-creates variables that are needed to 
 * decompress the file again to readable format. 
 */

public class CompressedInput implements Input {
    
    private final int charAmount;
    private final int bitAmount;
    private final char[] chars;
    private final int[] frequencies;
    private final byte[] prefixStringBytes;
    
    /**
     * Constructor for CompressedInput. Constructor takes care of the getting
     * necessary variables from the file.
     * @param fileName is used to get the File object
     * @throws IOException 
     */
    public CompressedInput(String fileName) throws IOException {
        File file = new File(fileName);
        byte[] fileContent = Files.readAllBytes(file.toPath());
        
        ByteBuffer bb = ByteBuffer.wrap(fileContent);        
        
        this.charAmount = bb.getInt();
        
        this.chars = new char[charAmount];
        for (int i = 0; i < charAmount; i++) {
            chars[i] = bb.getChar();
        }
        
        this.frequencies = new int[charAmount];
        for (int i = 0; i < charAmount; i++) {
            frequencies[i] = bb.getInt();
        }
        
        this.prefixStringBytes = new byte[bb.remaining() - 4];
        bb.get(this.prefixStringBytes);
        
        this.bitAmount = bb.getInt();
    }
      
    /**
     * Getter for char array where each character represents a unique character
     * @return char array
     */
    @Override
    public char[] getCharArray() {
        return this.chars;
    }

    /**
     * Getter for frequency array (frequencies of the unique characters)
     * @return 
     */
    @Override
    public int[] getCharFreq() {
        //return this.getCharFreq();
        return this.frequencies;
    }
    
    /**
     * Getter for the prefix String (for example "10111011...")
     * @return String prefix String
     */
    public String getPrefixString() {
        BitReader bitReader = new BitReader(this.prefixStringBytes, this.bitAmount);
        return bitReader.process();        
    }
    
}
