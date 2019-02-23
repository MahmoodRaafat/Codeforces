/*

A - Hit the Lottery

Allen has a LOT of money. He has n dollars in the bank. For security reasons, he wants to 
withdraw it in cash (we will not disclose the reasons here). The denominations for dollar 
bills are 1, 5, 10, 20, 100. What is the minimum number of bills Allen could receive after 
withdrawing his entire balance?

Input
The first and only line of input contains a single integer n (1 <= n <= 109).

Output
Output the minimum number of bills that Allen could receive.

-------------------------------------------------------------------------------------------*/

import java.util.*;
public class A0996_HitTheLottery {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] bills = {1, 5, 10, 20, 100};
		int money = sc.nextInt();
		sc.close();
		
		int res = 0;
		for (int i=bills.length-1; i>=0; i--) {
			int cur = money/bills[i];
			res += cur;
			money -= cur*bills[i];
		}
		System.out.println(res);
	}
}
