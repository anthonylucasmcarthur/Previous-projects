package dev.mcarthur.App;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class App {
	
	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);
		
		
		//making object for us to work with
		Salesman jim = new Salesman("jimmyfallon", "James Smith", 0, 0);
		Salesman anna = new Salesman("annie", "Annette Jones", 0, 0);
		
		
		Car prius = new Car("Toyota", "Priuis", 2015, 50000, 14000);
		Car lexus = new Car("Lexus", "Eclipse", 2019, 90000, 0);
		
		List<Car> cars = new ArrayList<Car>();
		cars.add(lexus);
		cars.add(prius);
		
		Map<String, Salesman> sales = new HashMap<String,Salesman>();
		sales.put(jim.getUsername(), jim);
		sales.put(anna.getUsername(), anna);
		
		
		//prompting user to log in
		System.out.println("Welcome to Honest Abes Honest cars of Honesty");
		System.out.println("Please login using your username");
		String username = scan.nextLine();
		
		Salesman user = sales.get(username);
		
		user.printStats();
		
		for(Car c : cars) {
			c.showStats();
		}
		
		while(true) {
		System.out.println("Please pick a care to sell");
		int choice = scan.nextInt();
		Car car = cars.get(choice);
		user.sellCar(car);
		cars.remove(choice);
		user.printStats();
		}
		
//		jim.printStats();
//		jim.sellCar(lexus);
//		jim.printStats();
	}
}
