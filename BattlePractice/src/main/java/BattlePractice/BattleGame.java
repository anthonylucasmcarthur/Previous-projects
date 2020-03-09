package BattlePractice;

import java.util.Scanner;

public class BattleGame {

	public static void main(String [] args) {
		
		// make scanner object
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to Battle!");
		System.out.println("\n");
		
		//ask user to input character name
		System.out.println("Enter your character's name:");
		
		// make object for name
		String name = input.nextLine();
		System.out.println("\n");
		
		// ask user to input character health
		System.out.println("Enter your character's health:");
		System.out.println("Please enter a value between 1 and 100");

		
		// make object for health
		int health = input.nextInt();
		System.out.println("\n");
		
		// ask user to input character strength
		System.out.println("Enter your character's strength:");
		System.out.println("Please enter a value between 1 and 15");

		
		// make object of strength
		int strength = input.nextInt();
		System.out.println("\n");
		
		// make object for hero class with name, health, strength objects
		Hero hero = new Hero(name, health, strength);
		
		System.out.println("Hero's stats");
		
		// show hero's stats
		hero.showStats(name, hero.getHealth(), hero.getStrength());
		
		// ask user enter villain name
//		System.out.println("Name your opponent");
//		System.out.println("\n");
//		
//		// make object for villain name
//		String villainname = input.nextLine();
		
		String villainname = "Jack";
		
		int villainstrength = (int)(Math.random()*14)+1;
		
		int villainhealth = (int)(Math.random()*99)+1;
		
		
		
		// make object for villain class with villain name object, villain health, villain strength with 
		Villan villain = new Villan(villainname, villainhealth, villainstrength);
		
		
		System.out.println("Villain's stats");
		
		// show villains stats
		villain.showStats(villainname, villainhealth, villainstrength);
		

		
		// make loop for attack sequence
		while(true){
		
//			// use random to determine goes first
//			double prob = Math.random();
//		
//			if(prob > .5) {
//				String player1  = villain;
			
			// player 1 attacks with attack method
			System.out.println(name + " attacks " + villainname);
			hero.attack(villain);
				
			
			// if player 1 defeats player 2
			if(villain.health <= 0) {
				// tell user who won
				System.out.println(villainname + "'s health is less than 0");
				System.out.println(villainname + " was defeated");
				break; // break out of loop
			}
			
			// show damage sustained by attack
			System.out.println(villainname +"'s health is " + villain.health);
			System.out.println("\n");
			
			// player 2 attacks with attack method
			System.out.println(villainname + " attack " + name);
			villain.attack(hero);
			
			
			// if player 2 defeats player 1
			if(hero.getHealth() <= 0) {
				// tell user who won
				System.out.println("Your health is less than 0");
				System.out.println("Sorry you were defeated");
				break; // break out of loop
			}
			
			//show damage sustained by attack
			System.out.println(name + "'s health is " + hero.getHealth());
			System.out.println("\n");
			
		} //end loop
	
		
		
		//close scanner
		input.close();
	}
}
