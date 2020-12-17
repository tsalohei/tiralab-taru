package app.tiralab.taru;


import app.tiralab.taru.BitReader;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

public class BitReaderTest {
    
    
    
    @Test
    public void getBitAtPosTest() throws IOException {
        byte[] dummy = new byte[] {};
        BitReader bitreader = new BitReader(dummy, 0);
        byte b = 3; // 00000011
        assertEquals("1", bitreader.getBitAtPos(b, 0));
        assertEquals("1", bitreader.getBitAtPos(b, 1));
        assertEquals("0", bitreader.getBitAtPos(b, 2));
    }
    
}
