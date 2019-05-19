/*

C - News Distribution

In some social network, there are n users communicating with each other in m groups of 
friends. Initially, some user x receives news from some source. Then they send the news
to their friends (two users are friends if there is at least one group such that both 
of them belong to this group). Friends continue sending the news to their friends, and 
so on. The process ends when there is no pair of friends such that one of them knows 
the news, and another one doesn't know. For each user x you have to determine what is 
the number of users that will know the news if initially only user x starts 
distributing it.

Input
The first line contains two integers n and m (1 <= n, m <= 5*10^5) — the number of 
users and the number of groups of friends, respectively. Then m lines follow, each 
describing a group of friends. The i-th line begins with integer ki (0 <= ki <= n) — 
the number of users in the i-th group. Then ki distinct integers follow, denoting the 
users belonging to the i-th group. It is guaranteed that the sum of all ki values is 
less than 5*10^5.

Output
Print n integers. The i-th integer should be equal to the number of users that will 
know the news if user i starts distributing it.

---------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class C1167_NewsDistribution {
	
	static Person[] people;
	
	static class Person {
		public ArrayList<Integer> adj;
		public int group;
		
		public Person() {
			adj = new ArrayList<Integer>();
			group = 0;
		}
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader();
		int numPeople = in.nextInt();
		int numGroups = in.nextInt();
		
		people = new Person[numPeople];
		for (int i=0; i<numPeople; i++)
			people[i] = new Person();
		
		for (int i=0; i<numGroups; i++) {
			int ppl = in.nextInt();
			if (ppl == 0)
				continue;
			
			int prev = in.nextInt() - 1;
			for (int j=1; j<ppl; j++) {
				int person = in.nextInt() - 1;
				people[person].adj.add(prev);
				people[prev].adj.add(person);
			}
		}
		
		int numComponents = -1;
		ArrayList<Integer> groups = new ArrayList<Integer>();
		boolean[] visited = new boolean[numPeople];
		for (int i=0; i<numPeople; i++) if (!visited[i]) {
			groupSize = 0;
			dfs(i, ++numComponents, visited);
			groups.add(groupSize);
		}
		
		StringBuffer sb = new StringBuffer();
		for (Person p: people)
			sb.append(groups.get(p.group) + " ");
		System.out.println(sb);
	}
	
	static int groupSize;
	public static void dfs(int person, int groupNum, boolean[] visited) {
		++groupSize;
		people[person].group = groupNum;
		visited[person] = true;
		for (int i: people[person].adj) 
			if (!visited[i])
				dfs(i, groupNum, visited);
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