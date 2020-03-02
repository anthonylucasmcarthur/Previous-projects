package dev.mcarthur.DAO;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import dev.mcarthur.entities.Account;
import dev.mcarthur.entities.User;

public class AccountLocalDAO implements AccountDAO {

	public static final Map<Integer, Account> accounttable = new HashMap<Integer, Account>();	
	
	private static int idmaker = 100;
	
	public int createAccount(Account account) {
		idmaker++;
		account.setId(idmaker);
		accounttable.put(idmaker,  account);
		return idmaker;
	}

	
	public Account getAccountsById(int id) {
		Account account = accounttable.get(id);
		return account;
	}
	
	public Set<Account> getAccountsForUser(User user) {
		//puts all accounts into a set so we can iterate through and find which ones
		// belong to our user
		Set<Account> allaccounts = new HashSet<Account>(accounttable.values());
				
		Set<Account> accounts = new HashSet<Account>();
		
		
		
		for(Account a: allaccounts) {
					
			// add account if user id of account equals user id of the user I pass in
			if(a.getUserid()==user.getId()) {
					accounts.add(a);
			}
		}
				
		return accounts;

		
	}
	
	


	public boolean updateAccount(Account account) {
		accounttable.put(account.getId(), account);
		return true;
	}

	public boolean deleteAccount(Account account) {
		
		accounttable.remove(account.getId());
		return true;
	}

	
	

	
	

	
}
