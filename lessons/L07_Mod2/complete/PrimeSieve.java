/******************************************************************************
 *  Compilation:  javac PrimeSieve.java
 *  Execution:    java -Xmx1100m PrimeSieve n
 *
 *  Computes the number of primes less than or equal to n using
 *  the Sieve of Eratosthenes.
 *
 ******************************************************************************/


public class PrimeSieve {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        // initially assume all integers are prime
        boolean[] isPrime = new boolean[n+1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        // mark non-primes <= n using Sieve of Eratosthenes
        for (int factor = 2; factor*factor <= n; factor++) {

			if (!isPrime[factor]) continue;

			System.out.println("Found prime " + factor);

            // if factor is prime, then mark multiples of factor as non-prime
            // suffices to consider multiples 2*factor, 3*factor, ..., n
			for (int mult = 2*factor; mult <= n; mult += factor) {
				isPrime[mult] = false;
			}
        }

        // count primes
        int primes = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
				primes++;
			}
        }
        System.out.println("The number of primes <= " + n + " is " + primes);
    }
}
