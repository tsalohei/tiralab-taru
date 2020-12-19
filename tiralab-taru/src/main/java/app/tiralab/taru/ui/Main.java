package app.tiralab.taru.ui;


import app.tiralab.taru.CompressedInput;
import app.tiralab.taru.Decompress;
import app.tiralab.taru.HuffmanTree;
import app.tiralab.taru.InputText;
import app.tiralab.taru.Output;
import java.io.File;
import java.io.IOException;


public class Main { 
    public static void main(String[] args) throws IOException   {
        
        if (args.length == 0) {
            System.out.println("***Welcome to compress and decompress your file" 
                + "with Huffman algorithm!***");           
            System.out.println("Give the file name as argument. A file ending"
                + " in .txt will be compressed, and a file ending in .huff"
                + " will be decompressed.");
            System.exit(0);
        } else if (args.length == 1) {
            System.out.println("***Welcome to compress and decompress your file "
                    + "with Huffman algorithm!***");           
            System.out.println("A file ending in .txt will be compressed. A file"
                    + " ending in .huff will be decompressed. ");
            String fileName = args[0];            
            
            if (fileIsValid(fileName) == false) {
                System.out.println("You can only compress .txt files and "
                        + "decompress .huff files (that you also have placed to"
                        + " the same folder as this application).");
                System.exit(1);
            }
            
            if (fileName.endsWith(".txt")) {
                compress(fileName);    
            } else if (fileName.endsWith(".huff")) {
                decompress(fileName);
            } else {
                System.out.println("You need to give a file that ends in .txt"
                        + " or .huff.");
            }                        
        } else {
            System.out.println("Error. Too many arguments. See user instructions"
                    + " for further details.");
            System.exit(1);
        }
        
    }  
    
    public static void compress(String fileName) throws IOException {
        
        long start = System.nanoTime();

        FileInput fileInput = new FileInput();
        InputText input = new InputText(fileInput.getFile(fileName));
        HuffmanTree tree = new HuffmanTree(input);
        tree.create();
        Output output = new Output(tree, input, fileName);
        boolean newCompressedFileCreated = output.process();

        long finish = System.nanoTime();

        if (newCompressedFileCreated == true) {
            String filenameWithoutTxt = fileName.substring(0, fileName
                    .lastIndexOf("."));
            String resultFilename = filenameWithoutTxt + ".huff";
            printResults(start, finish, fileName, resultFilename);              
        }
    }
    
    
    public static void decompress(String filename) throws IOException {
        
        long start = System.nanoTime();
        
        CompressedInput compressedInput = new CompressedInput(filename);
        HuffmanTree treeCompressed = new HuffmanTree(compressedInput);
        treeCompressed.create();     
        String prefixString = compressedInput.getPrefixString();     
        Decompress dc = new Decompress(prefixString, treeCompressed, filename); 
        boolean newDecompressedFileCreated = dc.process();
        
        long finish = System.nanoTime();
        
        if (newDecompressedFileCreated == true) {
            String filename2 = filename.substring(0, filename.lastIndexOf(".")) + ".dc";
            printResults(start, finish, filename, filename2);
        }  
    }
    
    public static boolean fileIsValid(String fileName) {
        if ((fileName.endsWith(".txt") || fileName.endsWith(".huff"))) {
            File file = new File(fileName);            
            return file.exists();
        }
        
        return false;        
    }
    
    public static void printResults(long start, long finish, String initialFile, 
            String resultingFile) {
        File initial = new File(initialFile);
        File result = new File(resultingFile);
        System.out.println("Size of initial file: " + initial.length() + " bytes"); 
        System.out.println("Size of resulting file: " + result.length() + " bytes");
        long percentage = Math.round(result.length() * 10.0 / initial.length() * 10.0);
        System.out.println("Resulting file is " + percentage + " % of initial "
                + "file size.");
        System.out.println("It took " + ((finish - start) / 1e9) + " s to "
                    + "process your file.");
    }
}
