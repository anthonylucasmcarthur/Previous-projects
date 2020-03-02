package dev.mcarthur.DAO;



import dev.mcarthur.entities.Employee;



public interface EmployeeDAO {

	// Create
	int createEmployee(String username, String password);
	
	// Read
	Employee getEmployeeByUsername(String username);
	Employee getEmployeeById(int id);
	
	
	// Update
	boolean updateEmployee(Employee employee);
	
	// Delete
	boolean deleteEmployee(Employee employee);
	
}
