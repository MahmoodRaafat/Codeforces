/*

A - IQ Test

Bob is preparing to pass IQ test. The most frequent task in this test is to find out which 
one of the given n numbers differs from the others. Bob observed that one number usually differs 
from the others in evenness. Help Bob — to check his answers, he needs a program that among the 
given n numbers finds one that is different in evenness.

Input
The first line contains integer n (3 <= n <= 100) — amount of numbers in the task. The second line 
contains n space-separated natural numbers, not exceeding 100. It is guaranteed, that exactly one 
of these numbers differs from the others in evenness.

Output
Output index of number that differs from the others in evenness. Numbers are numbered from 1 in 
the input order.

-----------------------------------------------------------------------------------------------*/

import java.util.Scanner;
public class A0025_IQTest {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int even = 0, odd = 0;
		
		for (int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
			
			// count the number of even and odd numbers
			if (arr[i]%2==0)
				even++;
			else
				odd++;
		}
		sc.close();
		
		// if there is one odd number, find its index and print it
		if (even>odd) {
			for (int i=0; i<n; i++) {
				if (arr[i]%2 != 0)
					System.out.println(i+1); // +1 b/c arrays are 0 indexed
			}
		}
		
		// if there is one even number
		else {
			for (int i=0; i<n; i++) {
				if (arr[i]%2==0)
					System.out.println(i+1);
			}
		}
	}
}
