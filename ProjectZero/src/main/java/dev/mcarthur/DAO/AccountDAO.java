package dev.mcarthur.DAO;

import java.util.List;
import dev.mcarthur.entities.Account;
import dev.mcarthur.entities.User;

// CRUD
public interface AccountDAO {


	// Create
	public int createAccount(User user, double deposit);
		
	// Read
	public Account getAccountsById(int id);
	public List<Account> getAccountsForUser(User username);
	
		
	// Update
	public boolean withdraw(int id, double withdrawl);
	public boolean deposit(int id, double deposit);
	
	// Delete
	public boolean deleteAccount(Account account);
		
			
}
