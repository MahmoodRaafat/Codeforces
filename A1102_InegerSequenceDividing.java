/*

A - Integer Sequence Dividing

You are given an integer sequence 1,2,…,n. You have to divide it into two sets A and B 
in such a way that each element belongs to exactly one set and |sum(A)-sum(B)| is the
minimum possible. The value |x| is the absolute value of x and sum(S) is the sum of 
elements of the set S.

Input
The first line of the input contains one integer n (1 <= n <= 2*10^9).

Output
Print one integer — the minimum possible value of |sum(A)-sum(B)| if you divide the 
initial sequence 1,2,…,n into two sets A and B.

------------------------------------------------------------------------------------------*/

import java.util.*;
public class A1102_InegerSequenceDividing {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		int[] arr = {0, 1, 1, 0};
		System.out.println(arr[n%4]);
	}
}

/*
 * find the result of the minimum difference of sets of every number from 1-50 (with the code below)
 * and you will see a pattern: 1, 1, 0, 0, 1, 1, 0, 0, ...
 * the pattern repeats every 4 numbers 
 * 
    for (int i=1; i<=50; i++) {
		int a = i;
		int b = 0;
		for (int j=i-1; j>=1; j--) {
			if (a>b)
				b += j;
			else
				a += j;
		}
		System.out.println("i: " + i + " = " + Math.abs(b-a));
	}
 */