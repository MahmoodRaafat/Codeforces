/*

B - Lorry

A group of tourists is going to kayak and catamaran tour. A rented lorry has arrived to 
the boat depot to take kayaks and catamarans to the point of departure. It's known that 
all kayaks are of the same size (and each of them occupies the space of 1 cubic metre), 
and all catamarans are of the same size, but two times bigger than kayaks (and occupy 
the space of 2 cubic metres). Each waterborne vehicle has a particular carrying capacity, 
and it should be noted that waterborne vehicles that look the same can have different 
carrying capacities. Knowing the truck body volume and the list of waterborne vehicles in 
the boat depot (for each one its type and carrying capacity are known), find out such set 
of vehicles that can be taken in the lorry, and that has the maximum total carrying 
capacity. The truck body volume of the lorry can be used effectively, that is to say you 
can always put into the lorry a waterborne vehicle that occupies the space not exceeding 
the free space left in the truck body.

Input
The first line contains a pair of integer numbers n and v (1 <= n <= 10^5; 1 <= v <= 10^9), 
where n is the number of waterborne vehicles in the boat depot, and v is the truck body 
volume of the lorry in cubic metres. The following n lines contain the information about 
the waterborne vehicles, that is a pair of numbers ti, pi (1 <= ti <= 2; 1 <= pi <= 10^4), 
where ti is the vehicle type (1 - a kayak, 2 - a catamaran), and pi is its carrying 
capacity. The waterborne vehicles are enumerated in order of their appearance in the input 
file.

Output
In the first line print the maximum possible carrying capacity of the set. In the second 
line print a string consisting of the numbers of the vehicles that make the optimal set. 
If the answer is not unique, print any of them.

----------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
public class B0003_Lorry {
	
	static class Kayak implements Comparable<Kayak> {
		int index;
		int capacity;
		
		public Kayak(int i, int c) {
			index = i;
			capacity = c;
		}
		
		public int compareTo(Kayak k) {
			return Integer.compare(capacity, k.capacity);
		}
	}
	
	static class Catamaran implements Comparable<Catamaran> {
		int index;
		int capacity;
		
		public Catamaran(int i, int c) {
			index = i;
			capacity = c;
		}
		
		public int compareTo(Catamaran c) {
			return Integer.compare(capacity, c.capacity);
		}
	}
	
	static StringBuffer sb = new StringBuffer();
	static ArrayList<Kayak> kayaks = new ArrayList<>();
	static ArrayList<Catamaran> catamarans = new ArrayList<>();
	static int kIndex, cIndex;
	
	public static void main(String[] args) throws IOException {
		InputReader in = new InputReader();
		int n = in.nextInt();
		int v = in.nextInt();
		
		for (int i=1; i<=n; i++) {
			if (in.nextInt() == 1)
				kayaks.add(new Kayak(i, in.nextInt()));
			else
				catamarans.add(new Catamaran(i, in.nextInt()));
		}
		
		Collections.sort(kayaks);
		Collections.sort(catamarans);
		kIndex = kayaks.size() - 1;
		cIndex = catamarans.size() - 1;
		
		long totalCapacity = 0;
		if (v % 2 == 1 && kIndex >= 0) {
			totalCapacity += addToRes(true);
			--v;
		}
		while (v > 1) {
			if (cIndex == -1) {
				while (v > 0 && kIndex > -1)
					totalCapacity += addToRes(true);
				break;
			}
			if (kIndex == -1) {
				while (v > 1 && cIndex > -1)
					totalCapacity += addToRes(false);
				break;
			}
			if (kIndex == 0) {
				if (kayaks.get(kIndex).capacity > catamarans.get(cIndex).capacity) {
					totalCapacity += addToRes(true);
					--v;
				}
				else {
					totalCapacity += addToRes(false);
					v -= 2;
				}
			}
			else {
				Kayak k1 = kayaks.get(kIndex);
				Kayak k2 = kayaks.get(kIndex - 1);
				Catamaran c1 = catamarans.get(cIndex);
				if (c1.capacity >= k1.capacity + k2.capacity)
					totalCapacity += addToRes(false);
				else
					totalCapacity += addToRes(true) + addToRes(true);
				v -= 2;
			}
		}
		
		if (v == 1 && kayaks.size() > 0) {
			Kayak k = kayaks.get(kIndex);
			totalCapacity += k.capacity;
			sb.append(k.index + " ");
		}
		
		System.out.println(totalCapacity);
		System.out.println(sb);
	}
	
	public static int addToRes(boolean kayak) {
		int toAdd = 0;
		if (kayak) {
			Kayak k = kayaks.get(kIndex--);
			toAdd += k.capacity;
			sb.append(k.index + " ");
		}
		else {
			Catamaran c = catamarans.get(cIndex--);
			toAdd += c.capacity;
			sb.append(c.index + " ");
		}
		return toAdd;
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