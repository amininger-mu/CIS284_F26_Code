# Homework 2 - Loops and Arrays

**Course:** CIS 284 - Computer Programming 2 - Fall 2026 \
**Instructor:** Dr. Aaron Mininger \

## Submission Instructions

**Due Date:** September 15 at 11:59pm

Upload the completed `Stats.java` file to Canvas. **Make sure it has your name at the top**.

You will be editing and extending the same Java file throughout the following parts. Make sure each part is working before continuing on to the next.

<br>

For 2 bonus points, answer the following questions (using the text box on Canvas):
1. Give an estimate of how much time you spent on this assignment.
2. How difficult did you find this assignment?

Your responses will be helpful feedback for refining these assignments in future courses. 

---
## Assignment Overview

In this assignment, we are going to build up a stats program that can take a list of numbers and compute various statistics. 

## Grading Information

The homework will be graded according to the following rubric. Note that the bulk of credit is from completing parts 1 and 2. _If you can't complete everything, it is better to submit partial work than miss the deadline._

| Points | Name | Description |
|---|---|---|
| 30 | Effort | Does the program compile and run? Was a reasonable attempt made? |
| 5 | Style | Is the code formatted well? Is it readable? Are variables named well? |
| 20 | Part 1 | Does your code create the array of doubles using command line arguments? |
| 20 | Part 2 | Does your program implement a command loop with commands print, help, quit, and other? |
| 15 | Part 3 | Does your program implement commands max, min, and mean? |
| 10 | Part 4 | Does your program implement the add command? |

Note: Your output does not need to match my examples word for word. Feel free to add additional messages or personalize it, as long as it satisfies the requirements.

<!-- pb -->

## 1. Reading Numbers

Write a java program called `Stats.java` (use this name specifically!) that does the following:
- Accepts 1 or more numbers as command line arguments
- Creates an array of doubles and copies the command line arguments into it (converting from String to double). 
- If no command line arguments were given, print an error message and quit the program. 
- Otherwise, print a message saying 'Loaded N numbers'

### Part 1 Example:

```
java Stats.java 4 5.5 10.3
---
Loaded 3 numbers
```

```
java Stats.java
---
Error: no numbers given
```

<!-- pb -->

## 2. Command Line Loop

In this step, you will modify your program so it becomes an interactive command line tool. Your program will ask the user for a command, then do a certain action or calculation based on the comand. If they type 'quit', the program will exit. 


**Directions:** Modify your `Stats.java` program so it contains a `while(true)` loop. Inside the loop, print a message asking for the user to enter a command, then read their command using `Scanner`. 

Depending on what command they typed, your program will do the following:

- `help` - Print a help message that lists the possible commands
- `quit` - Exits the program
- `print` - Print the numbers in the array, in columns of 5. 
_Requirement: Use printf to print the numbers using 3 decimal places and a width of 10_.
- _otherwise_ - Print a message saying the command was unrecognized

### Part 2 Example:

```
java Stats.java 4 5.5 10.3 1.4 5.3 9.9 2.1
Loaded 7 numbers

Please enter a command: 
print
    4.000    5.500   10.300    1.400    5.300
    9.900    2.100

Please enter a command:
jump
The command 'jump' was unrecognized, enter 'help' to see commands

Please enter a command:
help
Valid commands are: print, help, quit

Please enter a command:
quit
Goodbye!
```

<!-- pb -->

## 3. Stats Functions

Extend your program from part 2 by adding support for 3 new commands:
- `max`: prints the maximum value in the array (Hint: we covered it in class)
- `min`: prints the minimum value in the array
- `mean`: prints the arithmetic mean (sum of values / length)

Note: For each of these, print the number to 3 decimal places using printf.

### Part 3 Example:

```
java Stats.java 4 5.5 10.3 1.4 5.3 9.9 2.1
Loaded 7 numbers

Please enter a command: 
max
The maximum value is 10.300

Please enter a command:
min
The minimum value is 1.400

Please enter a command:
mean
The mean is 5.500

Please enter a command:
quit
Goodbye!
```

**Note:** make sure to update your help message as well!

<!-- pb -->

## 4. Adding Numbers

Extend your program again by implementing an `add` command. 

If the person types `add`, then ask them to enter a number
and add it to the end of your array. 

But remember! In Java arrays are a fixed size. So you need to do the following:
- Create a new array with a length equal to the old length + 1
- Copy over the old numbers into the new array
- Put the new number at the end


### Part 4 Example.

```
java Stats.java 1 2 3 
Loaded 3 numbers

Please enter a command: 
print
   1.000   2.000   3.000

Please enter a command:
add
Enter a number to add: 8
There are now 4 numbers

Please enter a command:
print
   1.000   2.000   3.000    8.000
```

<!-- pb -->

## 5. Extra Challenge (Optional)

If you want to do an additional challenge (for extra credit), do the following:

Add support for a `delete` command as follows:
1. Print the list of numbers, one per line, with the index in front
2. Ask the user to enter an index.
3. If the index is valid, then remove the number at that index (create a new array of size length-1, and copy over all but the indicated number).
4. Print the new length of the array

### Part 5 Example:

```
java Stats.java 10 5 8.5
Loaded 3 numbers

Please enter a command: 
delete
0: 10.000
1: 5.000
2: 8.500

Which number do you want to delete? 1
There are now 2 numbers

Please enter a command: 
print
  10.000   8.500
```

