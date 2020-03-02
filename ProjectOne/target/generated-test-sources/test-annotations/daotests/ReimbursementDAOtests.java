package daotests;





import java.sql.Date;

import org.junit.Test;

import dev.mcarthur.DAO.EmployeeDAO;
import dev.mcarthur.DAO.EmployeeJDBCDAO;
import dev.mcarthur.DAO.ReimbursementDAO;
import dev.mcarthur.DAO.ReimbursementJDBCDAO;
import dev.mcarthur.entities.Employee;
import dev.mcarthur.entities.Reimbursement;
import junit.framework.TestCase;

public class ReimbursementDAOtests extends TestCase {
	
		ReimbursementDAO rdao = new ReimbursementJDBCDAO();
		EmployeeDAO edao = new EmployeeJDBCDAO();
		
	@Test
	public void testcreateReimbursement() {
		Employee employee = edao.getEmployeeById(1);

		rdao.createReimbursement(employee, 20,"please");
		
	}
	
	
	@Test
	public void testgetReimbursementsForEmployee() {
		
		Employee employee = edao.getEmployeeById(1);
		
		System.out.println(rdao.getReimbursementsForEmployee(employee));
		
		
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
	public void testgetReimbursementByDate() {
	  
		Date date = new Date(System.currentTimeMillis()); 
		System.out.println(rdao.getReimbursementsForDate(date));
		
	}
	
	@Test
	public void testupdateReimbursement() {
		
		Reimbursement reimbursement = rdao.getReimbursementById(4);
		
		reimbursement = rdao.updateReimbursement(reimbursement, "Approve", "Your good");
		
		System.out.println(reimbursement);
		
	}
	
}
