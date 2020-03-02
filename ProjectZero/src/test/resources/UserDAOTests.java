import static org.junit.Assert.*;

import org.junit.Test;

public class UserDAOTests {

	


	RegisteredUserDAO udao = new RegisteredUserLocalDAO();
	
	//JUnit tests do not run in order

	// most tests should be atomic (a test cannot be broken into smaller tests)
	@Test
	public void createUser() {
		
		RegisteredUser user = new RegisteredUser(0,"JasonC", "password");		
		int id = udao.createUser(user);
		System.out.println(user);
	}
	
	@Test
	public void getUserById() {
		
		RegisteredUser user = udao.getUserById(1001);
		Assert.assertNotNull(user);
		System.out.println(user);
	}
	

}
