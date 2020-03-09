package BattlePractice;

public abstract class Character {

	String name;
	int health;
	int strength;
	
	public void showStats(String name, int health, int strength) {
		System.out.println("Name: " + name);
		System.out.println("Health: " + health);
		System.out.println("Strength: " + strength);
		System.out.println("\n");
	}
	
	
}
