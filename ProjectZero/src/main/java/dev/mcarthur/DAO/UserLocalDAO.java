package dev.mcarthur.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dev.mcarthur.entities.User;

public class UserLocalDAO implements UserDAO {

	// this map simulate what will be our in SQL when we get there
	// <id,student>
	public static final Map<Integer, User> usertable = new HashMap<Integer, User>();

	// id creation is handled by the Database
	// in good practice id always start above 0
	private int idmaker = 1000;

	public int createUser(User user) {
		// add user and create an id for them
		idmaker++;
		user.setId(idmaker);
		usertable.put(idmaker, user);

		// return the id of the user
		return idmaker - 1;
	}

	public User getUserById(int id) {
		User user = usertable.get(id);
		return user;
	}

	public User getUserByUsername(String username) {
		List<User> users = new ArrayList<User>(usertable.values());

		for (User u : users) {

			if (u.getUsername().equals(username)) {
				return u;
			}
		}
		return null;
	}

	public User updateUser(User user) {
		usertable.put(user.getId(), user);
		return user;
	}

	public User deleteUser(User user) {
		if (user.getId() == 1001) {
			System.out.println("Superuser can't be deleted");
		} else {
			usertable.remove(user.getId());
		}
		return user;
	}

	@Override
	public String toString() {
		return "UserLocalDAO [idmaker=" + idmaker + "]";
	}

}
