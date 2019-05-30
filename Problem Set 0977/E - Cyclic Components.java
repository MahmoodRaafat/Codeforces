/*

E - Cyclic Components

You are given an undirected graph consisting of n vertices and m edges. Your task 
is to find the number of connected components which are cycles. Here are some 
definitions of graph theory. An undirected graph consists of two sets: set of 
nodes (called vertices) and set of edges. Each edge connects a pair of vertices. 
All edges are bidirectional (i.e. if a vertex a is connected with a vertex b, a 
vertex b is also connected with a vertex a). An edge can't connect vertex with 
itself, there is at most one edge between a pair of vertices. Two vertices u and 
v belong to the same connected component if and only if there is at least one 
path along edges connecting u and v. A connected component is a cycle if and only 
if its vertices can be reordered in such a way that: the first vertex is connected 
with the second vertex by an edge, the second vertex is connected with the third 
vertex by an edge, ..., the last vertex is connected with the first vertex by an 
edge, all the described edges of a cycle are distinct. A cycle doesn't contain any 
other edges except described above. By definition any cycle contains three or more 
vertices.

Input
The first line contains two integer numbers n and m (1 <= n <= 2*10^5, 
0 <= m <= 2*10^5) - number of vertices and edges. The following m lines contains 
edges: edge i is given as a pair of vertices vi, ui (1 <= vi, ui <= n, ui != vi). 
There is no multiple edges in the given graph, i.e. for each pair (vi,ui) there 
no other pairs (vi,ui) and (ui,vi) in the list of edges.

Output
Print one integer - the number of connected components which are also cycles.

-----------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class E0997_CyclicComponents {
	
	static class Vertex {
		ArrayList<Vertex> adj;
		boolean visited;
		
		public Vertex() {
			adj = new ArrayList<>();
			visited = false;
		}
	}

	public static void main(String[] args) {
		InputReader in = new InputReader();
		int numVertices = in.nextInt();
		int numEdges = in.nextInt();
		
		Vertex[] vertices = new Vertex[numVertices];
		for (int i=0; i<numVertices; i++) {
			vertices[i] = new Vertex();
		}
		
		for (int i=0; i<numEdges; i++) {
			int u = in.nextInt() - 1;
			int v = in.nextInt() - 1;
			vertices[u].adj.add(vertices[v]);
			vertices[v].adj.add(vertices[u]);
		}
		
		int res = 0;
		for (Vertex v: vertices) if (!v.visited) {
			isCyclicComponent = true;
			dfs(v);
			if (isCyclicComponent)
				++res;
		}
		System.out.println(res);
	}
	
	static boolean isCyclicComponent;
	public static void dfs(Vertex cur) {
		cur.visited = true;
		if (cur.adj.size() != 2)
			isCyclicComponent = false;
		for (Vertex v: cur.adj) if (!v.visited)
			dfs(v);
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
