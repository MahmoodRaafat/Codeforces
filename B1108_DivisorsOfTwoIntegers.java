/*

B - Divisors of Two Integers

Recently you have received two positive integer numbers x and y. You forgot them, but you remembered a 
shuffled list containing all divisors of x (including 1 and x) and all divisors of y (including 1 and y). 
If d is a divisor of both numbers x and y at the same time, there are two occurrences of d in the list. 
For example, if x=4 and y=6 then the given list can be any permutation of the list [1,2,4,1,2,3,6]. Some 
of the possible lists are: [1,1,2,4,6,3,2], [4,6,1,1,2,3,2] or [1,6,3,2,4,1,2]. Your problem is to restore 
suitable positive integer numbers x and y that would yield the same list of divisors (possibly in a
different order). It is guaranteed that the answer exists, i.e. the given list of divisors corresponds to 
some positive integers x and y.

Input
The first line contains one integer n (2<=n<=128) � the number of divisors of x and y. The second line of 
the input contains n integers d1,d2,...,dn (1<=di<=104), where di is either divisor of x or divisor of y. 
If a number is divisor of both numbers x and y then there are two copies of this number in the list.

Output
Print two positive integer numbers x and y � such numbers that merged list of their divisors is the 
permutation of the given list of integers. It is guaranteed that the answer exists.

----------------------------------------------------------------------------------------------------------*/

import java.util.*;
public class B1108_DivisorsOfTwoIntegers {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		int num1 = -1;
		for (int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
			if (arr[i] > num1)
				num1 = arr[i]; // find max number in arr, will be one of the 2 numbers (x or y)
		}
		sc.close();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i=0; i<n; i++) { // find all divisors of num1 and take them out of arr
			if (!list.contains(arr[i]) && num1%arr[i]==0) {
				list.add(arr[i]);
				arr[i] = -1;
			}
		}
		
		int num2 = -1;
		for (int i=0; i<n; i++) {
			if (arr[i] > num2)
				num2 = arr[i]; // find new max in arr, will be the other number
		}
		
		System.out.println(num1 + " " + num2);
	}
}