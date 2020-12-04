package app.tiralab.taru;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


/**
 * This class is responsible of saving the coded String input (1's and 0's)
 * to file as bits.
 */
public class BitWriter {
    
    private int oneByte;
    private int bitCalculator;
    private OutputStream stream;
    
    /**
     * Constructor for BitWriter
     * @param myFileObj File where the bits are written to
     * @throws FileNotFoundException If file is not found
     */
    public BitWriter(File myFileObj) throws FileNotFoundException {
        this.oneByte = 0;
        this.bitCalculator = 0;
        this.stream = new BufferedOutputStream(new FileOutputStream(myFileObj));
    }
    
    /**
     * Writes the bits in a String to file.
     * @param s String of 1's and 0's 
     * @throws IOException if 
     */
    public void writeBitsInString(String s) throws IOException {
        for (int i = 0; i < s.length(); i++) {
            char bit = s.charAt(i);
            
            if (bit == '1') {                
                writeBit(1);
            
            } else {
                writeBit(0);
            }
        }
    }
    
    private void writeBit(int bit) throws IOException {
        if (bit != 0 && bit != 1) {
            throw new IllegalArgumentException("Can write only 0s and 1s to file");
        } else {
            
            this.oneByte = (this.oneByte << 1) | bit;
            this.bitCalculator++;
            
            if (bitCalculator == 8) {
                
                this.stream.write(oneByte); 
                this.oneByte = 0;
                this.bitCalculator = 0;
            }
        }
    }
    
    //if String is not divisible with 8
    public void stop() throws IOException {
        while (bitCalculator > 0 && bitCalculator <= 8) {
            writeBit(0);
        }
   
        stream.close();
    }
    
}
