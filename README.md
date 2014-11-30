[Instructions written for Mac OSX]

————————————————————  RUN ———————————————————— 
Compiling:
	From top directory (BT folder) use:
		javac -d ./bin/ ./src/charttraversal/*.java

Running: 
	From top directory (BT folder) use:
		cd bin
		java charttraversal.InputHandler /path/to/filename.txt “employee 1” “employee 2”


————————————————————  INFO ———————————————————— 

The main class for the program is InputHandler. This has the main function that takes input arguments.

The arguments required are:
1 - an input file (inc. path to it from the bin folder) containing a company structure in the format of example.txt 
2 - The name of a first employee
3 - The name of a second employee.

The program should output the shortest connection between the two in the company structure defined
in the input file. If there isn’t a connection, or either of the employees are not in the company, then other 
outputs will be given accordingly.


———————————————————— DEV ———————————————————— 

The project was developed in Eclipse Luna on Mac OSX. 
JDK 1.8 was used, but everything should be compatible with 1.7.
Project compiled and ran correctly in brief testing after using 
	javac -source 1.6 -target 1.6 -bootclasspath /path/to/jdk-1.6 -d ./bin/ ./src/charttraversal/*.java


————————————————— ASSUMPTIONS —————————————————

The input file must be of format in example.txt.

The input arguments must be in the order /path/to/file employee employee

If there are gaps in the hierarchy (i.e. an employee has a boss ID that does not correspond to any other 
employee's ID) then a new 'tree' is formed with this (/these) employee(s) as top level manager.
This also means that people from distinct trees have no line of communication, even if they used to
through the old (now missing) manager. 

It is assumed that if the same name is entered twice, then:
A) the user is trying to find the connection between two people with the same name
	(and this connection will be printed out, if two people with the same name but 
	different IDs exist)
B) the user is trying to find the connection between the same employee
	(and just the employee's name (and ID) will be printed out).
It is therefore assumed the user would NOT search for a connection between two people
with the same name, where the duplicate person does not exist. 
