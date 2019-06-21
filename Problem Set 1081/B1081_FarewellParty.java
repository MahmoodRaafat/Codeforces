/*

B - Farewell Party

Chouti and his classmates are going to the university soon. To say goodbye to each other, the 
class has planned a big farewell party in which classmates, teachers and parents sang and 
danced. Chouti remembered that n persons took part in that party. To make the party funnier, 
each person wore one hat among n kinds of weird hats numbered 1, 2, ..., n. It is possible that 
several persons wore hats of the same kind. Some kinds of hats can remain unclaimed by anyone.
After the party, the i-th person said that there were ai persons wearing a hat differing from 
his own. It has been some days, so Chouti forgot all about others' hats, but he is curious about 
that. Let bi be the number of hat type the i-th person was wearing, Chouti wants you to find any 
possible b1, b2, ..., bn that doesn't contradict with any person's statement. Because some 
persons might have a poor memory, there could be no solution at all.

Input
The first line contains a single integer n (1 <= n <= 10^5), the number of persons in the party. 
The second line contains n integers a1, a2, ..., an (0 <= ai <= n-1), the statements of people.

Output
If there is no solution, print a single line "Impossible". Otherwise, print "Possible" and then 
n integers b1, b2, ..., bn (1 <= bi <= n). If there are multiple answers, print any of them.

-----------------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class B1081_FarewellParty {
	
	public static void main(String[] args) {
		InputReader in = new InputReader();
		int n = in.nextInt();

		int[] res = new int[n];
		Map<Integer, int[]> map = new HashMap<>();
		int hatIndex = 0, numHatsRemaining = n;
		for (int i=0; i<n; i++) {
			int num = in.nextInt();
			if (!map.containsKey(num)) {
				++hatIndex;
				res[i] = hatIndex;
				numHatsRemaining -= n-num;
				if (numHatsRemaining < 0) {
					System.out.println("Impossible");
					return;
				}
				if (n-num-1 > 0) {
					int[] arr = {n-num-1, hatIndex};
					map.put(num, arr);
				}
			}
			else {
				res[i] = map.get(num)[1];
				if (map.get(num)[0] == 1)
					map.remove(num);
				else {
					int[] arr = {map.get(num)[0]-1, map.get(num)[1]};
					map.put(num, arr);
				}
			}
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append("Possible\n");
		for (int i: res)
			sb.append(i + " ");
		System.out.println(sb);
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