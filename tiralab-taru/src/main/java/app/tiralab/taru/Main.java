package app.tiralab.taru;


import java.io.IOException;
import java.util.Map;

public class Main { 
    public static void main(String[] args) throws IOException   {
        
        
        
        
        
        //if not run from command line
        String fileName = "book.txt";

        /*
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
        */
        FileInput fileInput = new FileInput();
        
        InputText input = new InputText(fileInput.getFile(fileName));
        System.out.println("INPUT TEXT " + input.getString());
        
        HuffmanTree tree = new HuffmanTree(input);
        
        HuffmanNode root = tree.create();
        
        //write root to file?l
        
        //delete this map + loop
        Map<Character, String> debugMap = tree.getPrefixes();
        for (Map.Entry<Character,String> entry : debugMap.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
        
        Output output = new Output(tree, input, fileName);
        System.out.println("ORG PREFIX " + output.createPrefixString());
        System.out.println("ORG PREFIX " + output.createPrefixString().length());
        
        output.process();
        
        
        //testing Decompression
        
        
        CompressedInput compressedInput = new CompressedInput("book.huff");
        HuffmanTree treeCompressed = new HuffmanTree(compressedInput);
        treeCompressed.create();
        
        String prefixString = compressedInput.getPrefixString();
        System.out.println("PREFIXES " + prefixString);
        Decompress dc = new Decompress(prefixString, treeCompressed); //tree: haetaan getRoot
        String result = dc.process();
        System.out.println(result); 
        
        /*
        BitReader bitreader = new BitReader("book.huff");
        
        String s1 = output.createPrefixString();
        System.out.println(s1);
        
        String s2 = bitreader.process();
        System.out.println(s2);
                
        Decompress dc = new Decompress(s2, tree); //tree: haetaan getRoot
        String result = dc.process();
        System.out.println(result);
        */
        
    }    
}
