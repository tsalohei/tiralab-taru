package app.tiralab.taru;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


/**
 * This class gets an array of bytes and turns it into a prefix String 
 * ("1010011..").
 */
public class BitReader {

    private final byte[] fileContent;
    private int bitAmount;
    
    
    /**
     * Constructor for BitReader
     * @param fileContent byte array
     * @param bitAmount int
     */
    public BitReader(byte[] fileContent, int bitAmount) {
        this.fileContent = fileContent;
        this.bitAmount = bitAmount;
    }
    
    /**
     * Reads the bits in file (for example file.huff) and makes a String
     * corresponding to the bits (for example "101101.."). 
     * @return String that contains 1's and 0's
     */
    public String process() {
        
        StringBuilder builder = new StringBuilder();
        int bitCounter = 0;
        
        for (byte b : fileContent) {            
            for (int i = 7; i >= 0; i--) {
                builder.append(getBitAtPos(b, i));
                                
                if (bitCounter >= bitAmount) {
                    break;
                }                
                bitCounter++;
            }
        }
        
        return builder.toString();
    }
    
    /**
     * Get bit at specified position in byte as "0" or "1" (String). For example
     * position zero in bit 3 (i.e. 00000011) would be "1".
     * @param b byte
     * @param pos position in byte
     */
    String getBitAtPos(byte b, int pos) {
        int result = (b >> pos) & 1;
        return result == 0 ? "0" : "1";    
    }
    
    
}
