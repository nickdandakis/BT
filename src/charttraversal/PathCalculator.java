package charttraversal;

import java.util.ArrayList;

public class PathCalculator {

	
	public String calculate (ArrayList<Employee> company, String emp1, String emp2) {
		String shortestPath = "";
		boolean emp1Found = false;
		boolean emp2Found = false;
		
		for (Employee emp : company) {
			if (emp.getName().equalsIgnoreCase(emp1)) {
				emp1Found = true;
			}
			
			if (emp.getName().equalsIgnoreCase(emp2)) {
				emp2Found = true;
			}
		}
		
		
		return shortestPath;
	}
}
