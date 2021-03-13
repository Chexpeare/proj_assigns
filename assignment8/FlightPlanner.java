package week5;

/**
* FlightPlanner.java
* ------------------
* Your task for this section is to write a program that reads in a file containing flight 
* destinations from various cityArray, and then allow the user to plan a round-trip flight route.
* The flight data comes from a file named <b>flights.txt</b>, which has the following format:
* 
* • Each line consists of a pair of cityArray separated by an arrow indicated by the two
*   character combination ->, as in New York -> Anchorage
* 
* • The file may contain blank lines for readability (you should just ignore these).
* 
* Your program should:
* • Read in the flight information from the file <b>flights.txt</b> and store it in an
*   appropriate data structure.
* 
* • Display the complete list of cityArray.
* 
* • Allow the user to select a city from which to start.
* 
* • In a loop, print out all the destinations that the user may reach directly from the
*   current city, and prompt the user to select the next city.
* 
* • Once the user has selected a round-trip route (i.e., once the user has selected a
*   flight that returns them to the starting city), exit from the loop and print out the
*   route that was chosen.
*   
* A <tt>critical issue</tt> in building this program is designing appropriate data structures to keep
* track of the information you'll need in order to produce flight plans. You'll need to both
* have a way of keeping track of information on available flights that you read in from the
* <b>flights.txt</b> file, as well as a means for keeping track of the flight routes that the user is
* choosing in constructing their flight plan. Consider how both ArrayLists and HashMaps
* might be useful to keep track of the information you care about.
* 
*/

import acm.program.*;
import acm.util.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FlightPlanner extends ConsoleProgram {

	/* Private instance variables */
	private HashMap<String, ArrayList<String>> flights;
	private ArrayList<String> cityArray;

	/** Calls readDatabase, prints cities and prompts client for the starting city */
	public void run() {
		readDatabase("flights.txt");
		println("Welcome to Flight Planner!");
		printDatabase(cityArray);
		String startingCity = readLine("\nEnter the starting city: ");
		
		ArrayList<String> route = new ArrayList<String>();
		route.add(startingCity);
		String currentCity = startingCity;
		while (true) {
			String nextCity = getNextCity(currentCity);
			route.add(nextCity);
			if (nextCity.equals(startingCity))
				break;
			currentCity = nextCity;
		}
		printRoute(route);
	}

	/** Prompt client for next city */
	private String getNextCity(String city) {
		ArrayList<String> destinations = getDestinations(city);
		String nextCity = null;
		while (true) {
			println("\nFrom " + city + " you can fly directly to:");
			printDatabase(destinations);
			String prompt = "Where do you want to go from " + city + "? ";
			nextCity = readLine(prompt);
			if (destinations.contains(nextCity))
				break;
			println("\nYou can't get to that city by a direct flight.");
		}
		return nextCity;
	}

	/**
	 * Compares client city selection to the destinations available in the database.
	 */
	private ArrayList<String> getDestinations(String fromCity) {
		return flights.get(fromCity);
	}

	/**
	 * Prints a list of all the cities in the database. 
	 */
	private void printDatabase(ArrayList<String> cityList) {
        println("\nHere's a list of all the cities in our database: ");
		for (int i = 0; i < cityList.size(); i++) {
			String city = cityList.get(i);
			println("  " + city);
		}
		println("\nLet's plan a round-trip route!");
	}

	/**
	 * Concatenates client's city selections and presents flight itinerary.  
	 */
	private void printRoute(ArrayList<String> route) {
		println("\nThe route you've chosen is: ");
		for (int i = 0; i < route.size(); i++) {
			if (i > 0)
				print(" ->");
			print("  " + route.get(i));
		}
		println();
	}

	/**
	 * Read flight connections from the database file. Stores the information in
	 * both the ArrayList of cities and the HashMap of flights.
	 */
	private void readDatabase(String filename) {
		flights = new HashMap<String, ArrayList<String>>();
		cityArray = new ArrayList<String>();
		
		try {
			BufferedReader rd = new BufferedReader(new FileReader(filename));
			while (true) {
				String line = rd.readLine();
				if (line == null)
					break;
				if (line.length() != 0) {
					readFlightEntry(line);
				}
			}
			rd.close();
		} catch (IOException ex) {
			throw new ErrorException(ex);
		}
	}
	
	private void readFlightEntry(String line) {
		int arrow = line.indexOf("->");
		if (arrow == -1) {
			throw new ErrorException("Illegal flight entry " + line);
		}
		String fromCity = line.substring(0, arrow).trim();
		String toCity = line.substring(arrow + 2).trim();
		defineCity(fromCity);
		defineCity(toCity);
		getDestinations(fromCity).add(toCity);
	}

	private void defineCity(String cityName) {
		if (!cityArray.contains(cityName)) {
			cityArray.add(cityName);
			flights.put(cityName, new ArrayList<String>());
		}
	}
}










