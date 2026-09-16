/***************************************
 * Homework 3 - Problem 2 Extra Credit
 *
 * Course: CIS 284 - Computer Programming 2
 *
 * Student: !!!YOUR NAME HERE!!!
 *
 * Write a program that simulates the results of 
 *   shuffling a deck of cards after K riffle shuffles
 * This will animate starting at K=1, 2, 3, ...
 *
 **************************************/

import java.util.Arrays;

public class RiffleTest {

    public static void main(String[] args) {

    }

    /*** 
     * riffleShuffle
     * Randomly shuffles the given array using a riffle shuffle:
     * - Split the array into two parts
     * - Copy items from each part, randomly choosing which one to use
     * - Repeat this 'nShuffles' times
     ****/
    public static void riffleShuffle(int[] arr) {
        // We will split the array into two parts: low and high
        // We choose the split position 'mid' to be in the center half (25% - 75%)
        int mid = (int)((0.25 + 0.5*Math.random()) * arr.length);

        // low is the index of the next item to copy in the lower part
        int low = 0;

        // high is the index of the next item to copy in the higher part
        int high = mid;

        // Make a copy of arr
        int[] temp = Arrays.copyOf(arr, arr.length);

        for (int i = 0; i < arr.length; i++) {
            // If the lower part is fully copied, always copy from high
            if (low == mid) {
                arr[i] = temp[high++];

            // If the higher part is fully copied, always copy from low
            } else if (high == arr.length) {
                arr[i] = temp[low++];

            // Choose the lower part with 50% chance
            } else if (Math.random() < 0.5) {
                arr[i] = temp[low++];

            // Choose the higher part with 50% chance
            } else {
                arr[i] = temp[high++];
            }
        }
    }   
}
