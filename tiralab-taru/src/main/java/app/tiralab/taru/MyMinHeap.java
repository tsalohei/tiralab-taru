package app.tiralab.taru;

/**
 * Minimum heap where one node is a Huffman Node
 */

public class MyMinHeap {
    
    private HuffmanComparator hc;
    private int capacity;
    private int currentSize;
    private HuffmanNode[] array;
    
    
    
    
    public MyMinHeap(int capacity, HuffmanComparator hc) {
        this.capacity = capacity;
        this.hc = hc;
        this.array = new HuffmanNode[capacity + 1]; //indexing starts from 1
        this.currentSize = 0; //current size of heap
    }
    
    //System.err.println and throws overflow also possible for full heap
    /**
     * Adds a HuffmanNode instance to myMinHeap.
     * @param x HuffmanNode 
     */
    public void insert(HuffmanNode x) {
        if (this.currentSize == capacity) {
            System.out.println("error: heap full"); 
        }
        int hole = ++currentSize; 
        
        for ( ; hole > 1 && (hc.compare(x, this.array[hole / 2]) < 0) ; hole /= 2) {
            this.array[hole] = array[hole / 2]; 
        }
        this.array[hole] = x;
    }
    
    public HuffmanNode deleteMin() {
        //TODO
        return null;
    }
    
    
    public HuffmanNode checkMin() {
        if (this.currentSize == 0) {
            return null;
        }
        return this.array[1];
    }
    
    /**
     * Returns the MyMinHeap as an array of HuffmanNodes
     * @return Array of HuffmanNodes 
     */
    public HuffmanNode[] getMyMinHeapAsArray() {
        return this.array;
    }
    
  
    
    
}
