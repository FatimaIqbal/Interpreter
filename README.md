Author: Fatima Iqbal
Reg.No: 01137

*****  Interpreter for executing a list of declarative commands in java  *****

Its a simple program which reads a file, having a declarative language which contains variable declarations and simple arithematic operations.These commands are then 
executed and the result is displayed.Unit tests are used to check the correctness of the program.


Java classes in this project are:
-unit_test
-interpreter

There is one sample file, that is:
-file.txt

How to run code?
For running this project follow the following instructions:
-Import this project in eclipse
-Change the path of the sample file in the main of the unit_test class as i've hardcoded the path of the file in my code in the unit tests
-Save the changes
-Compile ad execute the code

Format of sample file to be used
My code works for the sample files having the following format:
-	Let x = 0;
Let y = 0;
y = 1 + x;
print y;

This is so because while reading the file in unit_test class i have tokennized on the basis of tab spaces and empty lines for getting the entries and for retriving a matrix correctly.
 
Whats in unit_test class?
-Basically i have created my unit test in this class (in main)
-I'm also reading the file in this class

Whats in interpreter class?
-In this class i have some functions which implemented the functionality of the program: 
-variables_values
-operations


variables_values function:
-In this function i'm declaring variables and assigning values to them according to the sample file.

operations function:
-In this function i'm getting the operations that are to be performed on a variable.
