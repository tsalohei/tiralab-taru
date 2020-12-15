package app.tiralab.taru;


import java.io.IOException;
import java.util.Map;

public class Main { 
    public static void main(String[] args) throws IOException   {
        
        
        //if not run from command line
        String fileName = "book.txt";
        
        
        if (args.length == 0) {
            System.out.println("Welcome to compress and decompress your file" 
             + "with Huffman algorithm!");           
            System.out.println("You need to give the file name as argument. See "
                    + "user instructions for further details.");
            System.exit(0);
        } else if (args.length == 1) {
            System.out.println("Welcome to compress and decompress your file "
                    + "with Huffman algorithm!");           
            System.out.println("The file you gave as argument will be "
                    + "compressed. A decompressed file is also made for you to"
                    + " see.");
            fileName = args[0];
            
            //JATKA TÄSTÄ 
            //IDEA: substring vikat 4 merkkiä: .huff vai .txt
            if (fileName.substring(fileName.length() - 4, fileName.length()-1)
                    .equals(".txt")) {
                compress(fileName);    
            }
            //lastIndexOf("."))
            //tiedostopäätteen perusteella. txt->compress, .huff--> decompress
            
            compress(fileName);
            decompress(fileName);
            
        } else {
            System.out.println("Error. Too many arguments. See user instructions"
                    + "for further details.");
            System.exit(1);
        }
        
        
        /*
        FileInput fileInput = new FileInput();
        
        InputText input = new InputText(fileInput.getFile(fileName));
        
        System.out.println("INPUT TEXT: " + input.getString());
        
        HuffmanTree tree = new HuffmanTree(input);
        
        tree.create();
        
        Output output = new Output(tree, input, fileName);
        
        output.process();
        */
        
        //testing Decompression
        
        /*
        CompressedInput compressedInput = new CompressedInput("book.huff");
        HuffmanTree treeCompressed = new HuffmanTree(compressedInput);
        treeCompressed.create();
        
        String prefixString = compressedInput.getPrefixString();
        System.out.println("PREFIXES " + prefixString);
        Decompress dc = new Decompress(prefixString, treeCompressed, "book.huff"); 
        String result = dc.process();
        System.out.println(result); 
        */
        
    }  
    
    public static void compress(String fileName) throws IOException {
        //aikavertailu alkaa
        
        FileInput fileInput = new FileInput();
        
        InputText input = new InputText(fileInput.getFile(fileName));
        
        System.out.println("Input text: " + input.getString());
        
        HuffmanTree tree = new HuffmanTree(input);
        
        tree.create();
        
        Output output = new Output(tree, input, fileName);
        
        output.process();
        
        //aikavertailu päättyy
        System.out.println("It took X seconds to compress your file");
        System.out.println("The file size was diminished by XX%");
        
    }
    
    public static void decompress(String filename) {
        
    }
}
