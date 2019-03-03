/*

A - Best Subsegment

You are given array a1,a2,…,an. Find the subsegment al, al+1, ..., ar (1 <= l <= r <= n) 
with maximum arithmetic mean (in floating-point numbers, i.e. without any rounding). If 
there are many such subsegments find the longest one.

Input
The first line contains single integer n (1 <= n <= 10^5) - length of the array a. The 
second line contains n integers a1, a2, ..., an (0 <= ai <=10^9) - the array a.

Output
Print the single integer — the length of the longest subsegment with maximum possible 
arithmetic mean.

---------------------------------------------------------------------------------------*/

import java.util.*;
public class A1117_BestSubsegment {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int max = 0;
		
		for (int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
			max = Math.max(max, arr[i]);
		}
		sc.close();
		
		int res = 1;
		for (int i=0; i<n; i++) {
			if (arr[i] != max)
				continue;
			int j=i+1;
			while(j<n && arr[j]==max)
				j++;
			res = Math.max(j-i, res);
			i=j-1;
		}
		System.out.println(res);
	}
}