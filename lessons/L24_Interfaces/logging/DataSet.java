    
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class DataSet {
    private double[] numbers;

    public DataSet() {
        numbers = new double[0];
    }

    public int size() {
        return numbers.length;
    }

    public double get(int i) {
        return numbers[i];
    }

    /**
     * Returns the sum of the given array of doubles 
     *   (returns 0 on an empty array)
     **/
    public double sum() {
        double total = 0;
        for (int i = 0; i < numbers.length; i++) {
            total += numbers[i];
        }
        return total;
    }

    /**
     * Returns the maximum value in the given array
     *   (returns NEGATIVE_INFINITY on an empty array)
     **/
    public double max() {
        double maxVal = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < numbers.length; i++) {
            maxVal = Math.max(maxVal, numbers[i]);
        }
        return maxVal;
    }

    /**
     * Returns the minimum value in the given array
     *   (returns POSTIIVE_INFINITY on an empty array)
     **/
    public double min() {
        double minVal = Double.POSITIVE_INFINITY;
        for (int i = 0; i < numbers.length; i++) {
            minVal = Math.min(minVal, numbers[i]);
        }
        return minVal;
    }

    /**
     * Returns the mean (average) of the numbers in the given array
     *   (returns 0 on an empty array)
     **/
    public double mean() {
        if (numbers.length == 0) return 0;
        return sum()/numbers.length;
    }

    /**
     * Returns the sample variance of the numbers in the given array
     *   (returns 0 on an array of length 0 or 1)
     **/
    public double var() {
        if (numbers.length <= 1) return 0;
        double mu = mean();
        double sq_sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sq_sum += Math.pow(numbers[i] - mu, 2);
        }
        return sq_sum / (numbers.length-1); // subtract 1 for sample correction
    }

    /***
     * Returns a new array which consists of a copy of
     *   the given array with the given value appended to the end
     **/
    public void add(double value) {
        double[] temp = new double[numbers.length+1];
        for (int i = 0; i < numbers.length; i++) {
            temp[i] = numbers[i];
        }
        temp[numbers.length] = value;
        numbers = temp;
    }

    /***
     * Returns a new array which consists of a copy of
     *   the given array with the given index removed
     **/
    public void remove(int index) {
        double[] temp = new double[numbers.length-1];
        for (int i = 0; i < temp.length; i++) {
            if (i < index) {
                temp[i] = numbers[i];
            } else {
                temp[i] = numbers[i+1];
            }
        }
        numbers = temp;
    }

    public void load(File file) {
        try (Scanner scanner = new Scanner(file)) {
            int n = scanner.nextInt();
            numbers = new double[n];

            for (int i = 0; i < n; i++) {
                numbers[i] = scanner.nextDouble();
            }

        } catch (FileNotFoundException e) {
            System.err.println("Error loading file");
        }
    }

    /** 
     * Writes the the given array of numbers to the given file
     *   First line will be an integer: n - number of values to follow
     *   Next n lines will each contain 1 double value
     */
    public void save(File file) {
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.println(numbers.length);
            for (int i = 0; i < numbers.length; i++) {
                writer.println(numbers[i]);
            }

        } catch (FileNotFoundException e) {
            System.err.println("Error writing file: " + e);
        }
    }
}
