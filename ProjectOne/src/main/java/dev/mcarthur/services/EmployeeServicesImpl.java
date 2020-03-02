package dev.mcarthur.services;


import java.util.Date;
import java.util.List;

import dev.mcarthur.DAO.EmployeeDAO;
import dev.mcarthur.DAO.EmployeeJDBCDAO;
import dev.mcarthur.DAO.ReimbursementDAO;
import dev.mcarthur.DAO.ReimbursementJDBCDAO;
import dev.mcarthur.entities.Employee;
import dev.mcarthur.entities.Reimbursement;

public class EmployeeServicesImpl implements EmployeeServices {

	EmployeeDAO edao = new EmployeeJDBCDAO();
	ReimbursementDAO rdao = new ReimbursementJDBCDAO();

	public Employee login(String username, String password) {
		
		Employee employee = edao.getEmployeeByUsername(username);

		try {
			if (employee.getPassword().equals(password)) {
				return employee;
			} else {
				System.out.println("Invalid password");
			}
		} catch (NullPointerException e) {
//				e.printStackTrace();
		}
		return null;
	}

	public Reimbursement submitReimbursement(String username, double amount, String comment) {
		Employee employee = edao.getEmployeeByUsername(username);
		int id = rdao.createReimbursement(employee, amount, comment);
		Reimbursement reimbursement = rdao.getReimbursementById(id);
		return reimbursement;
	}

	public List<Reimbursement> getReimbursementsForEmployee(Employee employee) {
		return rdao.getReimbursementsForEmployee(employee);

	}

	public List<Reimbursement> viewAllReimbursements() {
				return rdao.getAllReimbursements();
	}

	public Reimbursement approveReimbursement(Reimbursement reimbursement, String comment) {
		return rdao.updateReimbursement(reimbursement, "Approved", comment);
	}

	public Reimbursement denyReimbursement(Reimbursement reimbursement, String comment) {
		return rdao.updateReimbursement(reimbursement, "Denied", comment);

	}

	public List<Reimbursement> getReimbursementsForDate() {
		return rdao.getReimbursementsForDate();
	}

	public List<Reimbursement> getReimbursementForAmount() {
		return rdao.getReimbursementsForAmount();
	}
	
	public List<Reimbursement> getReimbursementsForEmployeeId() {
		return rdao.getReimbursementsForEmployeeID();
	}
	

	public Employee getEmployeeByUsername(String username) {
		return edao.getEmployeeByUsername(username);
	}

	public Reimbursement getReimbursementById(int id) {
		return rdao.getReimbursementById(id);
	}

	
	

}
