[Instructions written for Mac OSX]

————————————————————  RUN —————————— —————————— 
Compiling:
	From top directory (BT folder) use:
		javac -d ./bin/ ./src/charttraversal/*.java

Running: 
	From top directory (BT folder) use:
		cd bin
		java charttraversal.InputHandler {/path/to/filename.txt} {“employee 1”} {“employee 2”}


————————————————————  INFO —————————— —————————— 

The main class for the program is InputHandler. This has the main function that takes input arguments.

The arguments required are:
1 - an input file (inc. path to it) containing a company structure in the format of example.txt 
2 - The name of a first employee
3 - The name of a second employee.

The program should output the shortest connection between the two in the company structure defined
in the input file. If there isn’t a connection, or either of the employees are not in the company, then other 
outputs will be given accordingly.