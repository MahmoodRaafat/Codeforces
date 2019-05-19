/*

D - Follow Traffic Rules

Everybody knows that the capital of Berland is connected to Bercouver (the Olympic 
capital) by a direct road. To improve the road's traffic capacity, there was placed 
just one traffic sign, limiting the maximum speed. Traffic signs in Berland are a bit 
peculiar, because they limit the speed only at that point on the road where they are 
placed. Right after passing the sign it is allowed to drive at any speed. It is known 
that the car of an average Berland citizen has the acceleration (deceleration) speed of 
a km/h2, and has maximum speed of v km/h. The road has the length of l km, and the 
speed sign, limiting the speed to w km/h, is placed d km (1 <= d <= l) away from the 
capital of Berland. The car has a zero speed at the beginning of the journey. Find the 
minimum time that an average Berland citizen will need to get from the capital to 
Bercouver, if he drives at the optimal speed. The car can enter Bercouver at any speed.

Input
The first line of the input file contains two integer numbers a and v 
(1 <= a, v, <= 10000). The second line contains three integer numbers l, d and w 
(2 <= l <= 10000; 1 <= d <= l; 1 <= w <= 10000).

Output
Print the answer with at least five digits after the decimal point.

--------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class D0005_FollowTrafficRules {

	public static void main(String[] args) {
		InputReader in = new InputReader();
		System.out.println(solve(in));
	}
	
	public static double solve(InputReader in) {
		double a = in.nextDouble();
		double v = in.nextDouble();
		double l = in.nextDouble();
		double d = in.nextDouble();
		double w = in.nextDouble();
		
		// sign has no effect
		double speedAtSign = Math.sqrt(2*a*d);
		if (w >= v || speedAtSign <= w)
			return finish(v, 0, a, l);
		
		// time before sign
		double time = w/a;
		double distRem = d - (w*w)/(2*a);
		double vf = Math.sqrt(w*w + 2*a*(distRem/2));
		if (vf <= v)
			time += 2*((vf-w)/a);
		else {
			double distToMaxSpeed = (v*v - w*w)/(2*a);
			distRem -= 2*distToMaxSpeed;
			time += 2*((v-w)/a) + distRem/v;
		}
		
		return time + finish(v, w, a, l-d);
	}
	
	public static double finish(double vf, double v0, double a, double dx) {
		double distToMaxSpeed = (vf*vf-v0*v0)/(2*a);
		if (distToMaxSpeed >= dx) // doesn't reach max speed
			return (Math.sqrt(v0*v0 + 2*a*dx)-v0)/a;
		return (vf-v0)/a + (dx-distToMaxSpeed)/vf;
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
		
		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}
