/*

B - Sasha and Magnetic Machines

One day Sasha visited the farmer 2D and his famous magnetic farm. On this farm, the crop grows due to 
the influence of a special magnetic field. Maintaining of the magnetic field is provided by n machines, 
and the power of the i-th machine is ai. This year 2D decided to cultivate a new culture, but what 
exactly he didn't say. For the successful growth of the new culture, it is necessary to slightly 
change the powers of the machines. 2D can at most once choose an arbitrary integer x, then choose one 
machine and reduce the power of its machine by x times, and at the same time increase the power of one \
another machine by x times (powers of all the machines must stay positive integers). Note that he may 
not do that if he wants. More formally, 2D can choose two such indices i and j, and one integer x such 
that x is a divisor of ai, and change powers as following: ai=aix, aj=aj*x. Sasha is very curious, 
that's why he wants to calculate the minimum total power the farmer can reach. There are too many 
machines, and Sasha can't cope with computations, help him!

Input
The first line contains one integer n (2 <= n <= 5*10^4) — the number of machines. The second line 
contains n integers a1, a2, ..., an (1 <= ai <= 100) — the powers of the machines.

Output
Print one integer — minimum total power.

----------------------------------------------------------------------------------------------------*/

import java.util.*;
public class B1113_SashaAndMagneticMachines {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		int total = 0;
		for (int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
			total += arr[i];
		}
		sc.close();
		
		Arrays.sort(arr);
		
		int res = total;
		for (int i=n-1; i>=0; i--) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(arr[i]);
			for (int j=1; j<=arr[i]/2; j++)
				if (arr[i]%j==0)
					list.add(j);
			for (int j=0; j<list.size(); j++)
				res = Math.min(res, total-arr[i]+arr[i]/list.get(j)-arr[0]+arr[0]*list.get(j));
			
		}
		System.out.println(res);
	}
}
