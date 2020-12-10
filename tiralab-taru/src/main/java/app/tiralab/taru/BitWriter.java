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
    
    private int oneByte;
    private int bitCalculator;
    private OutputStream stream;
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
    public void writeBitsInString(String s) throws IOException {
        System.out.println("WRITING STRING " + s);
        System.out.println("WRITING STRING " + s.length());
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
    
    //FIKSI TÄHÄN
    //if bits don't match 8
    public void stop() throws IOException {
        while (bitCalculator > 0 && bitCalculator <= 8) {
            writeBit(0);
        }
           
        
        System.out.println("BYTES WRITTEN (string)" + bytesWritten);
        System.out.println("BITS WRITTEN (string)" + bitsWritten);
    }
    
    public void closeStream() throws IOException {
        stream.close();
    }
    
    
    //NEW STUFF 8.12.2020
    
    //1. write the int (length of charArray)
    public void writeNumberOfCharacters(int n) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(4); //4 bytes for one Integer
        byteBuffer.putInt(n);
        byte[] byteArray = byteBuffer.array();
        
        stream.write(byteArray);
    }
    //4
    public void writeHowManyBits() throws IOException {
        System.out.println("WRITTEN BIT COUNTER (in BitWriter) " + this.bitsWritten);
        ByteBuffer byteBuffer = ByteBuffer.allocate(4); //4 bytes for one Integer
        //?????????
        byteBuffer.putInt(this.bitsWritten);
        byte[] byteArray = byteBuffer.array();
        
        stream.write(byteArray);
    }
    
    // 2 write huffmanTree.getCharArray() to file
    public void writeCharArray(char[] charArray) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(2 * charArray.length); //2 bytes for 1 char
        for (char c : charArray) {
            byteBuffer.putChar(c);
        }
        byte[] byteArray = byteBuffer.array();
        
        stream.write(byteArray);
    }
    //3 write freqArray to file
    public void writeFreqArray(int[] freqArray) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(4 * freqArray.length);
        for (int k : freqArray) {
            byteBuffer.putInt(k);
        }
        byte[] byteArray = byteBuffer.array();
        
        stream.write(byteArray);
    }
    
}
