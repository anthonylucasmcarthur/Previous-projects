import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import org.junit.FixMethodOrder;


import dev.mcarthur.DAO.UserDAO;
import dev.mcarthur.DAO.UserJDBCDAO;
import dev.mcarthur.DAO.UserLocalDAO;
import dev.mcarthur.entities.User;
import dev.mcarthur.services.UserService;
import dev.mcarthur.services.UserServiceImpl;
import junit.framework.Assert;

public class UserDAOTests {


//	UserDAO udao = new UserLocalDAO();
	UserDAO udao = new UserJDBCDAO();
	
	//JUnit tests do not run in order

	// most tests should be atomic (a test cannot be broken into smaller tests)
	@Test
	public void createUser() {
		
		User user = new User(0,"Jack", "password", false);		
		int id = udao.createUser(user);
		System.out.println(id);
	}
	
	@Test
	public void getUserById() {
//		User user = new User(0,"JasonC", "password", false);		
//		udao.createUser(user);
//		System.out.println(user);
//		Assert.assertNotNull(user);
		System.out.println(udao.getUserById(1));
	}
	
	
	@Test
	public void getUserByUsername() {
//		User user = new User(0,"JasonC", "password", false);
//		udao.createUser(user);
//		System.out.println(user);
//		Assert.assertNotNull(user);
		System.out.println(udao.getUserByUsername("JasonC"));
	}
	
	
	@Test
	public void changeUsername() {
//		User user = new User(2,"Max", "word", false);
//		System.out.println(user);
		udao.changeUsername(5,"Jeff");
//		Assert.assertNotNull(t);
//		System.out.println(user);
	}
	
	@Test
	public void updateUser() {

		udao.changePassword(3,"letmein");

	}
	
	
	@Test
	public void deleteUser() {
		
		User user = udao.getUserById(43);
//		User user1 = new User(0,"Ja", "pas", false);
//		
//		udao.createUser(user);
//		udao.createUser(user1);
//		
//		System.out.println(UserLocalDAO.usertable);
//		System.out.println("\n");
		udao.deleteUser(user);
//		udao.deleteUser(user1);
	//	Assert.assertNotNull(t);
//		System.out.println(UserLocalDAO.usertable);
	}
	
	
	
}
