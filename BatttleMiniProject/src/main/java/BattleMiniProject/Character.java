package BattleMiniProject;



public class Character {
	
	private String name;
	private int strength;
	private int health;
	
	//constructor
	Character(String name, int strength, int health){
		this.name = name;
		setStrength(strength);
		setHealth(health);
	}

	//name getter
	public String getName() {
		return name;
	}
	
	//name setter
	public void setName(String name) {
		this.name = name;
	}

	//strength getter
	public int getStrength() {
		return strength;
	}

	//strength setter
	public void setStrength(int strength) {
		if(strength<=0) {
			this.strength = 1;
		} else if(strength>15) {
			this.strength = 15;
		} else {
			this.strength = strength;
		}
	}

	//health getter
	public int getHealth() {
		return health;
	}

	// health setter
	public void setHealth(int health) {
		if(health<=0) {
			this.health = 0;
		} else if (health>100){
			this.health = 100;
		} else {
			this.health = health;
		}
	}
	



	
	//take hit method
	public void takehit(Character opponent) {
		this.health = this.health - opponent.getStrength();
		
	
		
	}
	
	//prints out character's statistics
	public void printStats(String name, int strength, int health) {
		System.out.println(name +"'s statistics:");
		System.out.println("Strength: " + strength);
		System.out.println("Health: " + health);
		System.out.println("\n");
	}
	


}
