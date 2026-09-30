import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;

public class BinarySearch {

    // Binary Search:
    // Given a sorted array and query value q,
    //   returns the index of q in the array (or -1)
    public static int binarySearch(int[] arr, int q) {
        return binarySearch(arr, q, 0, arr.length);
    }
    private static int binarySearch(int[] arr, int q, int lo, int hi) {
        if (hi <= lo) {
            return -1;
        }
        // Check middle value
        int mid = lo + (hi - lo)/2;
        if (arr[mid] == q) {
            return mid;
        }
        // If query is smaller than middle, search left half
        if (q < arr[mid]) {
            return binarySearch(arr, q, lo, mid);

        // Otherwise, search right half
        } else {
            return binarySearch(arr, q, mid+1, hi);
        }
    }

    public static void main(String[] args) {
        int[] nums;
        try (Scanner scanner = new Scanner(new File("nums1.txt"))) {
            // first number is number of integers to follow
            int n = scanner.nextInt();
            nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error reading file: " + e);
            return;
        }

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter an integer: ");
            int q = scanner.nextInt();
            if (q == -1) break;

            if (binarySearch(nums, q) >= 0) {
                System.out.println(q + " is in the array");
            } else {
                System.out.println(q + " is not in the array");
            }
        }
        
        scanner.close();
    }
}
