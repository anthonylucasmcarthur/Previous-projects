import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import org.junit.FixMethodOrder;
import org.hamcrest.*;
import org.junit.*;
import dev.mcarthur.DAO.AccountDAO;
import dev.mcarthur.DAO.AccountJDBCDAO;
import dev.mcarthur.DAO.AccountLocalDAO;
import dev.mcarthur.DAO.UserDAO;
import dev.mcarthur.DAO.UserJDBCDAO;
import dev.mcarthur.entities.Account;
import dev.mcarthur.entities.User;
import dev.mcarthur.services.UserService;
import dev.mcarthur.services.UserServiceImpl;
import junit.framework.Assert;

public class AccountDAOTests {

	UserService service = new UserServiceImpl();
//	AccountDAO udao = new AccountLocalDAO();
	AccountDAO adao = new AccountJDBCDAO();
	UserDAO udao = new UserJDBCDAO();
	
	//JUnit tests do not run in order

	// most tests should be atomic (a test cannot be broken into smaller tests)
	@Test
	public void createAccount() {
		
//		User user = new User(0,"j", "pass", false);
		User user = udao.getUserById(2);
//		service.createUser(user);
		adao.createAccount(user, 20);
		System.out.println(user);
	}
	
	@Test
	public void getAccountsById() {
//		User user = new User(0,"JasonC", "password", false);
//		service.createAccount(user, 50.0);
		
		System.out.println(adao.getAccountsById(1));
	}
	
	
	@Test
	public void getAccountsForUser() {
		User user = udao.getUserById(2);
//		User user = new User(0,"jjdd", "password", false);
//		service.createUser(user);
//		Account account = new Account(0, 4, 20.0);
//		adao.createAccount(account, 30);
		Set<Account> accounts = adao.getAccountsForUser(user);
		Assert.assertNotNull(accounts);
		System.out.println(accounts);
	}
	
	
	@Test
	public void deposit() {
//		Account account = new Account(0,0, 300.0);	
//		int id = udao.createAccount(account);
//		System.out.println(account);
		
		adao.deposit(2, 100.0);
	
	}


	@Test
	public void withdraw() {
//		Account account = new Account(0,0, 400.0);	
//		int  id = udao.createAccount(account);
//		System.out.println(account);
		adao.withdraw(2, 100.0);
		

	}
	
	@Test 
	public void deleteAccount() {
//		Account account1 = new Account(1,0, 500.0);
//		udao.createAccount(account1);
//		Account account2 = new Account(2,0, 200.0);
//		udao.createAccount(account2);
//		Account account3 = new Account(3,0, 100.0);
//		udao.createAccount(account3);
		Account account = adao.getAccountsById(7);
		adao.deleteAccount(account);
		
	}
	
}
