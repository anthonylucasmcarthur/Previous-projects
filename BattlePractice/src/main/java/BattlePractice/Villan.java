package BattlePractice;

public class Villan extends Character implements Attack{
	
//	String name;
//	int health;
//	int strength;
	
	Villan(String name, int health, int strength){
		this.name = name;
		setHealth(health);
		setStrength(strength);
	}
	
	// attack method
	public int attack(Hero hero) {
		hero.health = hero.health - this.strength;
		return hero.health;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		if(health <= 0) {
			this.health = 1;
		} else if (health > 100) {
			this.health = 100;
		} else {
			this.health = health;
		}
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		if(strength <= 0) {
			this.strength = 1;
		} else if (strength > 15) {
			this.strength = 15;
		} else {
			this.strength = strength;
		}
	}
	
	
	

}
