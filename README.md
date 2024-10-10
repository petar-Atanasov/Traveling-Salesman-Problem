# Traveling-Salesman-Problem
There used to be two programming course works for this module.  The first was the travelling salesman problem.  The idea is that you specify a number of cities, and have to find the shortest complete tour.   
1.	Make a 2x4 integer array.  You can fill it up with {{1, 1}, {5, 5}, {10,3}, {2,7}}..
2.	Print out the cities.
3.	Write a function that takes two city numbers and returns the distance (a float) between them.  
4.	Write a function that loops from the first city to the last and calculates the length of the path (0-1-2-3-0).  (This uses the distance function).
5.	Now, generate all of the permutation (You can do an exhaustive search to find the shortest path.  Note that paths in either direction and from any starting point have the same length.  So len(0-1-2-3-0) = len(0-3-2-1-0) = len(1-2-3-0-1)). A good way to do this is to write a recursive function that takes in an array of cities not visited, and a partial path.  When there are no cities left to visit, print out the path.
6.	Add a recording of the shortest current path to the permutation function.  You can use two global variables.
7.	If you’ve gotten this far, add in a function to read in the data (instead of the bracket method).  You can read the training and test files from the old course work.  If your program runs for a minute or less, what’s the largest problem you can solve?
