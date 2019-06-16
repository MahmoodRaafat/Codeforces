/*

D - Walking Robot

There is a robot staying at X=0 on the Ox axis. He has to walk to X=n. You are controlling 
this robot and controlling how he goes. The robot has a battery and an accumulator with a 
solar panel. The i-th segment of the path (from X=i-1 to X=i) can be exposed to sunlight or 
not. The array s denotes which segments are exposed to sunlight: if segment i is exposed, 
then si=1, otherwise si=0. The robot has one battery of capacity b and one accumulator of 
capacity a. For each segment, you should choose which type of energy storage robot will use 
to go to the next point (it can be either battery or accumulator). If the robot goes using 
the battery, the current charge of the battery is decreased by one (the robot can't use the 
battery if its charge is zero). And if the robot goes using the accumulator, the current 
charge of the accumulator is decreased by one (and the robot also can't use the accumulator 
if its charge is zero). If the current segment is exposed to sunlight and the robot goes 
through it using the battery, the charge of the accumulator increases by one (of course, 
its charge can't become higher than it's maximum capacity). If accumulator is used to pass 
some segment, its charge decreases by 1 no matter if the segment is exposed or not. You 
understand that it is not always possible to walk to X=n. You want your robot to go as far 
as possible. Find the maximum number of segments of distance the robot can pass if you 
control him optimally.

Input
The first line of the input contains three integers n, b, a (1 <= n,b,a <= 2*10^5) — the 
robot's destination point, the battery capacity and the accumulator capacity, respectively.
The second line of the input contains n integers s1, s2, ..., sn (0 <= si <= 1), where si 
is 1 if the i-th segment of distance is exposed to sunlight, and 0 otherwise.

Output
Print one integer — the maximum number of segments the robot can pass if you control him 
optimally.

------------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class D1154_WalkingRobot {

	public static void main(String[] args) {
		InputReader in = new InputReader();
		int n = in.nextInt();
		int b = in.nextInt();
		int aCapacity = in.nextInt();
		
		int distTravelled = 0, a = aCapacity;
		for (int i=0; i<n; i++) {
			int next = in.nextInt();
			if (a == aCapacity || b == 0) {
				if (a == 0)
					break;
				--a;
			}
			else if (next == 1) {
				--b;
				++a;
			}
			else {
				if (a > 0)
					--a;
				else
					--b;
			}
			++distTravelled;
		}
		
		System.out.println(distTravelled);
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