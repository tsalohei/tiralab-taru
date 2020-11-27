package app.tiralab.taru;

import java.util.Map;

public class Main { 
    public static void main(String[] args)  {
        
        MyMinHeap heap = new MyMinHeap(11, new HuffmanComparator());
        
        
heap.insert(new HuffmanNode('d', 4));
        heap.insert(new HuffmanNode('f', 6));
        heap.insert(new HuffmanNode('i', 9));
        heap.insert(new HuffmanNode('b', 2));
        heap.insert(new HuffmanNode('c', 3));      
        /*heap.insert(new HuffmanNode('e', 5));
        heap.insert(new HuffmanNode('g', 7));
        heap.insert(new HuffmanNode('h', 8));        
        heap.insert(new HuffmanNode('j', 10));
        heap.insert(new HuffmanNode('k', 11));
        heap.insert(new HuffmanNode('a', 1));
        */
        HuffmanNode[] array = heap.getMyMinHeapAsArray();
      
        System.out.println(array[1].getFreq());
        System.out.println(array[2].getFreq());
        System.out.println(array[3].getFreq());
        System.out.println(array[4].getFreq());
        System.out.println(array[5].getFreq()); 
        //heap.insert(new HuffmanNode('d', 4));
        /*
        heap.insert(new HuffmanNode('f', 6));
        heap.insert(new HuffmanNode('i', 9));
        heap.insert(new HuffmanNode('b', 3));
        heap.insert(new HuffmanNode('c', 1));      
        heap.insert(new HuffmanNode('e', 5));
        heap.insert(new HuffmanNode('g', 7));
        heap.insert(new HuffmanNode('h', 8));        
        heap.insert(new HuffmanNode('j', 10));
        heap.insert(new HuffmanNode('k', 11));
        heap.insert(new HuffmanNode('a', 2));
        
        
        HuffmanNode[] array = heap.getMyMinHeapAsArray();
        
        System.out.println(array[1].getFreq());
        System.out.println(array[2].getFreq());
        System.out.println(array[3].getFreq());
        System.out.println(array[4].getFreq());
        System.out.println(array[5].getFreq()); 
        System.out.println(array[6].getFreq());
        System.out.println(array[7].getFreq());
        System.out.println(array[8].getFreq());
        System.out.println(array[9].getFreq());
        System.out.println(array[10].getFreq());
        System.out.println(array[11].getFreq());
        */
        System.out.println("****");
        
        System.out.println(heap.checkMin());
        
        /*      
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
        */
    }    
}
