package app.tiralab.taru.ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class FileInput is responsible for turning the contents of the file given by 
 * the user to a String.
 */
class FileInput {
    
    /**
     * Returns the content of specified file as String.
     * @param filename
     * @return String
     */
    String getFile(String filename) {              
        StringBuilder builder = new StringBuilder();
        try {
            File myFileObj = new File(filename);
            Scanner myScanner = new Scanner(myFileObj);
            while (myScanner.hasNextLine()) {
                String data = myScanner.nextLine();                
                builder.append(data);
            }
            myScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File with this name was not found!");
        }
        
        return builder.toString();
    }
}
