/*

B - Vanya and Lanterns

Vanya walks late at night along a straight street of length l, lit by n lanterns. Consider 
the coordinate system with the beginning of the street corresponding to the point 0, and 
its end corresponding to the point l. Then the i-th lantern is at the point ai. The lantern 
lights all points of the street that are at the distance of at most d from it, where d is 
some positive number, common for all lanterns. Vanya wonders: what is the minimum light 
radius d should the lanterns have to light the whole street?

Input
The first line contains two integers n, l (1 <= n <= 1000, 1 <= l <= 10^9) - the number of 
lanterns and the length of the street respectively. The next line contains n integers ai 
(0 <= ai <= l). Multiple lanterns can be located at the same point. The lanterns may be 
located at the ends of the street.

Output
Print the minimum light radius d, needed to light the whole street. The answer will be 
considered correct if its absolute or relative error doesn't exceed 10^-9

----------------------------------------------------------------------------------------*/

import java.util.*;
public class B0492_VanyaAndLanterns {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		int streetLength = sc.nextInt();
		double[] arr = new double[n];
		
		for (int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		sc.close();
		
		Arrays.sort(arr);
		
		double max = Math.max(arr[0], streetLength-arr[n-1]);
		for (int i=1; i<n; i++)
			max = Math.max(max, (arr[i]-arr[i-1])/2);
		
		System.out.println(max);
	}
}
