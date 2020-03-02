package dev.mcarthur.DAO;

import java.util.Date;
import java.util.List;

import dev.mcarthur.entities.Employee;
import dev.mcarthur.entities.Reimbursement;

public interface ReimbursementDAO {
	
	// Create
	int createReimbursement(Employee employee, double amount, String comment);
	
	// Read
	Reimbursement getReimbursementById(int id);
	List<Reimbursement> getReimbursementsForEmployee(Employee employee);
	List<Reimbursement> getReimbursementsForEmployeeID();
	List<Reimbursement> getAllReimbursements();
	List<Reimbursement> getReimbursementsForDate();
	List<Reimbursement> getReimbursementsForAmount();
	
	// Update
	Reimbursement updateReimbursement(Reimbursement reimbursement, String status, String managercomment);
	
	
	// Delete
	boolean deleteReimbursement(Reimbursement reimbursement);

}
