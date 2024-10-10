import java.io.*;
import java.util.*;

public class FileReader {
	FileReader(){	
	}
	public static int[][] fileReader(String file) throws FileNotFoundException{
		Scanner sc = new Scanner(new File(file));
		List<int[]> cities = new ArrayList<>();
		try(sc){
			while(sc.hasNextLine()) {
				String[] parts = sc.nextLine().split(",");
				int partSeparetor1 = Integer.parseInt(parts[0].trim());
				int partSeparetor2 = Integer.parseInt(parts[1].trim());
				cities.add(new int[] {partSeparetor1, partSeparetor2});
			}
		}
		return cities.toArray(new int[0][]);
	}
}
