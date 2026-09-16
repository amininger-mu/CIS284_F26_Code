import java.util.Arrays;

public class RandomYears {
    public static void main(String[] args) {
        // Generate an int array of 10 random years between 1900-2100
        int[] years = new int[10];
        for (int i = 0; i < years.length; i++){
            years[i] = (int)(1900 + Math.random() * 200);
        }

        // Print out the array
        System.out.println(Arrays.toString(years));
    }
}
