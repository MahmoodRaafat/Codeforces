/*

B - Nirvana

Kurt reaches nirvana when he finds the product of all the digits of some positive 
integer. Greater value of the product makes the nirvana deeper. Help Kurt find the 
maximum possible product of digits among all integers from 1 to n.

Input
The only input line contains the integer n (1 <= n <= 2*10^9).

Output
Print the maximum product of digits among all integers from 1 to n.

--------------------------------------------------------------------------------------*/

import java.util.*;
public class B1143_Nirvana {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		String str = Integer.toString(n);
		long ans = 1;
		for (int i=0; i<str.length(); i++)
			ans *= Integer.parseInt(str.substring(i, i+1));
		
		if (str.charAt(0) == '1') {
			long product = 1;
			for (int i=1; i<str.length(); i++)
				product *= 9;
			ans = Math.max(ans, product);
		}
		
	    for (int i=0; i<str.length(); i++) {
	        if (str.charAt(i) == '0') 
	            continue; 
	        
	        int cur = Integer.parseInt(str.substring(i, i+1));
	        String temp = str.substring(0, i) + (cur-1);

	        String add = "";
	        for (int j = str.length(); j>i+1; j--)
	        	add += "9";
	        temp += add;
	        
	        long product = 1; 
	        for (int j=0; j<temp.length(); j++)
	        	product *= Integer.parseInt(temp.substring(j, j+1));
	        
	        ans = Math.max(ans, product);
	    } 
	    
	    System.out.println(ans);
	}
}