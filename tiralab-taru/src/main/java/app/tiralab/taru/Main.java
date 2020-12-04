package app.tiralab.taru;


import java.io.IOException;
import java.util.Map;

public class Main { 
    public static void main(String[] args) throws IOException   {
        //if not run from command line
        String fileName = "book.txt";

        
        if (args.length == 0) {
            System.out.println("Welcome to compress your file with Huffman "
                    + "algorithm!");           
            System.out.println("You need to give the file name as argument.");
            System.exit(0);
        } else if (args.length == 1) {
            
            System.out.println("Welcome to compress your file with Huffman "
                    + "algorithm!");           
            System.out.println("The file you gave as argument will be compressed.");
            fileName = args[0];
        } else {
            System.out.println("Error. Too many arguments.");
            System.exit(1);
        }
        
        FileInput fileInput = new FileInput();
        
        Input input = new Input(fileInput.getFile(fileName));
        
        HuffmanTree tree = new HuffmanTree(input);
        
        HuffmanNode root = tree.create();
        
        Map<Character, String> map = tree.getPrefixes();
        
        Output output = new Output(map, input, fileName);
        
        output.process();
        
    }    
}
