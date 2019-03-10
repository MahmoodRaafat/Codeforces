/*

A - PolandBall and Hypothesis

PolandBall is a young, clever Ball. He is interested in prime numbers. He has stated a 
following hypothesis: "There exists such a positive integer n that for each positive integer 
m number n*m + 1 is a prime number". Unfortunately, PolandBall is not experienced yet and 
doesn't know that his hypothesis is incorrect. Could you prove it wrong? Write a program that 
finds a counterexample for any n.

Input
The only number in the input is n (1 <= n <= 1000) — number from the PolandBall's hypothesis.

Output
Output such m that n*m + 1 is not a prime number. Your answer will be considered correct if 
you output any suitable m such that 1 <= m <= 10^3. It is guaranteed the the answer exists.

-------------------------------------------------------------------------------------------*/

import java.util.*;
public class A0755_PolandBallAndHypothesis {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		for (int i=1; i<=1000; i++) {
			if (!isPrime(n*i+1)) {
				System.out.println(i);
				return;
			}
		}
	}
	
	public static boolean isPrime(int num) {
		if (num <= 2) 
			return true;
		if (num%2==0) 
			return false;
		for (int i=3; i*i<=num; i+=2)
			if (num%i==0)
				return false;
		return true;
	}
}
