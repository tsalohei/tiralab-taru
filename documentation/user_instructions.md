# User instructions

First clone the project. Then navigate to the directory, place the file you want to compress there and run:

	mvn package

After this, run this command followed by the name of your file as argument (your-file.txt in example):

	java -jar target/tiralab-taru-1.0-SNAPSHOT.jar your-file.txt 

Now your file is compressed, and can be found from the same catalogue. The name is same as for your original file, but the file ends .huff (for example your-file.huff).

