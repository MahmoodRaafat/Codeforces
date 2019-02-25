/*

B - Two Cakes

Sasha and Dima want to buy two n-tier cakes. Each cake should consist of n different tiers: from 
the size of 1 to the size of n. Tiers should go in order from the smallest to the biggest (from 
top to bottom). They live on the same street, there are 2*n houses in a row from left to right. 
Each house has a pastry shop where you can buy a cake tier. Unfortunately, in each pastry shop 
you can buy only one tier of only one specific size: in the i-th house you can buy a tier of the 
size ai (1 <= ai <= n). Since the guys carry already purchased tiers, and it is impossible to 
insert a new tier in the middle of the cake, they agreed to buy tiers from the smallest to the 
biggest. That is, each of them buys tiers in order: 1, then 2, then 3 and so on up to n. 
Initially, Sasha and Dima are located near the first (leftmost) house. Output the minimum 
distance that they will have to walk in total to buy both cakes. The distance between any two 
neighboring houses is exactly 1.

Input
The first line of the input contains an integer number n - the number of tiers in each cake 
(1 <= n <= 10^5). The second line contains 2*n integers a1, a2, ..., a2*n (1 <= ai <= n), where 
ai is equal to the size of the tier, which can be bought in the i-th house. Remember that in 
each house you can buy only one tier. It is guaranteed that every number from 1 to n occurs in 
a exactly two times.

Output
Print one number - the minimum distance that the guys have to walk in total to buy both cakes. 
Guys can be near same house at the same time. They begin near the first (leftmost) house. Each 
of the guys should buy n tiers in ascending order of their sizes.

----------------------------------------------------------------------------------------------*/

import java.util.*;
public class B1130_TwoCakes {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n+1][2];
		
		for (int i=1; i<=n; i++) {
			arr[i][0] = -1;
			arr[i][1] = -1;
		}
		
		for (int i=0; i<2*n; i++) {
			int next = sc.nextInt();
			if (arr[next][0] == -1)
				arr[next][0] = i;
			else
				arr[next][1] = i;
		}
		sc.close();
		
		long res = 0;
		for (int i=1; i<=n; i++) {
			if (Math.abs(arr[i][0]-arr[i-1][0]) + Math.abs(arr[i][1]-arr[i-1][1]) < 
				Math.abs(arr[i][0]-arr[i-1][1]) + Math.abs(arr[i][1]-arr[i-1][0])) {
				res += Math.abs(arr[i][0]-arr[i-1][0]) + Math.abs(arr[i][1]-arr[i-1][1]);
			}
			else
				res += Math.abs(arr[i][0]-arr[i-1][1]) + Math.abs(arr[i][1]-arr[i-1][0]);
		}
		System.out.println(res);
	}
}