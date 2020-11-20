# Weekly report 4

On Tuesday 17.11. I changed the code so that it is possible to have other characters than letters in the input too. I refactored existing tests in class HuffmanTreeTest, and added two tests to the class.

On Thursday 19.11. I implemented reading from and reading to a file, wrote tests for Output class, and started writing my own ArrayList implementation. On Friday 20.11. I continued writing documentation, and created three different sized versions of Tolkien’s Hobbit book so that I could start testing the performance of the algorithm with those.

Unclear things in my mind at the moment:
  * In order to be able to decompress the compressed file I would need to add header information to the output file. I think I will first implement my own data structures before proceeding with this.
  * Bytes vs. bits: now the file size actually increases when each character gets a code that is saved as characters (e.g. ‘A’ is ‘1001’). So saving 8 bits requires in fact 4*8 bits. I guess there are some existing libraries in Java to handle this - can these be used? Or is implementing own data structures necessary here too?

