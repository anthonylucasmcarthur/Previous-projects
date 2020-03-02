package dev.mcarthur.DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import dev.mcarthur.entities.Employee;
import dev.mcarthur.entities.Reimbursement;
import dev.mcarthur.utilities.ConnectionUtil;


public class ReimbursementJDBCDAO implements ReimbursementDAO {
	 
	
	public int createReimbursement(Employee employee, double amount, String comment) {
		Connection conn = ConnectionUtil.getConnection();
		String sql = "INSERT INTO reimbursements VALUES (?,?,?,?,?,?,?);";
		long millis=System.currentTimeMillis();  
		Date date = new Date(millis);
		

		try {
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, 0);
			ps.setInt(2, employee.getId());
			ps.setDouble(3, amount);
			ps.setObject(4, date);
			ps.setString(5, "pending");
			ps.setString(6, comment);
			ps.setString(7, "");
			
			

			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();
			rs.next();

			int generatedid = rs.getInt("r_id");

			return generatedid;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		return 0;
	}

	public Reimbursement getReimbursementById(int id) {
		Connection conn = ConnectionUtil.getConnection();
		String sql = "SELECT * FROM reimbursements WHERE r_id = ?;";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			Reimbursement reimbursement = new Reimbursement();
			while (rs.next()) {

				reimbursement.setR_id(rs.getInt("r_id"));
				reimbursement.setE_id(rs.getInt("e_id"));
				reimbursement.setAmount(rs.getDouble("amount"));
				reimbursement.setDate(rs.getDate("r_date"));
				reimbursement.setStatus(rs.getString("status"));
				reimbursement.setComment(rs.getString("comment"));
				reimbursement.setManagercomment(rs.getString("man_com"));

			}

			return reimbursement;
		
		} catch (SQLException e) {
			e.printStackTrace();

			
		}

		return null;
	}

	public List<Reimbursement> getReimbursementsForEmployeeID() {
		Connection conn = ConnectionUtil.getConnection();
		String sql = "Select * FROM reimbursements ORDER BY e_id";

		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Reimbursement reimbursement = new Reimbursement();
				reimbursement.setR_id(rs.getInt("r_id"));
				reimbursement.setE_id(rs.getInt("e_id"));
				reimbursement.setAmount(rs.getDouble("amount"));
				reimbursement.setDate(rs.getDate("r_date"));
				reimbursement.setStatus(rs.getString("status"));
				reimbursement.setComment(rs.getString("comment"));
				reimbursement.setManagercomment(rs.getString("man_com"));
				
				reimbursements.add(reimbursement);
			}

			return reimbursements;

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return null;
	}
	
	public List<Reimbursement> getReimbursementsForEmployee(Employee employee) {
		Connection conn = ConnectionUtil.getConnection();
		String sql = "SELECT * FROM reimbursements WHERE e_id = ?;";

		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, employee.getId());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Reimbursement reimbursement = new Reimbursement();
				reimbursement.setR_id(rs.getInt("r_id"));
				reimbursement.setE_id(rs.getInt("e_id"));
				reimbursement.setAmount(rs.getDouble("amount"));
				reimbursement.setDate(rs.getDate("r_date"));
				reimbursement.setStatus(rs.getString("status"));
				reimbursement.setComment(rs.getString("comment"));
				reimbursement.setManagercomment(rs.getString("man_com"));
				
				reimbursements.add(reimbursement);
			}

			return reimbursements;

		} catch (SQLException e) {
			e.printStackTrace();

		}
	
		return null;
	}
	
	public List<Reimbursement> getAllReimbursements() {
		Connection conn = ConnectionUtil.getConnection();
		String sql = "SELECT * FROM reimbursements;";

		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Reimbursement reimbursement = new Reimbursement();
				reimbursement.setR_id(rs.getInt("r_id"));
				reimbursement.setE_id(rs.getInt("e_id"));
				reimbursement.setAmount(rs.getDouble("amount"));
				reimbursement.setDate(rs.getDate("r_date"));
				reimbursement.setStatus(rs.getString("status"));
				reimbursement.setComment(rs.getString("comment"));
				reimbursement.setManagercomment(rs.getString("man_com"));

				reimbursements.add(reimbursement);
			}

			return reimbursements;

		} catch (SQLException e) {
			e.printStackTrace();

		}
	
		return null;
	}

	public List<Reimbursement> getReimbursementsForDate() {
		Connection conn = ConnectionUtil.getConnection();
		String sql = "Select * FROM reimbursements ORDER BY r_date";

		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
//			java.sql.Date sDate = new java.sql.Date(date.getTime());
//			ps.setDate(1, sDate);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Reimbursement reimbursement = new Reimbursement();
				reimbursement.setR_id(rs.getInt("r_id"));
				reimbursement.setE_id(rs.getInt("e_id"));
				reimbursement.setAmount(rs.getDouble("amount"));
				reimbursement.setDate(rs.getDate("r_date"));
				reimbursement.setStatus(rs.getString("status"));
				reimbursement.setComment(rs.getString("comment"));
				reimbursement.setManagercomment(rs.getString("man_com"));

				reimbursements.add(reimbursement);
			}

			return reimbursements;

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return null;
	}

	public List<Reimbursement> getReimbursementsForAmount() {
		Connection conn = ConnectionUtil.getConnection();
//		String sql = "SELECT * FROM reimbursements WHERE amount = ?;";
		String sql = "Select * FROM reimbursements ORDER BY amount";

		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setDouble(1, amount);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Reimbursement reimbursement = new Reimbursement();
				reimbursement.setR_id(rs.getInt("r_id"));
				reimbursement.setE_id(rs.getInt("e_id"));
				reimbursement.setAmount(rs.getDouble("amount"));
				reimbursement.setDate(rs.getDate("r_date"));
				reimbursement.setStatus(rs.getString("status"));
				reimbursement.setComment(rs.getString("comment"));
				reimbursement.setManagercomment(rs.getString("man_com"));

				reimbursements.add(reimbursement);
			}

			return reimbursements;

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return null;
	}
	
	

	
	public Reimbursement updateReimbursement(Reimbursement reimbursement, String status, String managercomment) {
		Connection conn = ConnectionUtil.getConnection();
		String sql = "UPDATE reimbursements SET status = ?, man_com = ? WHERE r_id = ?;";


		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, status);
			ps.setString(2, managercomment);
			ps.setInt(3, reimbursement.getR_id());
			
			ps.execute();
			System.out.println(reimbursement);
			return reimbursement;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	public boolean deleteReimbursement(Reimbursement reimbursement) {
		// TODO Auto-generated method stub
		return false;
	}

	
	

	

	


}
