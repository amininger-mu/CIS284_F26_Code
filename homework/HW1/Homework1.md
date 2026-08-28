# Homework 1 - Intro to Java

**Course:** CIS 284 - Computer Programming 2 - Fall 2026 \
**Instructor:** Dr. Aaron Mininger \
**Institution:** Messiah University

## Submission Instructions

**Due Date:** September 1 at 11:59pm

Complete all the work in this folder, then zip the folder and upload to Canvas.

**You must put your name on every file in the submission**

Note: You may not use any AI assistance on this assignment. _Use only Java features discussed in class_.
Make sure that your program compiles, even if it is incorrect you will receive partial credit. 

---

## 1. `LetterGrade.java`

Write a program that asks the user for their grade (as an **int** from 1-100)

The program should then print their letter grade (no plus or minus), 
with $A \geq 90, B \geq 80, C \geq 70, D \geq 60, F < 60$

Example:
```
Please enter your grade from 1-100:
88
You got a B
```

### Part 2B

Modify your program so that it uses a while loop. It should repeat the calculation above, allowing the user to enter additional grades, until they enter a -1. 

Output Example:
```
Please enter your grade from 1-100:
88
You got a B
Please enter your grade from 1-100:
15
You got an F
-1
Goodbye!
```

<!-- pb -->

## 2. `Quadratic.java`

The quadratic formula is used to find the two roots of the equation $ax^2 + bx + c = 0$

The formula is given as: $\frac{-b \pm \sqrt{b^2 - 4ac}}{2a}$

Write a program `Quadratic.java` that satisfies the following:
1. Takes 3 numbers $a, b, c$ as _command line arguments_
2. Prints the full equation $ax^2 + bx + c = 0$ , inserting values a, b, and c
3. Calculates and prints the two roots

Example Output:
```
java Quadratic.java 1.0 0.0 -1.0
------------------------
Equation: 1.0x^2 + 0.0x + -1.0 = 0
root 1 = 1.0
root 2 = -1.0
```

Hint: Use `Math.sqrt(x)` to calculate the square root of a number, and `Double.parseDouble(s)` to convert a String argument to a double.

### Part 2B.

Add a check at the top of your program that makes sure 3 command line arguments are given. If there are not 3 arguments, then print an error message and exit. 

**Hint:** Use `args.length` to get the number of arguments, and `return;` to exit the program early. 

Example:
```
java Quadratic.java 4.5
------------------------
Error, you need to give 3 arguments
```

### Part 2C.

The part inside the square root ( $b^2 - 4ac$ ) is called the _discriminant_. It can tell you how many real solutions there are:
* $disc > 0$ means 2 real solution
* $disc = 0$ means 1 real solution
* $disc < 0$ means 0 real solutions

Modify your program so that it computes the discriminant as an intermediate result, then prints it and the appropriate number of roots and their values. 

<!-- pb -->

Examples:
```
java Quadratic.java 1.0 0.0 -1.0
------------------------
1.0x^2 + 0.0x + -1.0 = 0
Discriminant: 4.0
There are 2 real roots
root 1 = 1.0
root 2 = -1.0
```

```
java Quadratic.java 1.0 2.0 1.5
------------------------
1.0x^2 + 2.0x + 1.5 = 0
Discriminant: -2.0
There are 0 real roots
```

