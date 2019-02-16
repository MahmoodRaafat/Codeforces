/*

A - Two Distinct Points

You are given two segments [l1 to r1] and [l2 to r2] on the x-axis. It is guaranteed that l1<r1 and l2<r2
Segments may intersect, overlap or even coincide with each other. Your problem is to find two integers a 
and b such that l1<=a<=r1, l2<=b<=r2 and a!=b. In other words, you have to choose two distinct integer 
points in such a way that the first point belongs to the segment [l1 to r1] and the second one belongs to 
the segment [l2 to r2]. It is guaranteed that the answer exists. If there are multiple answers, you can 
print any of them. You have to answer q independent queries.

Input
The first line of the input contains one integer q (1<=q<=500) — the number of queries. Each of the next q
lines contains four integers l1i, r1i, l2i and r2i (1<=l1i, r1i, l2i, r2i<=109, l1i<r1i, l2i<r2i) — the ends 
of the segments in the i-th query.

Output
Print 2q integers. For the i-th query print two integers ai and bi — such numbers that l1i<=ai<=r1i, 
l2i<=bi<=r2i and ai!=bi. Queries are numbered in order of the input. It is guaranteed that the answer exists. 
If there are multiple answers, you can print any.

-----------------------------------------------------------------------------------------------------------*/

import java.util.*;
public class A1108_TwoDistinctPoints {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();
		int[] arr = new int[4];
		
		for (int i=0; i<q; i++) {
			for (int j=0; j<4; j++)
				arr[j] = sc.nextInt();
			
			if (arr[0] != arr[2])
				System.out.println(arr[0] + " " + arr[2]);
			else
				System.out.println(arr[0] + " " + arr[3]);
		}
		sc.close();
	}
}