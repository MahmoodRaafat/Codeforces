/*

E - Cover It!

You are given an undirected unweighted connected graph consisting of n vertices and m edges. It 
is guaranteed that there are no self-loops or multiple edges in the given graph. Your task is to 
choose at most n/2 vertices in this graph so each unchosen vertex is adjacent (in other words, 
connected by an edge) to at least one of chosen vertices. It is guaranteed that the answer 
exists. If there are multiple answers, you can print any. You will be given multiple independent 
queries to answer.

Input
The first line contains a single integer t (1 <= t <= 2*10^5) — the number of queries. Then t
queries follow. The first line of each query contains two integers n and m (2 <= n <= 2*10^5, 
n-1 <= m <= min(2*10^5, n*(n-1)/2)) — the number of vertices and the number of edges, 
respectively. The following m lines denote edges: edge i is represented by a pair of integers 
vi, ui (1 <= vi, ui <= n, ui != vi), which are the indices of vertices connected by the edge.
It is guaranteed that the given graph is connected. It is guaranteed that the sum of all m 
values over all queries is <= 2*10^5.

Output
For each query print two lines. In the first line print k(1 <= n/2) — the number of chosen 
vertices. In the second line print k distinct integers c1, c2, ..., ck in any order, where ci 
is the index of the i-th chosen vertex. It is guaranteed that the answer exists. If there are 
multiple answers, you can print any.

----------------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class E1176_CoverIt {
	
	static ArrayList<Integer> set1 = new ArrayList<>();
	static ArrayList<Integer> set2 = new ArrayList<>();
	
	static class Node {
		int index;
		int set;
		ArrayList<Integer> adj;
		
		public Node(int i) {
			index = i;
			adj = new ArrayList<>();
			set = 0;
		}
		
		public void addNode(int u) {
			adj.add(u);
		}
		
		public boolean isInSet() {
			return set != 0;
		}
		
		public void addToSet(int s) {
			set = s;
			if (set == 1)
				set1.add(index);
			else
				set2.add(index);
		}
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader();
		int T = in.nextInt();
		
		StringBuffer sb = new StringBuffer();
		while (T-- > 0) {
			int n = in.nextInt();
			int m = in.nextInt();
			
			Node[] nodes = new Node[n];
			for (int i=0; i<n; i++)
				nodes[i] = new Node(i);
			
			for (int i=0; i<m; i++) {
				int u = in.nextInt() - 1;
				int v = in.nextInt() - 1;
				nodes[u].addNode(v);
				nodes[v].addNode(u);
			}
			
			Queue<Node> q = new ArrayDeque<>();
			q.add(nodes[0]);
			nodes[0].addToSet(1);
			while (!q.isEmpty())
				bfs(q, nodes);
			
			if (set1.size() < set2.size()) {
				sb.append(set1.size() + "\n");
				for (int i: set1)
					sb.append((i+1) + " ");
				sb.append("\n");
			}
			else {
				sb.append(set2.size() + "\n");
				for (int i: set2)
					sb.append((i+1) + " ");
				sb.append("\n");
			}
			
			set1.clear();
			set2.clear();
		}
		System.out.print(sb);
	}
	
	public static void bfs(Queue<Node> q, Node[] nodes) {
		Node node = q.poll();
		int set = node.set == 1 ? 2 : 1;
		for (int i: node.adj) if (!nodes[i].isInSet()) {
			nodes[i].addToSet(set);
			q.add(nodes[i]);
		}
	}

	static class InputReader {
		public BufferedReader br;
		public StringTokenizer st;
		
		public InputReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = null;
		}
		
		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				}
				catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return st.nextToken();
		}
		
		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
