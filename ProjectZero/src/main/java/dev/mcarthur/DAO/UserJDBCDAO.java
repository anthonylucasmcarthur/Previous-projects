package dev.mcarthur.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import dev.mcarthur.entities.User;
import dev.mcarthur.utility.ConnectionUtil;

public class UserJDBCDAO implements UserDAO {

	// create user
	public int createUser(User user) {
		Connection conn = ConnectionUtil.getConnection();

		String sql = "INSERT INTO bank_user VALUES (?,?,?,?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, 0);
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setBoolean(4, false);

			ps.execute();

			// result set hold all the information you get back from the database in JDBC
			ResultSet rs = ps.getGeneratedKeys();
			// moves the cursor to the first element in the result set
			rs.next();
			int id = rs.getInt("id");

			return id;

		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("\n");
			System.out.println("Username already exists.");
			System.out.println("Make pick a different username.");
			System.out.println("\n");
		}

		return 0;

	}

	// get user by id
	public User getUserById(int id) {

		Connection conn = ConnectionUtil.getConnection();

		String sql = "SELECT * FROM bank_user WHERE u_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			// result set initially points before the first record
			rs.next(); // moves pointer to first record

			User user = new User();
			user.setId(rs.getInt("u_id"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setIssuperuser(rs.getBoolean("is_super"));
			return user;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Incorrect Id Number");
		}

		return null;

	}

	// get user by username
	public User getUserByUsername(String username) {
		Connection conn = ConnectionUtil.getConnection();

		String sql = "SELECT * FROM bank_user WHERE username = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			// result set initially points before the first record
			rs.next(); // moves pointer to first record

			User user = new User();
			user.setId(rs.getInt("u_id"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setIssuperuser(rs.getBoolean("is_super"));
			return user;

		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("\n");
			System.out.println("Incorrect Username");
		}

		return null;

	}

	// get users
	public List<User> getUsers() {

		Connection conn = ConnectionUtil.getConnection();
		String sql = "SELECT * FROM bank_user;";

		List<User> users = new ArrayList<User>();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("u_id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));

				users.add(user);
			}

			return users;

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return null;

	}

	// change username
	public boolean changeUsername(int id, String username) {
		Connection conn = ConnectionUtil.getConnection();
		String sql = "UPDATE bank_user SET username = ? WHERE u_id = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setInt(2, id);

			ps.execute();

			return true;
		} catch (SQLException e) {
			System.out.println("Invalid user ID");
			return false;
		}

	}

	// change password
	public boolean changePassword(int id, String password) {
		Connection conn = ConnectionUtil.getConnection();
		String sql = "UPDATE bank_user SET password = ? WHERE u_id = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setInt(2, id);

			ps.execute();

			return true;
		} catch (SQLException e) {
			System.out.println("Invalid user ID");
			return false;
		}

	}

	// delete user
	public boolean deleteUser(User user) {
		Connection conn = ConnectionUtil.getConnection();

		String sql = "DELETE FROM bank_user WHERE u_id = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getId());
			ps.execute();

			return true;
		} catch (SQLException e) {
			System.out.println("Invalid user ID");
			return false;
		}

	}

}
