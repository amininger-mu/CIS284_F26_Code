# Homework 6 - Using Data Types

**Course:** CIS 284 - Computer Programming 2 - Fall 2026 \
**Instructor:** Dr. Aaron Mininger \

## Submission Instructions

**Due Date:** Nov 5 at 11:59pm

Zip up all java files and upload to Canvas. **Make sure each file has your name at the top**

<br>

For 2 bonus points, answer the following questions (as a **comment** on Canvas):
1. Give an estimate of how much time you spent on this assignment.
2. How difficult did you find this assignment?
3. Was anything unclear in the directions? Do you have any other feedback?

Your responses will be helpful feedback for refining these assignments in future courses. 

<br>

---
## Assignment Overview

This assignment will help you practice using data types by writing applications involving image processing and accessing Web APIs via JSON.

## Grading Information

_If you can't complete everything, it is better to submit partial work than miss the deadline._

| Points | Name | Description |
|---|---|---|
| 25 | Effort | Do the programs compile and run? Was a reasonable attempt made? |
| 5  | Style | Is the code formatted well? Is it readable? Are variables named well? |
| 20 | Part 1 | Correct implementation of `FlipImage` program. |
| 25 | Part 2 | Correct implementation of `RotateImage` program. |
| 10 | Part 3 | Correct implementation of `Joke.java` program. |
| 15 | Part 4 | Correct implementation of `ZipCode.java` program. |

Note: Your output does not need to match my examples word for word. Feel free to add additional messages or personalize it, as long as it satisfies the requirements.

<!-- pb -->

## 1. Flip Image

In this part, you will write a program that will flip an image horizontally or vertically. 

### **Requirements:**
- Your program file must be called `FlipImage.java`
- Your program should take 2 command line arguments. 1: The source image filename. 2: A flag (String) that is either `"-h"` or `"-v"` (selecting which flip to do)
- Write 2 functions called `flipHorizontal` and `flipVertical`. These should take a `Picture` as a parameter, and return a _new_ `Picture` object containing the flipped image (same size). 
- Show both the old and new pictures


### **Output Example:**

```
java FlipImage giraffe.jpg -h
```

![[flipped_giraffe.png|300]]

### **Additional Tips**

Model your solution after the `Scale.java` file in `lessons/L18_Image_Processing`. 

In that code, for each pixel in the target image (`colT, rowT`), it computes the corresponding pixel in the source image (`colS, rowS`)

```java
for (int colT = 0; colT < width; colT++) {
    for (int rowT = 0; rowT < height; rowT++) {
        int colS = colT * source.width()  / width;
        int rowS = rowT * source.height() / height;
        Color color = source.get(colS, rowS);
        target.set(colT, rowT, color);
    }
}
```

You will do a similar thing to flip an image, just think about how to map each source pixel onto the target image when doing a flipping operation.

<!-- pb -->

## 2. Rotate Image

In this part, you will write a program that will rotate an image by a given number of degrees. 

### **Requirements:**
- Your program file must be called `RotateImage.java`
- Your program should take 2 command line arguments. 1: The source image filename. 2: degrees (int) to rotate.
- Convert the angle into radians using `Math.toRadians(degrees)`
- Write 1 functions called `rotate` that takes a `Picture` and `double angle` (in radians) as parameters, and returns a _new_ `Picture` object containing the rotated image (same size).
- Show both the old and new pictures

### **Output Example:**

```
java RotateImage giraffe.jpg 30
```

![[rotated_giraffe.png|300]]

### **Additional Info**

Again, your solution will look similar to the scaling code, but the mapping is a little more complex.

For each pixel in the target image: $(col_t, row_t)$:

Since we are rotating around the center point, you need to subtract the center coordinate:
- $x_t = col_t - width/2, \quad y_t = row_t - height/2$

To rotate this point (x, y) by $\theta$ radians, use the following equations:
- $x_s = x_t*\cos{\theta} - y_t*\sin{\theta}$
- $y_s = x_t*\sin{\theta} + y_t*\cos{\theta}$

And finally, to map back to a pixel in the source image, do:
- $col_s = x_s + width/2, \quad row_s = y_s + height/2$

This source row/col might be out of bounds, so make sure you check that it is a valid pixel.

(See next page for diagram)

<!-- pb -->

![[rot1.png|400]]

![[rot2.png|400]]

---
## Explore Further: Image Filters

This part is optional and will not be graded. Complete parts 3 and 4 first, then come back to this if you are interested in exploring more about image processing. 

An **image filter** performs a specific computation to transform each pixel. We already saw one example: making a grayscale image (transform each pixel to its grayscale equivalent).

Here are some other ideas for possible filters: 
- Extract a color channel (RGB): only use 1 of the 3 color values as your grayscale luminosity. 
- Invert the image: flip each red, green, and blue channel (subtract from 255). 
    - For example, a red value of 52 becomes 203.
- Increase/Decrease brightness: multiply each channel by a scale factor. 
    - For example, multiplying each channel by 1.2 makes the image brighter.
- Posterize: Reduce channels from 255 levels to N levels. 
    - For example, 4 bit color only uses 2^4=16 levels per channel. Multiply each color by `(v / 16) * 16` (the integer division will lose information). Experiment with different powers of 2.
- Blur: Replace each pixel with the average of it and its 8 neighbors. 

Use the `Grayscale.java` file as a starting point

<!-- pb -->

## 3. Joke of the Day

In this execise, you will use an online API to get the joke of the day.

### **Requirements:**
- Your program must be called `Joke.java`
- Fetch json data from the url below using the `FetchData.java` class
- Extract the json data using `JSONObject`
- Print out the joke setup and punchline.

Use the API at: [https://official-joke-api.appspot.com/random_joke](https://official-joke-api.appspot.com/random_joke)\
(Remember that you will need to set your classpath to include `json.jar`)

**Hint:** Model your code after the L19 lesson code examples (like `StockQuote.java`)

### **Example:**

`java Joke`

```
Why couldn't the kid see the pirate movie?
It was rated arrr!
```


<br>

---
## 4. Look up Zip Code

In this execise, you will write a program that can look up the city and state for a particular zip code.

### **Requirements:**
- Your program must be called `ZipCode.java`
- It should take 1 command line argument: the zip code
- Fetch json data from the url below using the `FetchData.java` class
- Extract the json data using `JSONObject`
- Print out the zip code, city, and state information

Your program should use the API [https://api.zippopotam.us/us/19104](https://api.zippopotam.us/us/19104) (this url would look up zip code 19104).

Note that the API returns an array of places. You only ever need to print out the first one (index 0)

### Example:

`java ZipCode 19104`

```
Zip Code 19104 is: Philadelphia, PA
```













