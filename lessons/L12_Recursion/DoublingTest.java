/***
 * File: DoublingTest.java
 ***/
public class DoublingTest {

	public static int linearSearch(int[] arr, int q) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == q) {
				return i;
			}
		}
		return -1;
	}

    public static void main(String[] args) {
		final int N_TRIALS = 1000;
        int N = 100;

        System.out.printf(" %9s | %9s | %9s |\n", "N", "Linear", "Binary" );

        while (true) {
			// Create sorted array of length N
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = i;
			}

			// Run 1000 trials of linear search
			long start = System.nanoTime();
			for (int t = 0; t < N_TRIALS; t++) {
				int q = (int)(Math.random() * N);
				linearSearch(arr, q);
			}
			long linearTime = (System.nanoTime() - start)/1000;

			// Run 1000 trials of linear search
			start = System.nanoTime();
			for (int t = 0; t < N_TRIALS; t++) {
				int q = (int)(Math.random() * N);
				BinarySearch.binarySearch(arr, q);
			}
			long binaryTime = (System.nanoTime() - start)/1000;

			System.out.printf(" %9d | %9.3f | %9.3f |\n", N, (double)linearTime/N_TRIALS, (double)binaryTime/N_TRIALS);

            // If it took over 1 second, quit
            if (linearTime > 2_000_000) {
                break;
            }
            N *= 2; // double N
        }
    }
}
