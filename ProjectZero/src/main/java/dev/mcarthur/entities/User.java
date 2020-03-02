package dev.mcarthur.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {

	private int id;
	private String username;
	private String password;

	private boolean issuperuser;

	private List<Account> accounts = new ArrayList<Account>();

	public User() {
		super();
	}

	public User(int id, String username, String password, boolean issuperuser) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.issuperuser = issuperuser;
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

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public boolean isIssuperuser() {
		return issuperuser;
	}

	public void setIssuperuser(boolean issuperuser) {
		this.issuperuser = issuperuser;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", issuperuser=" + issuperuser
				+ ", accounts=" + accounts + "]";
	}

}
