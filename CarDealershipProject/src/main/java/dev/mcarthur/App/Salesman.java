package dev.mcarthur.App;

import java.util.ArrayList;
import java.util.List;

public class Salesman {
	
	private String username;
	private String name;
	
	private int carsold;
	private int revenue;

	List<Car> car = new ArrayList<Car>();
	
	Salesman(String username, String name, int carsold, int revenue) {
		this.username = username;
		this.name = name;
		this.carsold = carsold;
		this.revenue = revenue;
	}
	
	public void printStats() {
		System.out.println("name : " + this.name + " carsold : " + this.carsold + " revenue " + this.revenue);
	}

	
	public void sellCar(Car car) {
		
		this.carsold++;
		this.revenue += car.getValue();
		this.car.add(car);
		
		System.out.println(this.name + " sold a " +car.getMake() + "worth "  + car.getValue());
	}

	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getCarsold() {
		return carsold;
	}



	public void setCarsold(int carsold) {
		this.carsold = carsold;
	}



	public int getRevenue() {
		return revenue;
	}



	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}
	
	
	
}
