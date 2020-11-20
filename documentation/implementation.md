# Implementation document

The application does not have a user interface (at least yet). The user is expected to place the file to be compressed to the same folder as where the project is located. Different classes have different responsibilities:
  * Class FileInput is responsible for turning the contents of the file given by the user to a String.
  * Class input handles the String input; it processes information about the String so that the information is available in the correct format to the HuffmanTree.
  * Class CharacterObject is a helper class to Input class
  * Class HuffmanTree gets an instance of Input in the constructor parameter. This class builds a tree structure, and returns the root node for the tree.
  * Class Output is responsible for saving the coded input into a file. 

