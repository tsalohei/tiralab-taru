package app.tiralab.taru;

import java.util.Comparator;

/**
 *
 * @author taru
 */
public class HuffmanComparator implements Comparator<HuffmanNode> {
    
    //compares two Huffman nodes and returs a positive integer is node2 has a
    //smaller frequency compared with node1, a negative integer if node2 has 
    //larger frequency than node1, and 0 if frequencies are the same
    
    /**
     * Method compares two Huffman nodes. 
     * @param node1 HuffmanNode
     * @param node2 HuffmanNode
     * @return positive integer if node2 has a smaller frequency compared
     * with node1, a negative integer if node2 has  larger frequency than 
     * node1, and 0 if frequencies are the same
     */
    @Override
    public int compare(HuffmanNode node1, HuffmanNode node2) {
        return node1.getFreq() - node2.getFreq();
        
    }
}
