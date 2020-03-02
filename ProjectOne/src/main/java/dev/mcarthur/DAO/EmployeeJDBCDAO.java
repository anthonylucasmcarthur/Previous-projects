package dev.mcarthur.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dev.mcarthur.entities.Employee;
import dev.mcarthur.utilities.ConnectionUtil;

public class EmployeeJDBCDAO implements EmployeeDAO {

	public int createEmployee(String  username, String password) {
		Connection conn = ConnectionUtil.getConnection();
		String sql = "INSERT INTO employees VALUES (?,?,?,?);";

		try {
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, 0);
			ps.setString(2, username);
			ps.setString(3, password);
			ps.setBoolean(4, false);
			

			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();

			int generatedid = rs.getInt("e_id");

			return generatedid;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		return 0;
	}
	

	
	public Employee getEmployeeByUsername(String username) {
		Connection conn = ConnectionUtil.getConnection();
		String sql = "SELECT * FROM employees WHERE username = ?";
		try {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			// result set initially points before the first record
			rs.next(); // moves pointer to first record

			Employee employee = new Employee();
			employee.setId(rs.getInt("e_id"));
			employee.setUsername(rs.getString("username"));
			employee.setPassword(rs.getString("password"));
			employee.setIsmanager(rs.getBoolean("is_manager"));
			return employee;

		} catch (SQLException e) {
			e.printStackTrace();
//			System.out.println("Invalid username");
			
		} catch(NullPointerException e) {
			e.printStackTrace();
			//System.out.println("Invalid username");
		}
		return null;
	}
	
	
	
	public Employee getEmployeeById(int id) {
		Connection conn = ConnectionUtil.getConnection();

		String sql = "SELECT * FROM employees WHERE e_id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			// result set initially points before the first record
			rs.next(); // moves pointer to first record

			Employee employee = new Employee();
			employee.setId(rs.getInt("e_id"));
			employee.setUsername(rs.getString("username"));
			employee.setPassword(rs.getString("password"));
			employee.setIsmanager(rs.getBoolean("is_manager"));
			return employee;

		} catch (SQLException e) {
			e.printStackTrace();
			
		}

		return null;
		
	}



	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
