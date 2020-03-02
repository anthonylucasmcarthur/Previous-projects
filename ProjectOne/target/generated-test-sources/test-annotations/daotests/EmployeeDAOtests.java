package daotests;

import static org.junit.Assert.*;

import org.junit.Test;

import dev.mcarthur.DAO.EmployeeDAO;
import dev.mcarthur.DAO.EmployeeJDBCDAO;

public class EmployeeDAOtests {
	
	EmployeeDAO edao = new EmployeeJDBCDAO();

	
	@Test
	public void getEmployeeByUsername() throws ClassNotFoundException {
		
		System.out.println(edao.getEmployeeByUsername("Test"));
		
	}
	
	
	@Test
	public void getEmployeeById() throws ClassNotFoundException {
		
		System.out.println(edao.getEmployeeById(1));
		
	}

}
