/*

C - Queen

You are given a rooted tree with vertices numerated from 1 to n. A tree is a connected 
graph without cycles. A rooted tree has a special vertex named root. Ancestors of the 
vertex i are all vertices on the path from the root to the vertex i, except the vertex 
i itself. The parent of the vertex i is the nearest to the vertex i ancestor of i. 
Each vertex is a child of its parent. In the given tree the parent of the vertex i is 
the vertex pi. For the root, the value pi is -1. You noticed that some vertices do not 
respect others. In particular, if ci=1, then the vertex i does not respect any of its 
ancestors, and if ci=0, it respects all of them. You decided to delete vertices from 
the tree one by one. On each step you select such a non-root vertex that it does not 
respect its parent and none of its children respects it. If there are several such 
vertices, you select the one with the smallest number. When you delete this vertex v, 
all children of v become connected with the parent of v. Once there are no vertices 
matching the criteria for deletion, you stop the process. Print the order in which you 
will delete the vertices. Note that this order is unique.

Input
The first line contains a single integer n (1 <= n <= 10^5) — the number of vertices in 
the tree. The next n lines describe the tree: the i-th line contains two integers pi 
and ci (1 <= pi <= n, 0 <= ci <= 1), where pi is the parent of the vertex i, and ci=0, 
if the vertex i respects its parents, and ci=1, if the vertex i does not respect any of 
its parents. The root of the tree has -1 instead of the parent index. ci=0 for the root.
It is guaranteed that the values pi define a rooted tree with n vertices.

Output
In case there is at least one vertex to delete, print the only line containing the 
indices of the vertices you will delete in the order you delete them. Otherwise print 
a single integer -1.

--------------------------------------------------------------------------------------*/

import java.util.*;
public class C1143_Queen {
	
	static class Node {
		public ArrayList<Node> children;
		public boolean respects;
		public int parentIndex;
		
		public Node() {
			children = new ArrayList<Node>();
			respects = false;
			parentIndex = -1;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		Node[] nodes = new Node[n+1];
		for (int i=1; i<=n; i++)
			nodes[i] = new Node();
		
		for (int i=1; i<=n; i++) {
			int parent = sc.nextInt();
			boolean respects = sc.nextInt()==1 ? false : true;
			if (parent != -1)
				nodes[parent].children.add(nodes[i]);
			nodes[i].respects = respects;
			nodes[i].parentIndex = parent;
		}
		sc.close();
		
		boolean nonePrinted = true;
		for (int i=1; i<=n; i++) {
			if (nodes[i].respects == true)
				continue;
			
			boolean good = true;
			for (int j=0; j<nodes[i].children.size(); j++) {
				if (nodes[i].children.get(j).respects == true) {
					good = false;
					break;
				}
			}
			
			if (good) {
				nonePrinted = false;
				System.out.print(i + " ");
				for (int j=0; j<nodes[i].children.size(); j++)
					nodes[i].children.get(j).parentIndex = i;
			}
		}
		
		if (nonePrinted)
			System.out.print(-1);
		System.out.println();
	}
}