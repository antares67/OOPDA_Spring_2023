
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

public class MovieDriver {
	
	private static HashMap <Integer, Movie> movies = new HashMap<Integer, Movie>();

	public static void main(String[] args) {
		populateMovies();
		displayMovies();
	}

	/**
	 * This method uses a Scanner and gets user input for three movies (title, length, release date
	 * which it will then use to make a new Movie and add it into the HashMap movies.
	 */
	private static void populateMovies() {
		System.out.println("Creating movies");
		// TODO add your code here.
	//	Scanner scan = new Scanner(System.in);
		Movie movie1 = new Movie("Platoon", "1986", 120);
		Movie movie2 = new Movie("Pirates of the Caribbean", "2003", 143);
		Movie movie3 = new Movie("The Lord of the Rings: The Fellowship of the Ring", "2001", 178);
		// System.out.println("Movie Title");
		movies.put(0, movie1);
		// System.out.println("Movie Length");
		movies.put(1, movie2);
		// System.out.println("Movie release date");
		movies.put(2, movie3);

		//capitalCities.put("England", "London");


		

	}
	
	/**
	 * This method loops through all the movies using the forEach method 
	 * and displays each movie using its toString() method.
	 */
	private static void displayMovies() {
		System.out.println("\nHere is the list of movies:");
		// TODO add your code here.
		for(int i = 0; i < movies.size(); i++){
			System.out.println(movies.get(i));
			
		}
		
	}
}
