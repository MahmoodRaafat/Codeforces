/*

C - Two Shuffled Sequences

Two integer sequences existed initially — one of them was strictly increasing, and the 
other one — strictly decreasing. Note that the empty sequence and the sequence consisting 
of one element can be considered as increasing or decreasing. They were merged into one 
sequence a. After that sequence a got shuffled. For example, some of the possible resulting 
sequences a for an increasing sequence [1,3,4] and a decreasing sequence [10,4,2] are 
sequences [1,2,3,4,4,10] or [4,2,1,10,4,3]. This shuffled sequence a is given in the input.
Your task is to find any two suitable initial sequences. One of them should be strictly 
increasing and the other one — strictly decreasing. 

Input
The first line of the input contains one integer n (1 <= n <= 2*10^5) — the number of 
elements in a. The second line of the input contains n integers a1, a2, ..., an 
(0 <= ai <= 2*10^5), where ai is the i-th element of a.

Output
If there is a contradiction in the input and it is impossible to split the given sequence a
to increasing and decreasing sequences, print "NO" in the first line. Otherwise print "YES" 
in the first line and any two suitable sequences. In the second line print ni — the number 
of elements in the strictly increasing sequence. ni can be zero, in this case the increasing 
sequence is empty. In the third line print ni integers inc1, inc2, ..., incni in the 
increasing order of its values — the strictly increasing sequence itself. You can keep this 
line empty if ni=0 (or just print the empty line). In the fourth line print nd — the number 
of elements in the strictly decreasing sequence. nd can be zero, in this case the 
decreasing sequence is empty. In the fifth line print nd integers in the decreasing order of 
its values — the strictly decreasing sequence itself. You can keep this line empty if nd=0
(or just print the empty line). ni+nd should be equal to n and the union of printed 
sequences should be a permutation of the given sequence (in case of "YES" answer).

-------------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class C1144_TwoShuffledSequences {

	public static void main(String[] args) {
		InputReader in = new InputReader();
		
		int n = in.nextInt();
		Map<Integer, Integer> map = new HashMap<>();
		PriorityQueue<Integer> duplicates = new PriorityQueue<Integer>();
		
		for (int i=0; i<n; i++) {
			int num = in.nextInt();
			if (!map.containsKey(num))
				map.put(num, 1);
			else {
				int val = map.get(num) + 1;
				if (val > 2) {
					System.out.println("NO");
					System.exit(0); // end program
				}
				map.put(num, val);
				duplicates.add(num);
			}
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append("YES\n");
		
		sb.append(duplicates.size() + "\n");
		while (!duplicates.isEmpty())
			sb.append(duplicates.poll() + " ");
		sb.append("\n");
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (int i: map.keySet())
			nums.add(i);
		Collections.sort(nums);
		
		sb.append(nums.size() + "\n");
		for (int i=nums.size()-1; i>=0; i--)
			sb.append(nums.get(i) + " ");
		sb.append("\n");
		
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