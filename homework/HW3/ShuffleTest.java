/***************************************
 * Homework 3 - Problem 2
 *
 * Course: CIS 284 - Computer Programming 2
 *
 * Student: !!!YOUR NAME HERE!!!
 *
 * Write a program that simulates a visualizes the results
 * of a shuffle algorithm, by shuffling many times
 * and saving the results in an array
 *
 **************************************/

public class ShuffleTest {

    public static void main(String[] args) {
      
    }

    /*** 
     * shuffle1
     * Randomly shuffles the given array by:
     * - Randomly choosing an element from [0:N] to swap into index 0
     * - Randomly choosing an element from [1:N] to swap into index 1
     * - ... and so on
     ****/
    public static void shuffle1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // Choose random index from i to end of array
            int j = i + (int)(Math.random() * (arr.length - i));

            // Swap arr[i] and arr[j]
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    /*** 
     * shuffle2
     * Randomly shuffles the given array by:
     * - Randomly choosing an element from [0:N] to swap into index 0
     * - Randomly choosing an element from [0:N] to swap into index 1
     * - ... and so on
     ****/
    public static void shuffle2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // Choose random index from 0 to end of array
            int j = (int)(Math.random() * arr.length);

            // Swap arr[i] and arr[j]
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }


}