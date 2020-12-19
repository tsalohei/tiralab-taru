# User instructions

This application is a command line application for compressing .txt-files. User should download the [released jar file](https://github.com/tsalohei/tiralab-taru/releases/tag/release2). When user compresses a .txt file (file.txt), the application creates a compressed version of it (file.huff). User can also decompress the .huff-file, resulting in a file with extension .dc (file.dc).

To execute the program, run this command followed by the name of your file as argument (your-file.txt or your-file.huff, and this file needs to be placed in the same directory):

	java -jar tiralab-taru-1.0-SNAPSHOT.jar your-file.txt 

Now the file is compressed (or decompressed), and can be found from the same catalogue. The application will notify the user if there is a problem with the given command (if there is for example too many arguments).

