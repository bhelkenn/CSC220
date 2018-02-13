import java.util.*;
import java.io.*;
public class AnimalShelter {

	public static void main(String[] args) throws IOException{
		Map<String, Set<String>> dogs = new TreeMap<String, Set<String>>();
		
		String filename;
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter dog file name: ");
		filename = scan.nextLine();
		
		dogs = readShelterData(filename);
		
		printShelterData(dogs);
		
		System.out.print("Enter adoptee file name: ");
		
		filename = scan.nextLine();
		readAdoptions(dogs, filename);
		
		printShelterData(dogs);
		scan.close();
	}


	public static Map<String, Set<String>> readShelterData(String filename)
	throws IOException {


		// COMPLETE CODE HERE
		Map<String, Set<String>> dogs = new TreeMap<String, Set<String>>();
		
		Scanner infile = new Scanner(new File(filename));
		
		// Read one line of the file at at time
		while (infile.hasNextLine()) {

			// COMPLETE CODE HERE
			Set<String> names = new TreeSet<String>();
			
			// Read one token at a time
			String data = infile.nextLine();
			Scanner inLine = new Scanner(data);
			inLine.useDelimiter(";");
			String breed = inLine.next();
			while (inLine.hasNext()) {
				String dogName = inLine.next();
				
				// COMPLETE CODE HERE
				names.add(dogName);
			}

			// COMPLETE CODE HERE
			dogs.put(breed, names);
			inLine.close();
		}

		infile.close();
		return dogs;			// UPDATE CODE HERE

	}

	public static void printShelterData(Map<String, Set<String>> map) {
			
		// COMPLETE CODE HERE
		System.out.println("Here are the animals left at the shelter (sorted by breed):");
		
		String breed = ((TreeMap<String, Set<String>>) map).firstKey();
		System.out.print(breed + ": ");
		System.out.print(map.get(breed));
		System.out.println();
		while (((TreeMap<String, Set<String>>) map).higherKey(breed) != null) {
			breed = ((TreeMap<String, Set<String>>) map).higherKey(breed);
			System.out.print(breed + ": ");
			System.out.print(map.get(breed));
			System.out.println();
		}
		
	}

	public static void readAdoptions(Map<String, Set<String>> breedToNames, 
			String fileName) throws IOException {

		Scanner infile = new Scanner(new File(fileName));
		infile.useDelimiter("[;\n]");

		while (infile.hasNextLine()) {
			String person = infile.next();
			String breed = infile.next();
			infile.nextLine();

			// COMPLETE CODE HERE
			if (breedToNames.get(breed) != null && breedToNames.get(breed).size() > 0) {
				Object[] names = breedToNames.get(breed).toArray();
				System.out.println(person + " is adopting " + names[0]);
				
				breedToNames.get(breed).remove(names[0]);
				if (breedToNames.get(breed).size() == 0)
					breedToNames.remove(breed);
			}
			else
				System.out.println(person + " CANNOT adopt a " + breed);
		}
		infile.close();
		
	}

}

