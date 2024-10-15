public class TravelingSalesmanProblem {
// 2.5	Write a function that takes two city numbers
//	and returns the distance (a float) between them.  
	public static float calculateDistance(int[][] cities, int cityIndex1, int cityIndex2) {
//		get the needed coordinates
		int x1 = cities[cityIndex1][0];
		int y1 = cities[cityIndex1][1];
		int x2 = cities[cityIndex2][0];
		int y2 = cities[cityIndex2][1];

		// using help to find that this is Euclidean Distance
		float distance = (float) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

		return distance;
	}

//2.6	Write a function that loops from the first city to the last
//	and calculates the length of the path (0-1-2-3-0).  (This uses the distance function).
	public static float totalLengthPath(int[][] cities, int[] idx) {
		float distination = 0;

		for (int i = 0; i < idx.length - 1; i++) {
			distination += calculateDistance(cities, idx[i], idx[i + 1]);
		}

		distination += calculateDistance(cities, idx[idx.length - 1], idx[0]);

		return distination;

	}

	/*
	 * 2.7 Now, generate all of the permutation (You can do an exhaustive search to
	 * find the shortest path. Note that paths in either direction and from any
	 * starting point have the same length. So length(0-1-2-3-0) = length(0-3-2-1-0)
	 * = length(1-2-3-0-1)). A good way to do this is to write a recursive function
	 * that takes in an array of cities not visited, and a partial path. When there
	 * are no cities left to visit, print out the (now complete) path.
	 */
	public static void allPremutations(int[][] cities, int[] idx, int currentElement, float[] shortPath) {
		if (currentElement == idx.length) {
			float distance = totalLengthPath(cities, idx);
			/*
			 * 2.8 Add a recording of the shortest current path to the permutation function.
			 * You can use two global variables. (This would probably have gotten you a
			 * passing mark.)
			 */
			if (distance < shortPath[0]) {
				shortPath[0] = distance;
			}
		} else {
			for (int i = currentElement; i < idx.length; i++) {
				swap(idx, currentElement, i);// swap it first before
				// recursive call
				allPremutations(cities, idx, currentElement + 1, shortPath);
				swap(idx, currentElement, i); // then swap it again after the call
			}
		}
	}

	// using swap function
	public static void swap(int[] cities, int city1, int city2) {
		int temp = cities[city1];
		cities[city1] = cities[city2];
		cities[city2] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// 2.2
		System.out.println("Hello, World!");
//2.3 
		/*
		 * Make a 2x4 integer array (called something like cities). You can fill it up
		 * with {{1, 1}, {5, 5}, {10,3}, {2,7}}. (That’s the location of the 4 cities in
		 * 2D space).
		 */
		int[][] cities = { { 1, 1 }, { 5, 5 }, { 10, 3 }, { 2, 7 } };
		int[] idx = { 0, 1, 2, 3 };

// 2.4		Print out the cities 
		System.out.println("Cities coordinates: ");
		for (int[] city : cities) {
			System.out.println("City locations: (" + city[0] + ", " + city[1] + ")");
		}

		// 2.5 calculating the distance between city 1,4
		float distance = calculateDistance(cities, 0, 3);
		System.out.println("Distance between city 1 and city 4 is " + distance);
		distance = calculateDistance(cities, 0, 1);
		System.out.println("Distance between city 1 and city 2 is " + distance);
		distance = calculateDistance(cities, 0, 2);
		System.out.println("Distance between city 1 and city 3 is " + distance);
		distance = calculateDistance(cities, 1, 0);
		System.out.println("Distance between city 2 and city 1 is " + distance);
		distance = calculateDistance(cities, 1, 2);
		System.out.println("Distance between city 2 and city 3 is " + distance);
		distance = calculateDistance(cities, 1, 3);
		System.out.println("Distance between city 2 and city 4 is " + distance);
		distance = calculateDistance(cities, 2, 0);
		System.out.println("Distance between city 3 and city 1 is " + distance);
		distance = calculateDistance(cities, 2, 1);
		System.out.println("Distance between city 3 and city 2 is " + distance);
		distance = calculateDistance(cities, 2, 3);
		System.out.println("Distance between city 3 and city 4 is " + distance);
		distance = calculateDistance(cities, 3, 1);
		System.out.println("Distance between city 4 and city 1 is " + distance);
		distance = calculateDistance(cities, 3, 1);
		System.out.println("Distance between city 4 and city 2 is " + distance);
		distance = calculateDistance(cities, 3, 2);
		System.out.println("Distance between city 4 and city 3 is " + distance);
		// 2.6 calculate the length of the path (0-1-2-3-0)
		float path = totalLengthPath(cities, idx);
		System.out.println("The calculated length of the path is " + path);

		// 2.8 Add a recording of the shortest current path to the permutation function.
		float[] shortestPath = { Float.MAX_VALUE };

		// 2.7 all permutations generated and calculated it's path
		allPremutations(cities, idx, 0, shortestPath);

		System.out.println("The shortest path is: " + shortestPath[0]);
	}
}
