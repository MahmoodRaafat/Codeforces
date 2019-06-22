import java.io.*;
import java.util.*;
public class C0001_AncientBerlandCircus {
	
	static final double EPSILON = 1e-5;
	static final double INFINITY = 1e308;
	
	static class Point {
		double x;
		double y;
		
		public Point(double X, double Y) {
			x = X;
			y = Y;
		}
		
		public double getDist(Point p) {
			return Math.sqrt((x - p.x)*(x - p.x) + (y - p.y)*(y - p.y));
		}
	}
	
	static class Line {
		Point p;
		double slope;
		Point midPoint;
		
		public Line(Point p1, Point p2) {
			p = p1;
			slope = calculateSlope(p2);
			midPoint = findMidPoint(p1, p2);
		}
		
		public Line(Point p1, double s) {
			p = p1;
			slope = s;
			midPoint = null;
		}
		
		public Line getPerpendicularBisector() {
			if (slope == 0)
				return new Line(midPoint, INFINITY);
			if (slope == INFINITY)
				return new Line(midPoint, 0);
			return new Line(midPoint, -1*(1/slope));
		}
		
		public Point findIntersection(Line line) {
			if (slope == 0) {
				if (line.slope == INFINITY)
					return new Point(line.p.x, p.y);
				return new Point((p.y - line.p.y)/line.slope + line.p.x, p.y);
			}
			if (line.slope == 0) {
				if (slope == INFINITY)
					return new Point(p.x, line.p.y);
				return new Point((line.p.y - p.y)/slope + p.x, line.p.y);
			}
			if (slope == INFINITY)
				return new Point(p.x, line.slope*(p.x - line.p.x) + line.p.y);
			if (line.slope == INFINITY)
				return new Point(line.p.x, slope*(line.p.x - p.x) + p.y);
			
			double b1 = p.y - slope*p.x, b2 = line.p.y - line.slope*line.p.x;
			double x = (b2 - b1) / (slope - line.slope);
			double y = slope*x + b1;
			return new Point(x, y);
		}
		
		public Point findMidPoint(Point p1, Point p2) {
			return new Point((p1.x + p2.x)/2, (p1.y + p2.y)/2);
		}
		
		public double calculateSlope(Point p2) {
			if (Math.abs(p.x - p2.x) <= EPSILON)
				return INFINITY;
			if (Math.abs(p.y - p2.y) <= EPSILON)
				return 0;
			return (p.y - p2.y) / (p.x - p2.x);
		}
	}
	
	public static void main(String[] args) {
		InputReader in = new InputReader();
		Point p1 = new Point(in.nextDouble(), in.nextDouble());
		Point p2 = new Point(in.nextDouble(), in.nextDouble());
		Point p3 = new Point(in.nextDouble(), in.nextDouble());

		Point center = findCenter(p1, p2, p3);
		double radius = center.getDist(p1);
		double[] theta = findThetas(center, p1, p2, p3);
		for (int numAngles = 3; numAngles <= 100; numAngles++) {
			boolean good = true;
			for (int i=0; i<3; i++)
				if (!isInteger(Math.abs(theta[i] / (2*Math.PI/numAngles))))
					good = false;
			if (good)
				printArea(numAngles, radius);
		}
	}
	
	public static boolean isInteger(double d) {
		double closestDiff = Integer.MAX_VALUE;
		int closestInt = 0;
		for (int i=(int) (d-2); i<(int) (d+2); i++) {
			if (Math.abs(d-i) < closestDiff) {
				closestDiff = Math.abs(d-i);
				closestInt = i;
			}
		}
		return Math.abs(closestInt - d) <= EPSILON;
	}
	
	public static Point findCenter(Point p1, Point p2, Point p3) {
		Line line1 = new Line(p1, p2);
		Line line2 = new Line(p2, p3);
		Line pb1 = line1.getPerpendicularBisector();
		Line pb2 = line2.getPerpendicularBisector();
		return pb1.findIntersection(pb2);
	}
	
	public static double findAngle(Point center, Point p1) {
		if (Math.abs(center.x - p1.x) <= EPSILON)
			return center.y < p1.y ? Math.PI/2 : 3*Math.PI/2;
		if (Math.abs(center.y - p1.y) <= EPSILON)
			return center.x < p1.x ? 0 : Math.PI;
		if (center.x < p1.x)
			return Math.atan((p1.y - center.y)/(p1.x-center.x));
		return Math.atan((p1.y - center.y)/(p1.x-center.x)) + Math.PI;
	}
	
	public static double[] findThetas(Point c, Point p1, Point p2, Point p3) {
		double[] theta = {findAngle(c, p1), findAngle(c, p2), findAngle(c, p3)};
		Arrays.sort(theta);
		for (int i=2; i>=0; i--)
			theta[i] -= theta[0];
		return theta;
	}
	
	public static void printArea(int numAngles, double radius) {
		double theta = Math.PI/numAngles;
		System.out.println(numAngles*radius*radius*Math.sin(theta)*Math.cos(theta));
		System.exit(0);
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