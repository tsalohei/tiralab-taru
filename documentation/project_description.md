# Project description

The purpose of this project is to compare two lossless data compression algorithms, the Huffman algorithm and the LZ77 algorithm. This project is coded using Java.

I chose this topic because compressing data has so many practical applications. For example in a digital marketplace, when a user downloads an image of some item s/he is planning to sell, the system often needs to compress the image to a smaller size.

## Algorithms and data structures
The Huffman and LZ77 algorithms are implemented without Java’s own data structures. Hence, all the necessary data structures will be coded (for example a priority queue for Huffman).

## Time complexity
The time complexity for Huffman is O(n log n) (reference 1) and the time complexity of LZ77 is O(M) for a text that consists of M characters (reference 2).

## Input and output
At least 10 different text files will be used as input in this comparison of Huffman and LZ77 algorithms. The aim is that each output file will be around 40-60% smaller compared with the input file. 

The documentation, code and comments are written in English. This project is a part of my degree "tietojenkäsittelytieteen kandidaatti (TKT)".

## References
1. <https://en.wikipedia.org/wiki/Huffman_coding> 
2. <https://en.wikipedia.org/wiki/LZ77_and_LZ78>
3. <https://en.wikipedia.org/wiki/Lossless_compression>



