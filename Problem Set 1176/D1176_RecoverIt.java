/*

D - Recover It!

Authors guessed an array a consisting of n integers; each integer is not less than 2 and not 
greater than 2*10^5. You don't know the array a, but you know the array b which is formed from 
it with the following sequence of operations: Firstly, let the array b be equal to the array a;
Secondly, for each i from 1 to n: if ai is a prime number, then one integer pai is appended to 
array b, where p is an infinite sequence of prime numbers (2, 3, 5, ...); otherwise (if ai is 
not a prime number), the greatest divisor of ai which is not equal to ai is appended to b; Then 
the obtained array of length 2n is shuffled and given to you in the input. Here pai means the 
ai-th prime number. The first prime p1=2, the second one is p2=3, and so on. Your task is to 
recover any suitable array a that forms the given array b. It is guaranteed that the answer 
exists (so the array b is obtained from some suitable array a). If there are multiple answers, 
you can print any.

Input
The first line of the input contains one integer n (1 <= n <= 2*10^5) — the number of elements 
in a. The second line of the input contains 2n integers b1, b2, ..., b2n (2 <= bi <= 2750131), 
where bi is the i-th element of b. 2750131 is the 199999-th prime number.

Output
In the only line of the output print n integers a1, a2, ..., an (2 <= ai <= 2*10^5) in any order 
— the array a from which the array b can be obtained using the sequence of moves given in the 
problem statement. If there are multiple answers, you can print any.

-----------------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class D1176_RecoverIt {
	
	static int LIM = 2750131;
	
	public static void main(String[] args) {
		InputReader in = new InputReader();
		int n = in.nextInt();
		
		ArrayList<Integer> list = new ArrayList<>();
		for (int i=0; i<2*n; i++)
			list.add(in.nextInt());
		Collections.sort(list);
		
		boolean[] isComposite = new boolean[LIM + 1];
		Map<Integer, Integer> primes = new HashMap<>();
		int[] maxDiv = new int[LIM + 1];
		findPrimes(primes, isComposite, maxDiv);
		calcMaxDivisors(maxDiv);
		
		StringBuffer sb = new StringBuffer();
		Map<Integer, Integer> used = new HashMap<>();
		while (!list.isEmpty()) {
			int num = list.remove(list.size()-1);
			if (used.containsKey(num)) {
				if (used.get(num) > 1)
					used.put(num, used.get(num) - 1);
				else
					used.remove(num);
				continue;
			}
			if (isComposite[num]) {
				sb.append(num + " ");
				markUsed(used, maxDiv[num]);
			}
			else {
				sb.append(primes.get(num) + " ");
				markUsed(used, primes.get(num));
			}
		}
		sb.append("\n");
		System.out.println(sb);
	}
	
	public static void markUsed(Map<Integer, Integer> used, int n) {
		if (!used.containsKey(n))
			used.put(n, 1);
		else
			used.put(n, used.get(n) + 1);
	}
	
	public static void findPrimes(Map<Integer, Integer> primes, boolean[] isComposite, int[] maxDiv) {
		int numPrimes = 0;
		for (int i=2; i<=LIM; i++) if (!isComposite[i]) {
			++numPrimes;
			primes.put(i, numPrimes);
			for (int j=i+i; j<LIM; j+=i) {
				isComposite[j] = true;
				if (maxDiv[j] == 0)
					maxDiv[j] = i;
			}
		}
	}
	
	public static void calcMaxDivisors(int[] maxDiv) {
		for (int i=0; i<=LIM; i++) 
			if (maxDiv[i] != 0)
				maxDiv[i] = i/maxDiv[i];
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