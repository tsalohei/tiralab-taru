package app.tiralab.taru.datastructures;

import app.tiralab.taru.HuffmanComparator;
import app.tiralab.taru.HuffmanNode;

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
    
    /**
     * Adds a HuffmanNode instance to myMinHeap.
     * @param x HuffmanNode 
     */
    public void insert(HuffmanNode x) {
        if (this.currentSize == capacity) {
            System.out.println("error: heap full"); 
        }
        int hole = ++currentSize; 
        
        for (; hole > 1 && (hc.compare(x, this.array[hole / 2]) < 0) ; hole /= 2) {
            this.array[hole] = array[hole / 2]; 
        }
        this.array[hole] = x;
    }
    
    /**
     * Checks what is the smallest HuffmanNode in the MyMinHeap.
     * @return min HuffmanNode, or null if heap is empty
     */
    public HuffmanNode checkMin() {
        if (this.currentSize == 0) {
            return null;
        }
        return this.array[1];
    }
    
    /**
     * Checks if MyMinHeap is empty
     * @return true if heap is empty, false if not empty
     */
    public boolean isEmpty() {
        if (this.currentSize == 0) {
            return true;
        }
        return false;
    }
    
    /**
     * Deletes the smallest HuffmanNode from the MyMinHeap, and returns it.
     * @return smallest HuffmanNode, or null if MyMinHeap is empty.
     */
    public HuffmanNode deleteMin() {
        if (isEmpty()) {
            return null;
        }
        
        HuffmanNode minNode = checkMin(); 
        this.array[1] = this.array[this.currentSize--]; 
        percolateDown(1);
        
        return minNode;
    }
    
    /**
     * Internal method for percolating down in the heap. Used when deleting
     * the smallest HuffmanNode.
     * @param hole is the index where percolating begins
     */
    private void percolateDown(int hole) { 
        int child = 1; 
        HuffmanNode tmp = this.array[hole];
        
        for (; hole * 2 <= this.currentSize; hole = child) { 
            child = hole * 2; 
            
            if (child != this.currentSize && //checks if only 1 child
                    this.hc.compare(this.array[child + 1], array[child]) < 0) { 
                    child++; 
            }         
            if (this.hc.compare(array[child], tmp ) < 0) { 
                this.array[hole] = this.array[child];
            } else {
                break;
            }     
        }
        
        this.array[hole] = tmp;
    }
    
    public int getSize() {
        return this.currentSize;
    }
    
    /**
     * Returns the MyMinHeap as an array of HuffmanNodes
     * @return Array of HuffmanNodes 
     */
    public HuffmanNode[] getMyMinHeapAsArray() {
        return this.array;
    }  
}
