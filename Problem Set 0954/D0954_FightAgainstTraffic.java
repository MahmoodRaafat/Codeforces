/*

D - Fight Against Traffic

Little town Nsk consists of n junctions connected by m bidirectional roads. Each road connects two 
distinct junctions and no two roads connect the same pair of junctions. It is possible to get from 
any junction to any other junction by these roads. The distance between two junctions is equal to 
the minimum possible number of roads on a path between them. In order to improve the transportation 
system, the city council asks mayor to build one new road. The problem is that the mayor has just 
bought a wonderful new car and he really enjoys a ride from his home, located near junction s to 
work located near junction t. Thus, he wants to build a new road in such a way that the distance 
between these two junctions won't decrease. You are assigned a task to compute the number of pairs 
of junctions that are not connected by the road, such that if the new road between these two 
junctions is built the distance between s and t won't decrease.

Input
The first line of the input contains integers n, m, s and t (2 <= n <= 1000, 1 <= m <= 1000, 
1 <= s, t <= n, s != t) - the number of junctions and the number of roads in Nsk, as well as the 
indices of junctions where mayors home and work are located respectively. The i-th of the 
following m lines contains two integers ui and vi (1 <= ui, vi <= n, ui != vi), meaning that this 
road connects junctions ui and vi directly. It is guaranteed that there is a path between any two 
junctions and no two roads connect the same pair of junctions.

Output
Print one integer — the number of pairs of junctions not connected by a direct road, such that 
building a road between these two junctions won't decrease the distance between junctions s and t.

-------------------------------------------------------------------------------------------------*/

import java.util.*;
public class D0954_FightAgainstTraffic {
	static Queue<Node> q = new ArrayDeque<Node>();
	static int s, t;
	
	static class Node {
		public int index;
		public int distS;
		public int distT;
		ArrayList<Integer> adj;
		
		public Node(int i, int s, int t) {
			index = i;
			distS = s;
			distT = t;
			adj = new ArrayList<Integer>();
		}
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		s = sc.nextInt() - 1;
		t = sc.nextInt() - 1;
		
		Node[] nodes = new Node[n];
		for (int i=0; i<n; i++)
			nodes[i] = new Node(i, 0, 0);
		
		for (int i=0; i<m; i++) {
			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;
			nodes[u].adj.add(v);
			nodes[v].adj.add(u);
		}
		sc.close();
		
		findDist(n, nodes, s);
		findDist(n, nodes, t);
		
		int minDist = nodes[s].distT, res = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (i != j && !nodes[i].adj.contains(j)) {
					int dist1 = nodes[i].distS + nodes[j].distT + 1;
					int dist2 = nodes[j].distS + nodes[i].distT + 1;
					if (dist1 >= minDist && dist2 >= minDist)
						res++;
				}
			}
		}
		System.out.println(res/2);
	}
	
	public static void findDist(int n, Node[] nodes, int index) {
		boolean[] visited = new boolean[n];
		q.add(nodes[index]);
		visited[index] = true;
		while (!q.isEmpty())
			bfs(visited, nodes, index);
	}
	
	public static void bfs(boolean[] visited, Node[] nodes, int index) {
		Node node = q.poll();
		for (int i=0; i<node.adj.size(); i++) {
			if (!visited[node.adj.get(i)]) {
				visited[node.adj.get(i)] = true;
				q.add(nodes[node.adj.get(i)]);
				if (index==s)
					nodes[node.adj.get(i)].distS = node.distS + 1;
				else
					nodes[node.adj.get(i)].distT = node.distT + 1;
			}
		}
	}
}