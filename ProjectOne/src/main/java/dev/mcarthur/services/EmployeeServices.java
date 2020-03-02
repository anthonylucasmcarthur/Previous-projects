package dev.mcarthur.services;


import java.util.Date;
import java.util.List;

import dev.mcarthur.entities.Employee;
import dev.mcarthur.entities.Reimbursement;

public interface EmployeeServices {
	
	
	// Employee methods
	Employee login(String username, String password);

	Reimbursement submitReimbursement(String username, double amount, String comment);
	
	List<Reimbursement> getReimbursementsForEmployee(Employee employee);
	
	
	
	
	// Manager methods
	List<Reimbursement> viewAllReimbursements();
	
	Reimbursement approveReimbursement(Reimbursement reimbursement, String comment);
	
	Reimbursement denyReimbursement(Reimbursement reimbursement, String comment);
	
	List<Reimbursement> getReimbursementsForDate();
	
	List<Reimbursement> getReimbursementForAmount();
	
	List<Reimbursement> getReimbursementsForEmployeeId();
	
	
	
	Employee getEmployeeByUsername(String username);
	
	Reimbursement getReimbursementById(int id);
	
	
	
}
