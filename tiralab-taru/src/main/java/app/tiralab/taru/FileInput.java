package app.tiralab.taru;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class FileInput is responsible for turning the contents of the file given by 
 * the user to a String.
 */
public class FileInput {
    
    public String getFile(String filename) {      
        // TODO use StringBuilder instead of , inputString = inputString + data;
        
        String inputString = "";    
        try {
            File myFileObj = new File(filename);
            Scanner myScanner = new Scanner(myFileObj);
            while (myScanner.hasNextLine()) {
                String data = myScanner.nextLine();
                inputString = inputString + data;
            }
            myScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
        
        return inputString;
    }
}
