/*



D - Lunar New Year and a Wander

Lunar New Year is approaching, and Bob decides to take a wander in a nearby park. The 
park can be represented as a connected graph with n nodes and m bidirectional edges. 
Initially Bob is at the node 1 and he records 1 on his notebook. He can wander from 
one node to another through those bidirectional edges. Whenever he visits a node not 
recorded on his notebook, he records it. After he visits all nodes at least once, he 
stops wandering, thus finally a permutation of nodes a1, a2, ..., an is recorded.
Wandering is a boring thing, but solving problems is fascinating. Bob wants to know 
the lexicographically smallest sequence of nodes he can record while wandering. Bob 
thinks this problem is trivial, and he wants you to solve it. A sequence x is 
lexicographically smaller than a sequence y if and only if one of the following holds:
	(1) x is a prefix of y, but x != y (this is impossible in this problem)
	(2) in the first position where x and y differ, the sequence x has a smaller 
	    element than the corresponding element in y. 

Input
The first line contains two positive integers n and m (1 <= n, m <= 10^5), denoting 
the number of nodes and edges, respectively. The following m lines describe the 
bidirectional edges in the graph. The i-th of these lines contains two integers ui 
and vi (1 <= ui, vi <= n), representing the nodes the i-th edge connects. Note that 
the graph can have multiple edges connecting the same two nodes and self-loops. It 
is guaranteed that the graph is connected.

Output
Output a line containing the lexicographically smallest sequence a1, a2, ..., an
Bob can record.

------------------------------------------------------------------------------------*/

import java.util.*;
public class D1106_LunarNewYearAndAWander {
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int numNodes = sc.nextInt();
		int numEdges = sc.nextInt();
		
		for (int i=0; i<=numNodes; i++)
			adj.add(new ArrayList<Integer>());
		
		for (int i=0; i<numEdges; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			adj.get(u).add(v);
			adj.get(v).add(u);
		}
		sc.close();
		
		Queue<Integer> pq = new PriorityQueue<Integer>();
		boolean[] used = new boolean[numNodes+1];
		used[1] = true;
		pq.add(1);
		
		while(!pq.isEmpty()) {
			int next = pq.poll();
			System.out.print(next + " ");
			for (int i=0; i<adj.get(next).size(); i++) {
				if (!used[adj.get(next).get(i)]) {
					pq.add(adj.get(next).get(i));
					used[adj.get(next).get(i)] = true;
				}
			}
		}
		System.out.println();
	}
}
