package daotests;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

import dev.mcarthur.DAO.EmployeeDAO;
import dev.mcarthur.DAO.EmployeeJDBCDAO;
import dev.mcarthur.DAO.ReimbursementDAO;
import dev.mcarthur.DAO.ReimbursementJDBCDAO;
import dev.mcarthur.entities.Employee;
import dev.mcarthur.entities.Reimbursement;

public class ReimbursementsTests {

	
	ReimbursementDAO rdao = new ReimbursementJDBCDAO();
	EmployeeDAO edao = new EmployeeJDBCDAO();
	
	
	
	

	@Test
	public void testcreateReimbursement() {
		Employee employee = edao.getEmployeeById(2);

		rdao.createReimbursement(employee, 0, "no reason");

	}

	@Test
	public void testgetReimbursementsForEmployee() {

		Employee employee = edao.getEmployeeById(1);

		System.out.println(rdao.getReimbursementsForEmployee(employee));

	}
	
	
	@Test
	public void testgetReimbursementForEmployeeID() {
		System.out.println(rdao.getReimbursementsForEmployeeID());
		
	}

	

	@Test
	public void testgetReimbursementById() {

		System.out.println(rdao.getReimbursementById(2));

	}

	@Test
	public void testgetAllReimbursement() {

		System.out.println(rdao.getAllReimbursements());

	}
	
	
	@Test
	public void testsortReimbursementByAmount() {

		System.out.println(rdao.getReimbursementsForAmount());

	}
	

	@Test
	public void testgetReimbursementByDate() {

		Date date = new Date(System.currentTimeMillis());
		System.out.println(rdao.getReimbursementsForDate());

	}

	@Test
	public void testupdateReimbursement() {

		Reimbursement reimbursement = rdao.getReimbursementById(1);

		reimbursement = rdao.updateReimbursement(reimbursement, "Approve", "Your good");

		System.out.println(reimbursement);

	}
}
