import java.util.Arrays;

public class Shuffling {
   public static void main(String[] args) {
       int[] arr = new int[10];
       for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
       }

       for (int i = 0; i < arr.length; i++) {
           int j = i + (int)(Math.random() * arr.length - i);
           int temp = arr[i];
           arr[i] = arr[j];
           arr[j] = temp;
       }

       System.out.println(Arrays.toString(arr));
    
   } 
}
