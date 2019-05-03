/*

F - Graph Without Long Directed Paths

You are given a connected undirected graph consisting of n vertices and m edges. There are 
no self-loops or multiple edges in the given graph. You have to direct its edges in such a 
way that the obtained directed graph does not contain any paths of length two or greater 
(where the length of path is denoted as the number of traversed edges).

Input
The first line contains two integer numbers n and m (2 <= n <= 2*10^5, n-1 <= m <= 2*10^5) — 
the number of vertices and edges, respectively. The following m lines contain edges: edge i 
is given as a pair of vertices ui, vi (1 <= ui, vi <= n, ui != vi). There are no multiple 
edges in the given graph, i.e. for each pair (ui, vi) there are no other pairs (ui, vi) and 
(vi, ui) in the list of edges. It is also guaranteed that the given graph is connected (there 
is a path between any pair of vertex in the given graph).

Output
If it is impossible to direct edges of the given graph in such a way that the obtained 
directed graph does not contain paths of length at least two, print "NO" in the first line.
Otherwise print "YES" in the first line, and then print any suitable orientation of edges: a 
binary string (the string consisting only of '0' and '1') of length m. The i-th element of 
this string should be '0' if the i-th edge of the graph should be directed from ui to vi, and 
'1' otherwise. Edges are numbered in the order they are given in the input.

-------------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class F1144_GraphWithoutLongDirectedPaths {
	
	static class Node {
		ArrayList<Edge> adj;
		
		public Node() {
			adj = new ArrayList<Edge>();
		}
	}
	
	static class Edge {
		int index;
		int u;
		int v;
		int orientation; // u-->v == 0; v-->u == 1
		
		public Edge(int i, int start, int end) {
			index = i;
			u = start;
			v = end;
		}
	}

	public static void main(String[] args) {
		InputReader in = new InputReader();
		
		int numNodes = in.nextInt();
		int numEdges = in.nextInt();
		
		Node[] nodes = new Node[numNodes];
		Edge[] edges = new Edge[numEdges];
		
		for (int i=0; i<numNodes; i++)
			nodes[i] = new Node();
		
		for (int i=0; i<numEdges; i++) {
			int u = in.nextInt()-1;
			int v = in.nextInt()-1;
			edges[i] = new Edge(i, u, v);
			nodes[u].adj.add(edges[i]);
			nodes[v].adj.add(edges[i]);
		}
		
		for (Edge e: nodes[0].adj)
			e.orientation = e.u==0 ? 1 : 0;
		for (Edge e: nodes[0].adj) {
			int dest = e.u==0 ? e.v : e.u;
			dfs(dest, e.index, nodes, edges);
		}
		
		System.out.println("YES");
		StringBuffer sb = new StringBuffer();
		for (Edge edge: edges)
			sb.append("" + edge.orientation);
		System.out.println(sb);
	}
	
	public static void dfs(int curNode, int prevEdge, Node[] nodes, Edge[] edges) {
		Node node = nodes[curNode];
		Edge prev = edges[prevEdge];
		boolean in = false;
		if ((prev.orientation==0 && prev.v == curNode) || 
			(prev.orientation==1 && prev.u == curNode))
			in = true;
		for (Edge e: node.adj) if (e.index != prevEdge) {
			int orientation = ((in && curNode==e.u) || (!in && curNode == e.v)) ? 1 : 0;
			if (e.orientation == -1) {
				e.orientation = orientation;
				int dest = curNode == e.u ? e.v : e.u;
				dfs(dest, e.index, nodes, edges);
			}
			else {
				if (e.orientation != orientation) {
					System.out.println("NO");
					System.exit(0); // end program
				}
			}
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
			while(st == null || !st.hasMoreTokens()) {
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
