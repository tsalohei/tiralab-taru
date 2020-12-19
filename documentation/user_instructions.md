# User instructions

This application is a command line application for compressing .txt-files. User can clone the project in entirety, or use the released jar file. When user compresses a .txt file (file.txt), the application creates a compressed version of it (file.huff). User can also decompress the .huff-file, resulting in a file with extension .dc (file.dc).

If user wants to clone the entire project the following command needs to be run first (skip this when using jar file): 

	mvn package

To execute the program, run this command followed by the name of your file as argument (your-file.txt or your-file.huff, and this file needs to be placed in the same directory):

	java -jar target/tiralab-taru-1.0-SNAPSHOT.jar your-file.txt 

Now the file is compressed (or decompressed), and can be found from the same catalogue. The application will notify the user if there is a problem with the given command (if there is for example too many arguments).

