import java.io.*;
import java.util.*;
public class E1144_MedianString {
	
	public static void main(String[] args) {
		InputReader in = new InputReader();
		int n = in.nextInt();
		String str1 = in.next();
		String str2 = in.next();
		
		int[] fs = new int[n+1];
		int[] ss = new int[n+1];
		for (int i=0; i<n; i++) {
			fs[i+1] = str1.charAt(i) - 'a';
			ss[i+1] = str2.charAt(i) - 'a';
		}
		
		int[] avg = new int[n+1];
		for (int i=n; i>0; i--) {
			int sum = avg[i] + fs[i] + ss[i];
			if (sum >= 26) {
				avg[i] = sum - 26;
				avg[i-1]++;
			}
			else
				avg[i] = sum;
		}
		
		for (int i=0; i<=n; i++) {
			if (avg[i]%2==1) {
				avg[i]--;
				avg[i+1] += 26;
			}
			avg[i] /= 2;
		}
		
		StringBuffer sb = new StringBuffer();
		for (int i=1; i<=n; i++)
			sb.append((char) (avg[i] + 'a'));
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
