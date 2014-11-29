package charttraversal;

import java.util.HashMap;
import java.util.Map;

public class BuildHierarchy {
	/*
	 * Build a hashmap of employees with managers and subordinates (using the original hasmap of employees).
	 */
	public HashMap<Integer, Employee> build (HashMap<Integer, Employee> company) {		
		/*
		 * Now, for each of the employees, add bosses and subordinates.
		 */
		
		/*
		 * IMPORTANT NOTE: This doesn't deal with gaps in the hierarchy.
		 */
		for (Map.Entry<Integer, Employee> entry : company.entrySet()) {
			/*
			 * For each employee in the company, look at the ID of their boss.
			 * If they are not at the top of the company (i.e. have a boss)
			 * then set their boss as the employee in the hashmap with their boss's ID
			 * (i.e. ...their boss, because the employees are stored in the hashmap with their ID as key).
			 * Similarly, get their boss from the hashmap and add the employee as a subordinate.
			 */
			
			Employee emp = entry.getValue();
			if (emp.getBossID() > -1) {
				/*
				 * If the person's boss has left the company, 
				 * then start a new tree. 
				 * Note, everyone in this new tree will not be connected to 
				 * anyone in the original tree.
				 */
				try {
					company.get(emp.getBossID()).addSubordinate(company.get(emp.getId()));
					emp.setManager(company.get(emp.getBossID()));
				} catch (NullPointerException e){
					emp.setBossID(-1);
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
