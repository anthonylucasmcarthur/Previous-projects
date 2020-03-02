package dev.mcarthur.App;

import java.util.Scanner;
import dev.mcarthur.entities.User;
import dev.mcarthur.services.UserServiceImpl;

public class BankApp {

	public static void main(String[] args) {

		// User services object
		UserServiceImpl services = new UserServiceImpl();

		// start scanner
		final Scanner scan = new Scanner(System.in);

		long time = 0;

		System.out.println("Welcome to the Bank App");

		// blank user object
		User user = new User(0, " ", " ", false);

		do {

			while (true) {

				System.out.println("\n");
				System.out.println("Are you a returning customer?");
				String response = scan.nextLine();
				

				if (response.equals("no")) {

					System.out.println("\n");

					System.out.println("Make a username:");

					String username = scan.nextLine();

					System.out.println("\n");
					System.out.println("Make a password");

					String password = scan.nextLine();

					user = new User(0, username, password, false);

					user = services.createUser(user);

					System.out.println("\n");
					System.out.println("Welcome " + user.getUsername());
					break;

					// if user has account
				} else if (response.equals("yes")) {

					System.out.println("\n");

					System.out.println("Enter your username:");

					String username = scan.nextLine();

					System.out.println("\n");
					System.out.println("Enter your password");

					String password = scan.nextLine();

					user = services.login(username, password);
					break;
				} else {

					System.out.println("\n");
					System.out.println("Invalid Input");

				}

			}
			boolean b;

			try {
				b = user.isIssuperuser();
			} catch (NullPointerException npe) {
				continue;
			}

			// if is super user
			if (b == true) {

				boolean loggedin = true;

				while (loggedin) {
					try {
						System.out.println("\n");
						System.out.println("Select an option:");
						System.out.println("1. View Users:");
						System.out.println("2: Create User");
						System.out.println("3. Change Username");
						System.out.println("4. Change Password");
						System.out.println("5. Delete User");
						System.out.println("6. Logout");
						System.out.println("\n");

						int num = scan.nextInt();
						scan.nextLine();
						scan.nextLine();

						switch (num) {

						case 1: // view users
							System.out.println("All users:");
							services.viewUsers();
							break;

						case 2: // create user
							System.out.println("\n");
							System.out.println("Make a username:");
							String username = scan.nextLine();
							System.out.println("\n");
							System.out.println("Make a password");
							String password = scan.nextLine();
							System.out.println("\n");
							User newuser = new User(0, username, password, false);
							services.createUser(newuser);
							System.out.println("All users:");
							services.viewUsers();
							break;

						case 3: // change username
							System.out.println("\n");
							System.out.println("Select a user by ID");
							services.viewUsers();
							int id = scan.nextInt();
							scan.nextLine();
							System.out.println("\n");
							System.out.println("Enter new username:");
							String newusername = scan.nextLine();
							services.changeUsername(id, newusername);
							System.out.println("\n");
							System.out.println("All users:");
							services.viewUsers();
							break;

						case 4: // change password
							System.out.println("\n");
							System.out.println("Select a user by ID");
							services.viewUsers();
							int userid = scan.nextInt();
							scan.nextLine();
							System.out.println("\n");
							System.out.println("Enter new password:");
							String newpassword = scan.nextLine();
							services.changePassword(userid, newpassword);
							System.out.println("\n");
							System.out.println("All users:");
							services.viewUsers();
							break;

						case 5: // delete user
							System.out.println("\n");
							System.out.println("Select a user");
							services.viewUsers();
							int clientid = scan.nextInt();
							scan.nextLine();
							System.out.println("\n");
							services.deleteUser(clientid);
							System.out.println("All users:");
							services.viewUsers();
							break;

						case 6: // logout
							System.out.println("\n");
							System.out.println("Thank you for using the Bank App");
							System.out.println("\n");
							System.out.println("\n");
							System.out.println("\n");

							loggedin = false;
							break;
						}

					} catch (NullPointerException npe) {

						System.out.println("Invalid input");
					}

				}

			} else {

				// initialize boolean
				boolean istrue = true;

				while (istrue) {

					// what do you want to do
					System.out.println("\n");
					System.out.println("Please select from the following choices:");
					System.out.println("1. View Accounts");
					System.out.println("2. Make a Withdraw");
					System.out.println("3. Make a Deposit");
					System.out.println("4. Make an Acount");
					System.out.println("5. Delete Account");
					System.out.println("6. Logout");
					System.out.println("\n");

					try {
						switch (scan.nextInt()) {

						case 1: // print accounts
							System.out.println("\n");
							System.out.println("Here are your accounts:");
							services.printAccounts(user);
							break;

						case 2: // withdraw
							System.out.println("\n");
							if (services.accounts(user).isEmpty()) {
								System.out.println("You don't have any accounts");
								System.out.println("You must make an account first");
								break;
							}
							System.out.println("Select an account:");
							services.printAccounts(user);

							int accountnumber = scan.nextInt();
							scan.nextLine();
							System.out.println("\n");
							System.out.println("How much do you want you to withdraw?");
							double withdrawl = scan.nextDouble();
							scan.nextLine();
							services.withdraw(user, accountnumber, withdrawl);
							break;

						case 3: // deposit
							System.out.println("\n");
							if (services.accounts(user).isEmpty()) {
								System.out.println("You don't have any accounts");
								System.out.println("You must make an account first.");
								break;
							}

							System.out.println("Select an account:");
							services.printAccounts(user);
							int number = scan.nextInt();
							scan.nextLine();
							System.out.println("\n");
							System.out.println("How much do you want to deposit?");
							double deposit1 = scan.nextDouble();
							scan.nextLine();
							services.deposit(user, number, deposit1);
							break;

						case 4: // create account
							System.out.println("\n");
							System.out.println("You must make a deposit to open a account.");
							System.out.println("How  much do you want to deposit amount?");
							double deposit2 = scan.nextDouble();
							scan.nextLine();
							services.createAccount(user, deposit2);
							break;

						case 5: // delete account
							System.out.println("\n");
							if (services.accounts(user).isEmpty()) {
								System.out.println("You don't have any accounts");
								System.out.println("You must make an account first");
								break;
							}
							System.out.println("Select an account:");
							services.printAccounts(user);
							int account = scan.nextInt();
							scan.nextLine();
							services.deleteAccount(user, account);
							break;

						case 6: // log out
							System.out.println("\n");
							System.out.println("Thank you for using the Bank App");
							System.out.println("\n");
							System.out.println("\n");
							System.out.println("\n");

							istrue = false;
							break;
						}

						// invalid input
					} catch (NullPointerException npe) {
						System.out.println("Invalid Input");
					}

				}

			}

			// increase time
			time++;

		} while (time < 1000000000);

		// close scanner
		scan.close();

	}

}
