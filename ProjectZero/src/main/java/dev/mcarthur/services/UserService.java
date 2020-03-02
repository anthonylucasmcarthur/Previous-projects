package dev.mcarthur.services;


import dev.mcarthur.entities.User;

public interface UserService {

	

	

	// create user
	User createAccount(User user, double deposit);
	
	
	// delete account
	User deleteAccount(User user, int id);
	
	
	// deposit
	User deposit(User user, int id, double deposit);
	
	
	// withdraw
	User withdraw(User user, int id,  double withdraw);
	
	
	// view account
	void printAccounts(User user);
	
	
	
	
	
	// login
	User login(String username, String password);	
	
	
	// create user
	User createUser(User user);
	
	
	// view user
	void viewUsers();
	
	
	// update user 
	boolean changeUsername(int id, String username);
	boolean changePassword(int id, String password);
	
	// delete user
	User deleteUser(int id);



	
	
	

}
