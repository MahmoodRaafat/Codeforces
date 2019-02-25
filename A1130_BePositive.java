/*

A - Be Positive

You are given an array of n integers: a1,a2,…,an. Your task is to find some 
non-zero integer d (-10^3 <= d <= 10^3) such that, after each number in the 
array is divided by d, the number of positive numbers that are presented in the 
array is greater than or equal to half of the array size (i.e., at least |n2|). 
Note that those positive numbers do not need to be an integer (e.g., a 2.5 
counts as a positive number). If there are multiple values of d that satisfy the 
condition, you may print any of them. In case that there is no such d, print 
a single integer 0. Recall that |x| represents the smallest integer that is not 
less than x and that zero (0) is neither positive nor negative.

Input
The first line contains one integer n (1 <= n <= 100) — the number of elements 
in the array. The second line contains n space-separated integers a1, a2, ..., an 
(-10^3 <= ai <= 10^3).

Output
Print one integer d (-10^3 <= d <= 10^3 and d!=0) that satisfies the given 
condition. If there are multiple values of d that satisfy the condition, you
may print any of them. If there is no such d, print a single integer 0.

--------------------------------------------------------------------------------*/

import java.util.*;
public class A1130_BePositive {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double half = n/2.0;
		
		int positive = 0, negative = 0;
		for (int i=0; i<n; i++) {
			int next = sc.nextInt();
			if (next > 0)
				positive++;
			if (next < 0)
				negative++;
		}
		sc.close();
		
		if (positive >= half)
			System.out.println(1);
		else if (negative >= half)
			System.out.println(-1);
		else
			System.out.println(0);
	}
}