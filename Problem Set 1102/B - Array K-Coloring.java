/*

B - Array K-Coloring

You are given an array a consisting of n integer numbers. You have to color this array in k colors 
in such a way that:
    (1) Each element of the array should be colored in some color
    (2) For each i from 1 to k there should be at least one element colored in the i-th color in 
    	the array
    (3) For each i from 1 to k all elements colored in the i-th color should be distinct. 
Obviously, such coloring might be impossible. In this case, print "NO". Otherwise print "YES" and 
any coloring (i.e. numbers c1, c2, ..., cn, where 1 <= ci <= k and ci is the color of the i-th 
element of the given array) satisfying the conditions above. If there are multiple answers, you 
can print any.

Input
The first line of the input contains two integers n and k (1 <= k <= n <= 5000) — the length of the 
array a and the number of colors, respectively. The second line of the input contains n integers 
a1, a2, ..., an (1 <= ai <= 5000) - elements of the array a.

Output
If there is no answer, print "NO". Otherwise print "YES" and any coloring (i.e. numbers c1, c2, 
..., cn, where 1 <= ci <= k and ci is the color of the i-th element of the given array) satisfying 
the conditions described in the problem statement. 

-------------------------------------------------------------------------------------------------*/

import java.util.*;
public class B1102_ArrayKColoring {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		int[] sorted = new int[n];
		
		for (int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
			sorted[i] = arr[i];
		}
		sc.close();
		
		Arrays.sort(sorted);
		
		int[] res = new int[n];
		int cnt = 1;
		for (int i=0; i<n; i++) {
			res[i] = cnt;
			cnt++;
			if (cnt > k) {
				cnt = 1;
			}
		}
		
		
		for (int i=0; i<n; i++) {
			int j = i+1;
			
			while (j<n && sorted[j]==sorted[j-1])
				j++;
			
			List<Integer> list = new ArrayList<Integer>();
			for (int a=i; a<j; a++) {
				if (list.contains(res[a])) {
					System.out.println("NO");
					return;
				}
				list.add(res[a]);
			}
			i = j-1;
		}
	
		System.out.println("YES");
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (arr[i] == sorted[j]) {
					System.out.print(res[j] + " ");
					sorted[j] = -1;
					break;
				}
			}
		}
	}
}
