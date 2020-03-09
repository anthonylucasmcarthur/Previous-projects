package BattleMiniProject;

import java.util.Scanner;

public class BattleGame {

	public static void main(String [] args) {
		
		//welcome player to game
		System.out.println("Welcome to Battle Duel!");
		System.out.println("\n");
		
		//make scanner object
		Scanner scan = new Scanner(System.in);
		
		//ask player to name character
		System.out.println("Enter your character's name:");
		
		//scan next line
		String name = scan.nextLine();
		System.out.println("\n");
		
		//ask player to pick strength
		System.out.println("What is your strength?");
		System.out.println("Please enter a value between 1 and 15");
		
		//scan next integer
		int strength = scan.nextInt();
		System.out.println("\n");
		
		//ask player to health
		System.out.println("What is your health?");
		System.out.println("Please enter a value between 0 and 100");
		
		//scan next integer
		int health = scan.nextInt();
	
		
		// generate player
		Character player = new Character(name, strength, health);
		
		//show character stats 
		System.out.println("\n");
		player.printStats(player.getName(), player.getStrength(), player.getHealth());

		
		String [] Opponents = {"Bush", "Damien", "Tony"};

		for(int i = 0; i<3; i++) {
			
			// generate opponent
			String enemyname = Opponents[i];
			
			//generate opponent strength
			int enemystrength = (int)(Math.random()*14)+1;
			
			//generate opponent health
			int enemyhealth = (int)(Math.random()*100);
			
			Character opponent = new Character(enemyname, enemystrength, enemyhealth);
			
			//introduce opponent
			System.out.println("Your next opponent is " + enemyname);
			System.out.println("\n");
			
			//show characters stats
			opponent.printStats(opponent.getName(), opponent.getStrength(), opponent.getHealth());
			
			while(true){
			
				//your turn
			
				//you attack opponent
				System.out.println(name + " attacks " + enemyname);
				opponent.takehit(player);
			
				//if you defeat opponent
				if(opponent.getHealth() <= 0) {
					System.out.println(enemyname + " health is less than zero");
					System.out.println("\n");
					System.out.println("Congradulations, you defeated " + enemyname);
					System.out.println("\n");
					break;
				
				//if opponent is still alive	
				}else {
					System.out.println(enemyname + "'s health is " + opponent.getHealth());
					System.out.println("\n");
				}
			
	
				//opponents turn
				
				//opponent attacks you
				System.out.println(enemyname + " attacks " + name);
				player.takehit(opponent);
			
				//if opponent defeats you
				if (player.getHealth() <=0){
					System.out.println("Your health is less than zero");
					System.out.println("\n");
					System.out.println("Sorry, you lose");
					break;
				
				// if you are still alive	
				}else {
				
					System.out.println("Your health is " + player.getHealth());
					System.out.println("\n");
				}
		
			}
			
			//decrease your strength after each opponent
			if(opponent.getHealth() <= 0 && i<1) {
					strength = strength - 3;
					System.out.println("Your strength is now " + strength);
					System.out.println("\n");
					}
		}
		
		
		 
		//close scanner
		scan.close();
		
		
		
	}
}
