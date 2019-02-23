/*

B - Interesting Drink

Vasiliy likes to rest after a hard work, so you may often meet him in some bar nearby. As all 
programmers do, he loves the famous drink "Beecola", which can be bought in n different shops
in the city. It's known that the price of one bottle in the shop i is equal to xi coins. 
Vasiliy plans to buy his favorite drink for q consecutive days. He knows, that on the i-th day 
he will be able to spent mi coins. Now, for each of the days he want to know in how many 
different shops he can buy a bottle of "Beecola".

Input
The first line of the input contains a single integer n (1 <= n <= 100 000) - the number of 
shops in the city that sell Vasiliy's favorite drink. The second line contains n integers xi 
(1 <= xi <= 100 000) - prices of the bottles of the drink in the i-th shop. The third line 
contains a single integer q (1 <= q <= 10^5) - the number of days Vasiliy plans to buy the 
drink. Then follow q lines each containing one integer mi (1 <= mi <= 10^9) - the number of 
coins Vasiliy can spent on the i-th day.

Output
Print q integers. The i-th of them should be equal to the number of shops where Vasiliy will 
be able to buy a bottle of the drink on the i-th day.

----------------------------------------------------------------------------------------------*/

import java.util.*;
public class B0706_InterestingDrink {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		final int MAX_PRICE = (int) 1e5;
		int[] prices = new int[n];
		int[] stores = new int[MAX_PRICE+1];
		
		for (int i=0; i<n; i++) {
			prices[i] = sc.nextInt();
			stores[prices[i]]++;
		}
		
		for (int i=1; i<MAX_PRICE+1; i++)
			stores[i] += stores[i-1];
		
		int q = sc.nextInt();
		for (int i=0; i<q; i++) {
			int num = sc.nextInt();
			if (num>MAX_PRICE)
				System.out.println(stores[MAX_PRICE]);
			else
				System.out.println(stores[num]);
		}
		sc.close();
	}
}