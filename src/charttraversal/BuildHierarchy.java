package charttraversal;

import java.util.ArrayList;

public class BuildHierarchy {
	public ArrayList<Employee> build (ArrayList<Employee> company) {		
		/*
		 * Now, for each of the employees, add bosses and subordinates.
		 */
		
		for (Employee emp : company) {
			/*
			 * For each employee in the company, look at the ID of their boss.
			 * If they are not at the top of the company (i.e. have a boss)
			 * then search the company for their boss.
			 * When you find their boss, add the boss object to the employee object
			 * so the employee now has a linked boss.
			 * At the same time, add the employee as a subordinate to the boss
			 * so we don't need to go round again looking for subordinates.
			 */
			if (emp.getBossID() > -1) {
				for (Employee boss : company) {
					if (boss.getId() == emp.getBossID()) {
						emp.setManager(boss);
						boss.addSubordinate(emp);
					}
				}
			}
			
		}
			
		/*
		 * Now the company should consist of a bunch of employees, 
		 * each pointing to their own direct bosses and subordinates.
		 * (which in turn point to their own... etc.)
		 * Hence the entire company hierarchy should now be stored in company;
		 * where company is a list of employees each pointing to each other.
		 */
			
		return company;
	}
}
