package dev.mcarthur.entities;

import java.util.Set;

public class Account {

	// this id is different for every single user
	private int id;

	// we need to be able to connect a account to a user
	private int userid;
	private double balance;

	public Account() {
		super();
	}

	public Account(int id, int userid, double balance) {
		super();
		this.id = id;
		this.userid = userid;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + "]";
	}

}
