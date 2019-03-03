/*

B - Lunar New Year and Food Orderings

Lunar New Year is approaching, and Bob is planning to go for a famous restaurant - 
"Alice's". The restaurant "Alice's" serves n kinds of food. The cost for the i-th kind is
always ci. Initially, the restaurant has enough ingredients for serving exactly ai dishes
of the i-th kind. In the New Year's Eve, m customers will visit Alice's one after another
and the j-th customer will order dj dishes of the tj-th kind of food. The (i+1)-st 
customer will only come after the i-th customer is completely served. Suppose there are 
ri dishes of the i-th kind remaining (initially ri == ai). When a customer orders 1 dish 
of the i-th kind, the following principles will be processed.
    (1) If ri > 0, the customer will be served exactly 1 dish of the i-th kind. The cost
    for the dish is ci. Meanwhile, ri will be reduced by 1.
    (2) Otherwise, the customer will be served 1 dish of the cheapest available kind of 
    food if there are any. If there are multiple cheapest kinds of food, the one with the
    smallest index among the cheapest will be served. The cost will be the cost for the 
    dish served and the remain for the corresponding dish will be reduced by 1.
    (3) If there are no more dishes at all, the customer will leave angrily. Therefore, 
    no matter how many dishes are served previously, the cost for the customer is 0.
If the customer doesn't leave after the dj dishes are served, the cost for the customer 
will be the sum of the cost for these dj dishes. Please determine the total cost for each
of the customers.

Input
The first line contains two integers n and m (1 <= n, m <= 10^5), representing the number
of different kinds of food and the number of customers, respectively. The second line 
contains n positive integers a1, a2, ..., an (1 <= ai <= 10^7), where ai denotes the 
initial remain of the i-th kind of dishes. The third line contains n positive integers 
c1, c2, ..., cn (1 <= ci <= 10^6), where ci denotes the cost of one dish of the i-th kind. 
The following m lines describe the orders of the m customers respectively. The j-th line 
contains two positive integers tj and dj (1 <= tj <= n, 1 <= dj <= 10^7), representing 
the kind of food and the number of dishes the j-th customer orders, respectively.

Output
Print m lines. In the j-th line print the cost for the j-th customer.

----------------------------------------------------------------------------------------*/

import java.util.*;
public class B1106_LunarNewYearAndFoodOrdering {
	
	static class Food implements Comparable<Food> {
		public int index;
    		public int cost;
    	
    		public Food (int index, int cost) {
    			this.index = index; 
    			this.cost = cost;
    		}
    	
    		// sorts Foods in priority queue based on cost.
    		// If their costs are the same, sort based on index
		public int compareTo(Food food) {
			if (cost == food.cost) 
				return Integer.compare(index, food.index);
			return Integer.compare(cost, food.cost);
		}
	}
	
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int numDishes = sc.nextInt();
		int numCustomers = sc.nextInt();
		int[] foods = new int[numDishes];
		int[] cost = new int[numDishes];
		PriorityQueue<Food> pq = new PriorityQueue<Food>();
		
		for (int i=0; i<numDishes; i++)
			foods[i] = sc.nextInt();
		
		for (int i=0; i<numDishes; i++) {
			cost[i] = sc.nextInt();
			pq.add(new Food(i, cost[i]));
		}
		
		for (int i=0; i<numCustomers; i++) {
			long res = 0;
			int t = sc.nextInt() - 1;
			int d = sc.nextInt();		
         
			if (foods[t] >= d) {
				foods[t] -= d;
				res += (long) cost[t] * d;
				System.out.println(res);
				continue;
			}
			
			res += (long) foods[t] * cost[t];
			d -= foods[t];
			foods[t] = 0;
			
			while (d>0 && !pq.isEmpty()) {
				Food food = pq.peek();
			    
				if (foods[food.index] == 0) {
			    		pq.remove(); 
			    		continue;
			    	} 
			    
			  	if (foods[food.index] >= d) {
			    		res += (long) d * cost[food.index];
			    		foods[food.index] -= d;
			    		if (foods[food.index] == 0)
			    			pq.remove();
			    		d = 0;        
			    	}
			    	else {
			    		res += (long) foods[food.index] * cost[food.index];
			    		d -= foods[food.index];
			    		foods[food.index] = 0;
			    		pq.remove();
			    	}
			}
			
			if (d > 0) 
				res = 0;
			System.out.println(res);
		}
		sc.close();
	}
}
