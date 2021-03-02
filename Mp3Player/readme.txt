Michael Skipper 
N01162792 

To compile and run List.java and Mp3Player.java, the user must import the javazoom mp3 decoder, which is imported in the following way: 

import javazoom.jl.player.*; // This is the MP3 decoder and player
import java.io.FileInputStream; // This allows us to read files from disk
To compile (and run) the jar files associated with the MP3 player, you can modify the classpath, i.e.
javac -cp jl1.0.1.jar Mp3Player.java
java -cp ./jl1.0.1.jar:. Mp3Player
You can safely ignore the compiler warning that states Mp3Player.java uses or overrides a deprecated API.

Or, 

First, create a new Java Project in your integrated development environment (IDE). Add the List.java and Mp3Player.java classes and make sure all the songs and the jl1.0.1 file are in your project. To do this, first download all the .mp3 song files and the jl1.0.1.jar file, then hold the Control key and click on the project, then click on Properties at the bottom. Select "Java Build Path" and click on the "Libraries" menu, then select "Add External JARs..." then "Apply and Close" 

This should allow the program to compile and run. The output should be as depicted in the images, with a GUI that toggles between the songs. 