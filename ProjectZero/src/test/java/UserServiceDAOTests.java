import static org.junit.Assert.*;

import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

import dev.mcarthur.DAO.UserDAO;
import dev.mcarthur.DAO.UserJDBCDAO;
import dev.mcarthur.DAO.UserLocalDAO;
import dev.mcarthur.entities.Account;
import dev.mcarthur.entities.User;
import dev.mcarthur.services.UserService;
import dev.mcarthur.services.UserServiceImpl;

public class UserServiceDAOTests {

	UserService services = new UserServiceImpl();
	UserDAO udao = new UserJDBCDAO();
	
	
	
	@Test
	public void createAccount() {
//		User user = new User(0, "username", "password", false);
//		System.out.println(user);
//		System.out.println("\n");
		User user = udao.getUserById(2);
		services.createAccount(user,120.0);
//		System.out.println(us);
	}
	
	
	@Test
	public void deleteAccount() {
//		User user = new User(0, "username", "password", false);
//		services.createAccount(user, 0);
//		services.createAccount(user, 40);
//		System.out.println(user);
//		System.out.println("\n");
		User user = udao.getUserById(2);
		services.deleteAccount(user, 13);
//		System.out.println(user);
	}
	
	
	@Test
	public void deposit() {
//		User user = new User(0, "username", "password", false);
//		services.createAccount(user, 40);
//		System.out.println(user);
//		System.out.println("\n");
		User user = udao.getUserById(2);
		services.deposit(user, 11, 10);
		System.out.println(user);
	
	}
	
	
	@Test
	public void withdraw() {
//		User user = new User(0, "username", "password", false);
//		services.createAccount(user, 40);
//		System.out.println(user);
//		System.out.println("\n");
		User user = udao.getUserById(2);
		services.withdraw(user, 16, 120);
		System.out.println(user);
	}
	
	
	@Test
	public void printAccounts() {
//		User user = new User(0, "username", "password", false);
//		services.createAccount(user, 20);
//		services.createAccount(user, 40);
		User user = udao.getUserById(2);
		services.printAccounts(user);
	}
	
	
	@Test
	public void login() {
//		User user = new User(0, "username", "password", false);
//		services.createUser(user);
//		Map<Integer,User> d= UserLocalDAO.usertable;
//		System.out.println(d);
//		System.out.println("\n");
		User u =services.login("Jack", "p");
		System.out.println(u);
		
		}
	
	@Test 
	public void createUser() {
		User user = new User(0, "paul", "password", false);
		System.out.println(user);
		User us = services.createUser(user);
		System.out.println(us);
	}
	
	@Test
	public void viewUsers() {
//		User user = new User(0, "username", "password", false);
//		services.createUser(user);
//		services.createAccount(user, 20);
//		User user1 = new User(0, "us", "pa", false);
//		services.createUser(user1);
//		services.createAccount(user1, 40);
//		Map<Integer,User> d= UserLocalDAO.usertable;
//		System.out.println(d);
//		System.out.println("\n");
//		Map<Integer, User> map = new TreeMap<Integer, User>();
		services.viewUsers();
		}
	
	@Test
	public void changeUsername() {

		services.changeUsername(4, "kon");

	}
	
	@Test
	public void changePassword() {

		services.changePassword(36, "original");

	}
	
	
	@Test
	public void deleteUser() {
//		User user = new User(0, "username", "password", false);
//		services.createUser(user);
//		User user1 = new User(0, "us", "pa", false);
//		services.createUser(user1);
//		Map<Integer,User> d= UserLocalDAO.usertable;
//		System.out.println(d);
		services.deleteUser(5);
//		Map<Integer,User> e= UserLocalDAO.usertable;
//		System.out.println(e);
	}
	
	

}
