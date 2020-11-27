package app.tiralab.taru;

import java.util.Map;

public class Main { 
    public static void main(String[] args)  {
         
        String fileName = "book.txt";
        
        // if run from command line with argument
        if (args.length > 1) {
            fileName = args[1];
        }
        
        FileInput fileInput = new FileInput();
        
        Input input = new Input(fileInput.getFile(fileName));
                
        HuffmanTree tree = new HuffmanTree(input);
              
        HuffmanNode root = tree.create();
        
        Map<Character, String> map = tree.getPrefixes();
        
        Output output = new Output(map, input);
        
        output.process();
        
    }    
}
