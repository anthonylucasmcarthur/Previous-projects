package dev.mcarthur.App;

public class Car {

	private String make;
	private String model;
	private int year;
	private int mileage;
	private int value;
	
	Car(String make, String model, int year, int mileage, int value){
		this.make = make;
		this.model = model;
		this.year = year;
		this.mileage = mileage;
		this.value = value;
	}

	public void showStats() {
		System.out.println("make : "+ this.make + " model : "+ this.model + " value :" + this.value + " year : " +this.year + " mileage :" + this.mileage);
	}
	
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public int getMileage() {
		return mileage;
	}
	
	public void setMileage(int mileage) {
		if(mileage<0) {
			this.mileage = 0;
		} else {
			this.mileage = mileage;
		}
		
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
	
}
