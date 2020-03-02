package dev.mcarthur.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import dev.mcarthur.entities.Account;
import dev.mcarthur.entities.User;
import dev.mcarthur.utility.ConnectionUtil;

public class AccountJDBCDAO implements AccountDAO {

	// create account
	public int createAccount(User user, double deposit) {
		Connection conn = ConnectionUtil.getConnection();
		String sql = "INSERT INTO account VALUES (?,?,?);";

		try {
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, 0);
			ps.setInt(2, user.getId());
			ps.setDouble(3, deposit);

			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();

			int generatedid = rs.getInt("a_id");

			return generatedid;

		} catch (SQLException e) {
			System.out.println("\n");
			System.out.println("You must log out and then back in before you can create an account");
//			e.printStackTrace();
		}

		return 0;

	}

	// get accounts by ID
	public Account getAccountsById(int id) {
		Connection conn = ConnectionUtil.getConnection();
		String sql = "SELECT * FROM account WHERE a_id = ?;";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			Account account = new Account();
			while (rs.next()) {

				account.setId(rs.getInt("a_id"));
				account.setUserid(rs.getInt("u_id"));
				account.setBalance(rs.getDouble("balance"));

			}

			return account;
		} catch (SQLNonTransientConnectionException e) {
			System.out.println("Invalid account number");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Invalid account number");
		}

		return null;
	}

	// get accounts for user
	public List<Account> getAccountsForUser(User user) {

		Connection conn = ConnectionUtil.getConnection();
		String sql = "SELECT * FROM account WHERE u_id = ?;";

		List<Account> accounts = new ArrayList<Account>();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getId());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Account account = new Account();
				account.setId(rs.getInt("a_id"));
				account.setUserid(rs.getInt("u_id"));
				account.setBalance(rs.getDouble("balance"));

				accounts.add(account);
			}

			return accounts;

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (NullPointerException e) {
			System.out.println("You don't have any accounts");
		}

		return null;

	}

	// deposit
	public boolean deposit(int id, double deposit) {
		Connection conn = ConnectionUtil.getConnection();
		String sql = "UPDATE account SET balance = ? WHERE a_id = ?;";

		Account account = getAccountsById(id);
		double newbalance = (account.getBalance() + deposit);

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, newbalance);
			ps.setInt(2, account.getId());

			ps.execute();

			return true;
		} catch (SQLException e) {
			System.out.println("Invalid Account Number");
			return false;
		}
	}

	// withdraw
	public boolean withdraw(int id, double withdrawl) {
		Connection conn = ConnectionUtil.getConnection();
		String sql = "UPDATE account SET balance = ? WHERE a_id = ?;";

		Account account = getAccountsById(id);
		double newbalance = (account.getBalance() - withdrawl);

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, newbalance);
			ps.setInt(2, account.getId());

			ps.execute();

			return true;
		} catch (SQLException e) {
			System.out.println("Invalid Account Number");
			return false;
		}
	}

	// delete account
	public boolean deleteAccount(Account account) {
		Connection conn = ConnectionUtil.getConnection();

		String sql = "DELETE FROM account WHERE a_id = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, account.getId());
			ps.execute();

			return true;
		} catch (SQLException e) {
			System.out.println("Invalid Account Number");

			return false;
		}

	}

}
