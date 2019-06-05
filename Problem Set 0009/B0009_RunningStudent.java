/*

B - Running Student

And again a misfortune fell on Poor Student. He is being late for an exam. Having rushed 
to a bus stop that is in point (0, 0), he got on a minibus and they drove along a straight 
line, parallel to axis OX, in the direction of increasing x. Poor Student knows the 
following: (1) during one run the minibus makes n stops, the i-th stop is in point (xi, 0).
(2) coordinates of all the stops are different. (3) the minibus drives at a constant speed, 
equal to vb. (4) it can be assumed the passengers get on and off the minibus at a bus stop 
momentarily. (5) Student can get off the minibus only at a bus stop. (6) Student will have 
to get off the minibus at a terminal stop, if he does not get off earlier. (7) the 
University, where the exam will be held, is in point (xu, yu). (8) Student can run from a 
bus stop to the University at a constant speed vs as long as needed. (9) Student is already 
on the minibus, so, he cannot get off at the first bus stop. Poor Student wants to get to 
the University as soon as possible. Help him to choose the bus stop, where he should get 
off. If such bus stops are multiple, choose the bus stop closest to the University.

Input
The first line contains three integer numbers: (2 <= n <= 100, 1 <= vb, vs <= 1000). The 
second line contains n non-negative integers in ascending order: coordinates xi of the 
bus stop with index i. It is guaranteed that x1 equals to zero, and xn <= 10^5. The third 
line contains the coordinates of the University, integers xu and yu, not exceeding 10^5 
in absolute value.

Output
In the only line output the answer to the problem — index of the optimum bus stop.

-----------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class B0009_RunningStudent {

	public static void main(String[] args) {
		InputReader in = new InputReader();
		int n = in.nextInt();
		int busSpeed = in.nextInt();
		int studentSpeed = in.nextInt();
		
		long[] stops = new long[n];
		for (int i=0; i<n; i++) 
			stops[i] = in.nextInt();
		
		long xf = in.nextInt();
		long yf = in.nextInt();

		int res = 0;
		double shortestTime = Integer.MAX_VALUE, resDist = -1;
		for (int i=1; i<n; i++) {
			double dist = Math.sqrt((xf-stops[i])*(xf-stops[i]) + yf*yf);
			double time = (double) stops[i]/busSpeed + dist/studentSpeed;
			
			if (Math.abs(shortestTime - time) < 0.000001) {
				if (dist < resDist) {
					resDist = dist;
					res = i;
				}
			}
			
			if (time < shortestTime) {
				shortestTime = time;
				res = i;
				resDist = dist;
			}
		}
		
		System.out.println(res+1);
	}
	
	static class InputReader {
		public BufferedReader br;
		public StringTokenizer st;
		
		public InputReader() {
			st = null;
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st= new StringTokenizer(br.readLine());
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