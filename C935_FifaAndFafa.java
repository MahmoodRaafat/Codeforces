package C;

/*

C - Fifa and Fafa

Fifa and Fafa are sharing a flat. Fifa loves video games and wants to download a new soccer 
game. Unfortunately, Fafa heavily uses the internet which consumes the quota. Fifa can access 
the internet through his Wi-Fi access point. This access point can be accessed within a range 
of r meters (this range can be chosen by Fifa) from its position. Fifa must put the access 
point inside the flat which has a circular shape of radius R. Fifa wants to minimize the area 
that is not covered by the access point inside the flat without letting Fafa or anyone outside 
the flat to get access to the internet. The world is represented as an infinite 2D plane. The 
flat is centered at (x1, y1) and has radius R and Fafa's laptop is located at (x2, y2), not 
necessarily inside the flat. Find the position and the radius chosen by Fifa for his access 
point which minimizes the uncovered area.

Input
The single line of the input contains 5 space-separated integers R, x1, y1, x2, y2 
(1 <= R <= 10^5, |x1|, |y1|, |x2|, |y2| <= 10^5).

Output
Print three space-separated numbers xap, yap, r where (xap, yap) is the position which Fifa 
chose for the access point and r is the radius of its range. Your answer will be considered 
correct if the radius does not differ from optimal more than 10^-6 absolutely or relatively, 
and also the radius you printed can be changed by no more than 10^-6 (absolutely or relatively) 
in such a way that all points outside the flat and Fafa's laptop position are outside circle of 
the access point range.

------------------------------------------------------------------------------------------------*/

import java.util.*;
public class C935_FifaAndFafa {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		double flatRadius = sc.nextDouble(),
		   flatX = sc.nextInt(), 
		   flatY = sc.nextInt(), 
		   laptopX = sc.nextInt(), 
		   laptopY = sc.nextInt();
		sc.close();
		
		System.out.println(solve(flatRadius, flatX, flatY, laptopX, laptopY));
	}
	
	public static String solve(double flatRadius, double flatX, double flatY, double laptopX, double laptopY) {
		
		// distance from laptop to flat center
		double dist = Math.sqrt((flatX-laptopX)*(flatX-laptopX) + (flatY-laptopY)*(flatY-laptopY));
		if (checkOutsideFlat(dist, flatRadius))
			return "" + flatX + " " + flatY + " " + flatRadius;
		if (centeredLaptop(flatX, flatY, laptopX, laptopY))
			return "" + (flatX+(flatRadius/2)) + " " + flatY + " " + flatRadius/2;
		
		
		double accessPointX = 0, accessPointY = 0, signalRadius = 0;
		double theta = findTheta(flatX, flatY, laptopX, laptopY);
		double distance = (flatRadius-dist)/2;
		double Xdist = distance*Math.cos(theta), Ydist = distance*Math.sin(theta);
		
		accessPointX = flatX + Xdist;
		accessPointY = flatY + Ydist;
		signalRadius = ((flatRadius+dist)/2);
		
		if ((accessPointX < 0.00000001) && (accessPointX > -0.00000001)) accessPointX = 0;
		if ((accessPointY < 0.00000001) && (accessPointY > -0.00000001)) accessPointY = 0;
		if ((signalRadius < 0.00000001) && (signalRadius > -0.00000001)) signalRadius = 0;
		
		return "" + accessPointX + " " + accessPointY + " " + signalRadius;
	}
	
	public static boolean checkOutsideFlat(double dist, double flatRadius) {
		return dist > flatRadius;
	}
	
	public static boolean centeredLaptop(double flatX, double flatY, double laptopX, double laptopY) {
		return flatX==laptopX && flatY==laptopY;
	}
	
	public static double findTheta(double flatX, double flatY, double laptopX, double laptopY) {
		double theta = Math.atan(Math.abs(laptopY-flatY)/Math.abs(laptopX-flatX));
		if ((laptopX<flatX && laptopY>flatY) || (laptopX<flatX && laptopY==flatY))
			theta = Math.PI - theta;
		else if ((laptopX<flatX && laptopY<flatY) || (laptopX==flatX && laptopY<flatY))
			theta = Math.PI + theta;
		else if (laptopX>flatX && laptopY<flatY)
			theta = (2*Math.PI - theta);
		theta += Math.PI;
		return theta;
	}
}