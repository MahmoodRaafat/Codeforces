/*

B - TPrimes

We know that prime numbers are positive integers that have exactly two distinct positive divisors. 
Similarly, we'll call a positive integer t T-prime, if t has exactly three distinct positive 
divisors. You are given an array of n positive integers. For each of them determine whether it is 
T-prime or not.

Input
The first line contains a single positive integer, n (1 <= n <= 10^5), showing how many numbers 
are in the array. The next line contains n space-separated integers xi (1 <= xi <= 10^12).

Output
Print n lines: the i-th line should contain "YES" (without the quotes), if number xi is T-prime, 
and "NO" (without the quotes), if it isn't.

------------------------------------------------------------------------------------------------*/

import java.util.*;
public class B0230_TPrimes {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int lim = 1000000; // the max prime number can be sqrt(10^12) 
		boolean[] isPrime = new boolean[lim+1];
		
		for (int i=2; i<lim; i++)
			isPrime[i] = true;
		
		// sieve of Eratosthenes to find all primes from 1-lim
		for(int i = 2; i*i<=lim; i++) { 
            if(isPrime[i] == true) {
                for(int j=i*i; j<=lim; j+=i) {
                    isPrime[j] = false; 
                }
            }
        }
		
		for (int i=0; i<n; i++) {
			long num = sc.nextLong();
			// a number is a TPrime if it is the square of a prime
			if (Math.sqrt(num)%1==0 && isPrime[(int) Math.sqrt(num)])
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		sc.close();
	}
}