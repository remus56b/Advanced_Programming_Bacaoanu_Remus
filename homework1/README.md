#homework 1

###	The main method is responsible for reading the command line argument, validating it, measuring the elapsed time, and printing the results.
Instead of generating and printing the Latin square itself, it calls three helper methods to do so.
###	The generateLatinSquare method takes an integer n as input and returns a 2D array of size n x n that represents the Latin square. 
It generates the Latin square by assigning each element in the matrix the value (i + j) % n + 1, where i and j are the row and column indices, respectively.
###	The printRowStrings method takes a 2D array of integers matrix as input and prints the string representation of each row of the matrix, 
using StringBuilder for efficient concatenation.
###	The printColumnStrings method takes a 2D array of integers matrix as input and prints the string representation of each column of the matrix,
using StringBuilder for efficient concatenation.
