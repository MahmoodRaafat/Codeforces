/*

C - Lunar New Year and Number Division

Lunar New Year is approaching, and Bob is struggling with his homework – a number 
division problem. There are n positive integers a1, a2, ..., an on Bob's homework 
paper, where n is always an even number. Bob is asked to divide those numbers into 
groups, where each group must contain at least 2 numbers. Suppose the numbers are 
divided into m groups, and the sum of the numbers in the j-th group is sj. Bob's 
aim is to minimize the sums of the squares of sj. Bob is puzzled by this hard 
problem. Could you please help him solve it?

Input
The first line contains an even integer n (2 <= n <= 3*10^5), denoting that there 
are n integers on Bob's homework paper. The second line contains n integers a1, a2,
..., an (1 <= ai <= 10^4), describing the numbers you need to deal with.

Output
A single line containing one integer, denoting the minimum of the sums of the 
squares of sj.

---------------------------------------------------------------------------------*/

import java.util.*;
public class C1106_LunarNewYearAndNumberDivision {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for (int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		sc.close();
		
		Arrays.sort(arr);
		
		long res = 0;
		for (int i=0; i<n/2; i++)
			res += (long) (arr[i]+arr[n-1-i]) * (arr[i]+arr[n-1-i]);

		System.out.println(res);
	}
}