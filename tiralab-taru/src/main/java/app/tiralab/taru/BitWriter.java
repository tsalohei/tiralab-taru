package app.tiralab.taru;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;


/**
 * This class is responsible of saving the coded String input (for example 
 * "1001101...") to file as bits.
 */
public class BitWriter {
    
    private final OutputStream stream;
    private int oneByte;
    private int bitCalculator;    
    private int bytesWritten = 0;
    private int bitsWritten = 0;
    
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
     * Writes the coded String input (for example "100111..") to file as bits.
     * @param s String of 1's and 0's 
     * @throws IOException if 
     */
    void writeBitsInString(String s) throws IOException {
        for (int i = 0; i < s.length(); i++) {
            char bit = s.charAt(i);
            
            if (bit == '1') {                
                writeBit(1);
            
            } else {
                writeBit(0); 
            }
        }               
    }
    /**
     * Writes a bit (represented by an Integer 0 or 1) to file.
     * @param bit
     * @throws IOException if writing to file fails
     */
    private void writeBit(int bit) throws IOException {
        if (bit != 0 && bit != 1) {
            throw new IllegalArgumentException("Can write only 0s and 1s to file");
        } else {
            
            this.oneByte = (this.oneByte << 1) | bit;
            this.bitCalculator++;
            this.bitsWritten++;
            
            if (bitCalculator == 8) {                
                bytesWritten++;
                
                this.stream.write(oneByte); 
                this.oneByte = 0;
                this.bitCalculator = 0;
            }
        }
    }
    
    /**
     * Fills in (the last) byte with zeros if it has less than 8 bits.
     * @throws IOException if writing to file fails 
     */
    void stop() throws IOException {
        while (bitCalculator > 0 && bitCalculator <= 8) {
            writeBit(0);
        }
    
    }
    
    /**
     * Closes the writing operation. 
     * @throws IOException 
     */
    void closeStream() throws IOException {
        stream.close();
    }
 
    /**
     * Writes to file the number of unique characters. 
     * @param n number of unique characters
     * @throws IOException if writing to file fails.
     */
    void writeNumberOfCharacters(int n) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(4); //4 bytes for one Integer
        byteBuffer.putInt(n);
        byte[] byteArray = byteBuffer.array();
        
        stream.write(byteArray);
    }
    
    /**
     * Writes to file the char array used by HuffmanTree class.
     * @param charArray of unique characters
     * @throws IOException if writing to file fails.
     */
    void writeCharArray(char[] charArray) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(2 * charArray.length); //2 bytes for 1 char
        for (char c : charArray) {
            byteBuffer.putChar(c);
        }
        byte[] byteArray = byteBuffer.array();
        
        stream.write(byteArray);
    }
    
    /**
     * Writes to file the int array used by HuffmanTree.
     * @param freqArray frequencies of unique characters
     * @throws IOException 
     */
    void writeFreqArray(int[] freqArray) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(4 * freqArray.length);
        for (int k : freqArray) {
            byteBuffer.putInt(k);
        }
        byte[] byteArray = byteBuffer.array();
        
        stream.write(byteArray);
    }
    
    /**
     * Writes how many "real" bits there are in the prefix code, excluding 
     * possible zeros from end.
     * @throws IOException if writing to file fails. 
     */
    void writeHowManyBits() throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(4); //4 bytes for one Integer
        
        byteBuffer.putInt(this.bitsWritten);
        byte[] byteArray = byteBuffer.array();
        
        stream.write(byteArray);
    }
}
