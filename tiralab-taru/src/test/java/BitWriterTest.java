
import app.tiralab.taru.BitWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.After;
import org.junit.Test;

public class BitWriterTest {

    BitWriter bitWriter;
    File myFile;
    
    
    @After
    public void cleanup() throws IOException {
        Files.deleteIfExists(Paths.get("dummy1"));
    }
    
    @Test    
    public void foo() throws IOException {
        this.myFile = new File("dummy1");
        this.bitWriter = new BitWriter(myFile);
        
        this.bitWriter.writeBitsInString("101010101");
        this.bitWriter.stop();
    }
   
    
    /*
    @Test
    public void writeNumberOfCharactersTest() {
        
        ByteBuffer byteBuffer = ByteBuffer.allocate(4); //4 bytes for one Integer
        byteBuffer.putInt(2000000000);
        byte[] byteArray = byteBuffer.array();
        
        for (byte b : byteArray) {
            System.out.println(b);
        }
        //tulostuu arvolla 5: 0,0,0,5
        //249 = 0,0,0,-7 eli 257-7
        //256 = 0,0,1,0
        //257 = 0,0,1,1
        //4*256 = 1024 = 0,0,4,0
        //3000 = 0,0,11,-72 --> 11*256= 2816, 2816 + 184 = 3000
        //200 000 = 0,3,13,64 = 65536*3 + 256*13 + 64
        // 2000000000 = 119, 53, -108, 0 = 53*
        //max int 2 147 483 647: 127, -1,-1,-1
        
        //ELI
        //eka,       toka,  kolmas,  neljäs
        //4,3*10^9   65536  256      alle 256 luvut 
        //eli bytestä saadaan integer kertomalla ylläolevat luvut sillä kuinka monta
        //kappaletta niitä oli, ja neg. luku = kantaluku-negluku
        
    }
    
    //https://javadeveloperzone.com/java-basic/java-convert-int-to-byte-array/
    */
    /*
    @Test
    public void writeCharArrayTest() {
        char[] charArray = new char[]{'a','b','c'};
        ByteBuffer byteBuffer = ByteBuffer.allocate(2 * charArray.length); //2 bytes for 1 char
        for (char c : charArray) {
            byteBuffer.putChar(c);
        }
        byte[] byteArray = byteBuffer.array();
        
        for (byte b : byteArray) {
            System.out.println(b);  
        }
        //tulostus: 0, 97, 0, 98, 0, 99
        //  ascii:     a      b      c
    }        
    */
}
