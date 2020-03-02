package dev.mcarthur.DAO;



import java.util.List;


import dev.mcarthur.entities.User;

// CRUD
public interface UserDAO {

	// Create
	int createUser(User user);
	
	// Read
	User getUserById(int id);
	User getUserByUsername(String username);
	List<User> getUsers();
	
	// Update
	boolean changeUsername(int id, String username);
	boolean changePassword(int id, String password);
	
	
	// Delete
	boolean deleteUser(User user);
	

		
}
