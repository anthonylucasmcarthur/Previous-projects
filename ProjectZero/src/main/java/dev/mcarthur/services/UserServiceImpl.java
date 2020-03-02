package dev.mcarthur.services;

import java.util.InputMismatchException;
import java.util.List;
import dev.mcarthur.DAO.AccountDAO;
import dev.mcarthur.DAO.AccountJDBCDAO;
import dev.mcarthur.DAO.UserDAO;
import dev.mcarthur.DAO.UserJDBCDAO;
import dev.mcarthur.entities.Account;
import dev.mcarthur.entities.User;

public class UserServiceImpl implements UserService {

	UserDAO udao = new UserJDBCDAO();

	AccountDAO adao = new AccountJDBCDAO();

	// create account
	public User createAccount(User user, double deposit) {

		this.adao.createAccount(user, deposit);

		System.out.println("\n");
		System.out.println("Here are your accounts:");
		printAccounts(user);
		return user;

	}

	// delete account
	public User deleteAccount(User user, int id) {

		try {
			Account account = this.adao.getAccountsById(id);

			if (account.getBalance() == 0) {
				adao.deleteAccount(account);

			} else {
				System.out.println("\n");
				System.out.println("Account must be empty before you can delete it");

			}
		} catch (NullPointerException npe) {
			System.out.println("Invalid Account Number");
		}
		System.out.println("\n");
		System.out.println("Here are your accounts:");
		printAccounts(user);
		return user;
	}

	// deposit
	public User deposit(User user, int id, double deposit) {

		try {
			this.adao.deposit(id, deposit);

		} catch (InputMismatchException ime) {

			this.adao.deposit(id, (double) deposit);

		}
		System.out.println("\n");
		System.out.println("Here are your accounts:");
		printAccounts(user);
		return user;
	}

	// withdraw
	public User withdraw(User user, int id, double withdrawl) {

		try {

			this.adao.withdraw(id, withdrawl);

		} catch (InputMismatchException ime) {

			this.adao.withdraw(id, (double) withdrawl);

		}
		System.out.println("\n");
		System.out.println("Here are your accounts:");
		printAccounts(user);
		return user;

	}

	// print account
	public void printAccounts(User user) {

		List<Account> accounts = adao.getAccountsForUser(user);

		if (accounts.isEmpty()) {
			System.out.println("\n");
			System.out.println("You don't have any accounts");

		} else {

			for (Account a : accounts) {
				System.out.println(a.getId() + ": Balance: " + a.getBalance());
			}
		}

		System.out.println("\n");

	}

	// login
	public User login(String username, String password) {

		User user = this.udao.getUserByUsername(username);

		try {
			user.setAccounts(adao.getAccountsForUser(user));

			// check if password is correct
			if (user.getPassword().equals(password)) {
				System.out.println("\n");
				System.out.println("Welcome " + username);
				return user;

			} else {
				System.out.println("\n");
				System.out.println("Invalid password");
				System.out.println("\n");
				System.out.println("\n");
			}

		} catch (NullPointerException e) {

		}

		return null;

	}

	// account
	public List<Account> accounts(User user) {
		return adao.getAccountsForUser(user);
	}

	// create users
	public User createUser(User user) {

		this.udao.createUser(user);

		return user;
	}

	// view users
	public void viewUsers() {

		List<User> users = udao.getUsers();

		if (users.isEmpty()) {
			System.out.println("There are currently no users");
		} else {

			for (User u : users) {

				System.out.println(u.getId() + ": " + u.getUsername());

			}
			System.out.println("\n");
		}

	}

	// change username
	public boolean changeUsername(int id, String username) {

		this.udao.changeUsername(id, username);

		return true;

	}

	// change password
	public boolean changePassword(int id, String password) {

		this.udao.changePassword(id, password);

		return true;

	}

	// delete user
	public User deleteUser(int id) {

		try {
			User user = udao.getUserById(id);

			this.udao.deleteUser(user);

			return user;
		} catch (NullPointerException e) {
			System.out.println("Invalid User ID");
		}
		return null;
	}

}
