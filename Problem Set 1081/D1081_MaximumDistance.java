/*

D - Maximum Distance

You are given a connected undirected graph with n vertices and m weighted edges. There are k 
special vertices: x1, x2, ..., xk. Let's define the cost of the path as the maximum weight of the 
edges in it. And the distance between two vertexes as the minimum cost of the paths connecting 
them. For each special vertex, find another special vertex which is farthest from it (i.e. the 
corresponding distance is maximum possible) and output the distance between them.

Input
The first line contains three integers n, m and k (2 <= k <= n <= 10^5, n-1 <= m <= 10^5) — the 
number of vertices, the number of edges and the number of special vertices. The second line 
contains k distinct integers x1, x2, ..., xk (1 <= xi <= n). Each of the following m lines 
contains three integers u, v and w (1 <= u, v <= n, 1 <= w <= 10^9), denoting there is an edge 
between u and v of weight w. The given graph is undirected, so an edge (u,v) can be used in both 
directions. The graph may have multiple edges and self-loops. It is guaranteed, that the graph is 
connected.

Output
The first and only line should contain k integers. The i-th integer is the distance between xi and 
the farthest special vertex from it.

--------------------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class D1081_MaximumDistance {
	
	static Vertex[] vs;
	
	static class Vertex {
		int root;
		int subtreeSize;
		int numSpecial; // in subtree
		
		public Vertex(int r) {
			root = r;
			subtreeSize = 1;
			numSpecial = 0;
		}
		
		public void addSpecial(int s) {
			numSpecial += s;
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int U;
		int V;
		int weight;
		
		public Edge(int u, int v, int W) {
			U = u;
			V = v;
			weight = W;
		}

		public int compareTo(Edge e) {
			return Integer.compare(weight, e.weight);
		}
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader();
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		
		vs = new Vertex[n];
		for (int i=0; i<n; i++)
			vs[i] = new Vertex(i);
		
		
		for (int i=0; i<k; i++)
			vs[in.nextInt()-1].addSpecial(1);
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int i=0; i<m; i++) {
			int u = in.nextInt()-1;
			int v = in.nextInt()-1;
			int w = in.nextInt();
			if (u != v)
				pq.add(new Edge(u, v, w));
		}
		
		int largestWeight = 0;
		while (true) {
			Edge e = pq.poll();
			int rootU = findRoot(e.U);
			int rootV = findRoot(e.V);
			if (rootU != rootV) {
				largestWeight = e.weight;
				if (merge(rootU, rootV, k))
					break;
			}
		}
		
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<k; i++)
			sb.append(largestWeight + " ");
		System.out.println(sb);
	}
	
	public static int findRoot(int cur) {
		return vs[cur].root == cur ? cur : findRoot(vs[cur].root);
	}
	
	public static boolean merge(int u, int v, int k) {
		if (vs[v].numSpecial + vs[u].numSpecial == k)
			return true;
		if (vs[u].subtreeSize < vs[v].subtreeSize) {
			vs[u].root = v;
			vs[v].subtreeSize += vs[u].subtreeSize;
			vs[v].addSpecial(vs[u].numSpecial);
		}
		else {
			vs[v].root = u;
			vs[u].subtreeSize += vs[v].subtreeSize;
			vs[u].addSpecial(vs[v].numSpecial);
		}
		return false;
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