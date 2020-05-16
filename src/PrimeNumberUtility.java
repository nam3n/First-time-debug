import java.util.Scanner;

/***
 * This class contains utilities for prime numbers
 */
public class PrimeNumberUtility {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        PrimeNumberUtility.printToN(n);
    }

    /**
     * This function prints prime numbers less than or equal to n
     * @param n limit
     */
    private static void printToN(int n) {
        // use sieve of Eratosthenes
        boolean[] sieve = new boolean[n+1];

        // initially all are primes
        for (int i = 0; i <= n; i++) {
            sieve[i] = true;
        }

        sieve[0] = false;
        sieve[1] = false;

        // For each prime number i less than sqrt(n)
        for (int i = 2; i * i <= n; i++) {
            if (sieve[i]) {
                // Mark all the multiples of i as composite numbers
                for (int j = i * i; j <= n; j += i) {
                    sieve[j] = false;
                }
            }
        }
        // print result
        for (int i = 0; i <= n; i++) {
            if (sieve[i]) {
                System.out.println(i);
            }
        }
    }
}
