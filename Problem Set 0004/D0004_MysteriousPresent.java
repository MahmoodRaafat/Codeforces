/*

D - Mysterious Present

Peter decided to wish happy birthday to his friend from Australia and send him a card. 
To make his present more mysterious, he decided to make a chain. Chain here is such a 
sequence of envelopes A = {a1, a2, ..., an}, where the width and the height of the i-th 
envelope is strictly higher than the width and the height of the (i-1)-th envelope 
respectively. Chain size is the number of envelopes in the chain. Peter wants to make 
the chain of the maximum size from the envelopes he has, the chain should be such, that 
he'll be able to put a card into it. The card fits into the chain if its width and 
height is lower than the width and the height of the smallest envelope in the chain 
respectively. It's forbidden to turn the card and the envelopes. Peter has very many 
envelopes and very little time, this hard task is entrusted to you.

Input
The first line contains integers n, w, h (1 <= n <= 5000, 1 <= w, h <= 10^6) - amount 
of envelopes Peter has, the card width and height respectively. Then there follow n 
lines, each of them contains two integer numbers wi and hi — width and height of the 
i-th envelope (1 <= wi, hi <= 10^6).

Output
In the first line print the maximum chain size. In the second line print the numbers 
of the envelopes (separated by space), forming the required chain, starting with the 
number of the smallest envelope. Remember, please, that the card should fit into the 
smallest envelope. If the chain of maximum size is not unique, print any of the 
answers. If the card does not fit into any of the envelopes, print number 0 in the 
single line.

--------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class D0004_MysteriousPresent {
	
	static int[] dp, prev;
	
	static class Envelope implements Comparable<Envelope> {
		public int width;
		public int height;
		public int index;
		
		public Envelope(int w, int h, int i) {
			width = w;
			height = h;
			index = i;
		}

		public int compareTo(Envelope e) {
			if (width == e.width)
				return Integer.compare(height, e.height);
			return Integer.compare(width, e.width);
		}
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader();
		int numEnvelopes = in.nextInt();
		int cardWidth = in.nextInt();
		int cardHeight = in.nextInt();
		
		ArrayList<Envelope> list = new ArrayList<Envelope>();
		for (int i=1; i<=numEnvelopes; i++) {
			int w = in.nextInt();
			int h = in.nextInt();
			if (w > cardWidth && h > cardHeight)
				list.add(new Envelope(w, h, i));
		}
		
		list.add(new Envelope(cardWidth, cardHeight, 0));
		Collections.sort(list);
		prev = new int[list.size()];
		dp = new int[list.size()];
		
		int maxChainLength = findMaxChainLength(list);
		System.out.println(maxChainLength);
		printSequence(list, maxChainLength);
	}
	
	public static int findMaxChainLength(ArrayList<Envelope> list) {
		int maxChainLength = 0;
		for (int i=1; i<list.size(); i++) {
			int curMax = 0, bestPrevEnvelope = 0;
			for (int j=0; j<i; j++) {
				if (canFit(list.get(j), list.get(i))) {
					curMax = Math.max(curMax, dp[j]+1);
					if (curMax == dp[j]+1)
						bestPrevEnvelope = j;
				}
			}
			dp[i] = curMax;
			maxChainLength = Math.max(maxChainLength, curMax);
			prev[i] = bestPrevEnvelope;
		}
		return maxChainLength;
	}
	
	public static void printSequence(ArrayList<Envelope> list, int chainLength) {
		int lastEnvelope = findLastEnvelope(list, chainLength);
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int curPos = lastEnvelope;
		for (int i=0; i<chainLength; i++) {
			ans.add(list.get(curPos).index);
			curPos = prev[curPos];
		}
		
		for (int i=ans.size()-1; i>=0; i--)
			System.out.print(ans.get(i) + " ");
		System.out.println();
	}
	
	public static int findLastEnvelope(ArrayList<Envelope> list, int chainLength) {
		int lastEnvelope = 0;
		for (int i=list.size()-1; i>=0; i--) {
			if (dp[i]==chainLength) {
				lastEnvelope = i;
				break;
			}
		}
		return lastEnvelope;
	}
	
	public static boolean canFit(Envelope inner, Envelope outer) {
		return inner.width < outer.width && inner.height < outer.height;
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