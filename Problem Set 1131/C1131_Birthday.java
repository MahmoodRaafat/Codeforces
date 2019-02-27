/*

C - Birthday

Cowboy Vlad has a birthday today! There are n children who came to the celebration. In order to greet Vlad, the 
children decided to form a circle around him. Among the children who came, there are both tall and low, so if 
they stand in a circle arbitrarily, it may turn out, that there is a tall and low child standing next to each 
other, and it will be difficult for them to hold hands. Therefore, children want to stand in a circle so that 
the maximum difference between the growth of two neighboring children would be minimal possible. Formally, let's 
number children from 1 to n in a circle order, that is, for every i child with number i will stand next to the 
child with number i+1, also the child with number 1 stands next to the child with number n. Then we will call 
the discomfort of the circle the maximum absolute difference of heights of the children, who stand next to each 
other. Please help children to find out how they should reorder themselves, so that the resulting discomfort is 
smallest possible.

Input
The first line contains a single integer n (2 <= n <= 100) - the number of the children who came to Vlad's 
birthday. The second line contains integers a1, a2, ..., an (1 <= ai <= 10^9) denoting heights of every child.

Output
Print exactly n integers - heights of the children in the order in which they should stand in a circle. You can 
start printing a circle with any child. If there are multiple possible answers, print any of them.

--------------------------------------------------------------------------------------------------------------*/

import java.util.*;
public class C1131_Birthday {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for (int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		sc.close();
		
		Arrays.sort(arr);
		
		ArrayList<Integer> res = new ArrayList<Integer>();
		res.add(arr[n-1]);
		for (int i=n-2; i>=0; i--) {
			res.add(0, arr[i--]);
			if (i>=0)
				res.add(arr[i]);
		}
		
		for (int i=0; i<res.size(); i++) {
			System.out.print(res.get(i) + " ");
		}
	}
}