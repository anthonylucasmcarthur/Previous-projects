package dev.mcarthur.entities;

import java.util.ArrayList;
import java.util.List;



public class Employee {

	private int id;
	private String username;
	private String password;
	private boolean ismanager;

	private List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

	
	public Employee() {
		super();
	}

	public Employee(int id, String username, String password, boolean ismanager, List<Reimbursement> reimbursements) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.ismanager = ismanager;
		this.reimbursements = reimbursements;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isIsmanager() {
		return ismanager;
	}

	public void setIsmanager(boolean ismanager) {
		this.ismanager = ismanager;
	}

	public List<Reimbursement> getReimbursements() {
		return reimbursements;
	}

	public void setReimbursements(List<Reimbursement> reimbursements) {
		this.reimbursements = reimbursements;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", username=" + username + ", password=" + password + ", ismanager=" + ismanager
				+ ", reimbursements=" + reimbursements + "]";
	}

	
	
	
}
