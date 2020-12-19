# Implementation document

## Structure of the program

The program has three layers. Package UI handles interaction with the user, package logic contains the logic of Huffman algorithm as well as file operations. Package data structures has own implementations of data structures needed for the Huffman algorithm (minimum heap and map). The data structures are designed to be used by classes in package Logic. This means that they don’t have all the possible methods that could be useful for a map, for example.

![packages](https://github.com/tsalohei/tiralab-taru/blob/main/documentation/images/packages_graph.png)

## Time and space complexity

The Huffman algorithm works in time O(n log n) when there are n characters in the file. This means that the size of the input gets smaller at each step. The required space complexity is O(n) with the exception of very small files (see empirical testing results). 

## Improvement “backlog”

The class Input has more complexity than would be needed. Refactoring that class would clarify the application. Package Logic has a lot of classes; these could be divided into smaller packages if the responsibilities of the classes would be clarified and made more independent. Providing support for other than text files would improve the application. Error handling could be unified and UI improved to be interactive.  

## Sources and references

The materials from course "Tietorakenteet ja algoritmit, 2019" have been used when writing own data structures: [link](https://tira-s19.mooc.fi/materiaali) to material.

Data structures and algorithm analysis in Java. Addison Wesley Longman. Mark Allen Weiss, 1999.
