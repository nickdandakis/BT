package charttraversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PathCalculator {

	/*
	 * Find a shortest path between the employees and output a string.
	 */
	public String calculate (HashMap<Integer, Employee> company, String emp1, String emp2) {
		String shortestPath = "";
		Employee employee1 = new Employee(null, 0, 0);
		Employee employee2 = new Employee(null, 0, 0);
		Integer[] emp1UpwardIDs = {};
		Integer[] emp2UpwardIDs = {};
		
		
		/*
		 * First, find the employees in the array.
		 */
		String[] check = checker(company, emp1, emp2);
		/*
		 * If either of the employees weren't found, 
		 * return apology generated in checker.
		 */
		if (check[0] != null) {
			shortestPath = check[0];
			return shortestPath;
		} 
				
		/*
		 * Otherwise, go on to output the shortest path.
		 */
		
		employee1 = company.get(Integer.parseInt(check[1]));
		employee2 = company.get(Integer.parseInt(check[2]));
		emp1UpwardIDs = getUpwardIDs(employee1);
		emp2UpwardIDs = getUpwardIDs(employee2);
		
		/*
		 * Unfortunately, tree traversal is pretty inefficient. 
		 * Old fashioned double loop through the respective managers.
		 * 
		 * When you find a matching pair of ID's in the chain of bosses,
		 * crop the arrays to contain only the chains iterated through so far.
		 */
		Boolean connected = false;
		Employee commonBoss = new Employee(null, 0, 0);
		outerloop:
		for (int i=0; i<emp1UpwardIDs.length; i++) {
			for (int j=0; j<emp2UpwardIDs.length; j++) {
				if (emp2UpwardIDs[j] == emp1UpwardIDs[i]) {
					/*
					 * We store the common boss as another employee instead
					 * of in the arrays (important for later when printing).
					 */
					commonBoss = company.get(emp1UpwardIDs[i]);
					emp1UpwardIDs = Arrays.copyOfRange(emp1UpwardIDs, 0, i);
					emp2UpwardIDs = Arrays.copyOfRange(emp2UpwardIDs, 0, j);
					connected = true;
					break outerloop;
				}
			}
		}
		
		/*
		 * If the two employees are connected somehow (i.e. there isn't a missing link in the hierarchy)
		 * then print out the shortest path between them.
		 */
		if (connected) {
			shortestPath = printFormatter(shortestPath, emp1UpwardIDs, emp2UpwardIDs, commonBoss, company);			
		} else {
			shortestPath = "It appears " + employee1.getName() + " and " + employee2.getName() + " are not connected in the company!";
		}
		
		return shortestPath;
	}
	
	
	/*
	 * pretty printer for the shortest path output.
	 */
	public String printFormatter (String shortestPath, Integer[] emp1UpwardIDs, Integer[] emp2UpwardIDs, Employee commonBoss, HashMap<Integer, Employee> company) {
		/*
		 * Print each employee whose ID is in employee 1's upward chain
		 */
		for (int i : emp1UpwardIDs) {
			shortestPath += company.get(i).getName() + " (" + i + ") -> ";
		}
		/*
		 * Print the combined boss (without any arrows!)
		 */
		shortestPath += commonBoss.getName() + " (" + commonBoss.getId() + ") ";
			
		/*
		 * Print each employee whose ID is in employee 1's upward chain
		 */
		for (int j = (emp2UpwardIDs.length -1); j>=0; j--) {
			shortestPath += "<- " + company.get(emp2UpwardIDs[j]).getName() + " (" + emp2UpwardIDs[j] + ") ";
		}
		
		return shortestPath;
	}
	
	
	
	/*
	 * Checks if the employees exist in the company. Returns array of ids 
	 * if they are, and error message if they aren't. 
	 */
	public String[] checker (HashMap<Integer, Employee> company, String emp1, String emp2) {
		/*
		 * Integer array corresponding to IDs of employees if they have been found.
		 */
		String[] check = new String[3];
		
		/*
		 * check[0] is the string output if an employee was not found.
		 * check[1] indicates the id of employee 1 (if found)
		 * check[2] indicates the id of employee 2 (if found)
		 */
		
		for (Map.Entry<Integer, Employee> entry : company.entrySet()) {
			if (entry.getValue().getName().equalsIgnoreCase(emp1)) {
				check[1] = Integer.toString(entry.getValue().getId());
			}
			
			if (entry.getValue().getName().equalsIgnoreCase(emp2)) {
				check[2] = Integer.toString(entry.getValue().getId());
			}
		}
		
		
		if ((check[1] == null) && (check[2] == null)) {
			//Neither employee was found.
			check[0] = "Sorry, neither " + emp1 + " nor " + emp2 + " could not be found in the company.";
		} else if (check[1] == null) {
			//Employee 1 only was not found.
			check[0] = "Sorry, " + emp1 + " could not be found in the company.";
		} else if (check[2] == null) {
			//Employee 2 only was not found.
			check[0] = "Sorry, " + emp2 + " could not be found in the company.";
		} else {
			//Both employees were found :-)
			check[0] = null;
		}
		
		
		return check;
	}
	
	
	
	
	/*
	 * Taking an employee, generate an (ordered) array of the employee IDs between them and the top of the company.
	 */
	public Integer[] getUpwardIDs (Employee emp) {
		ArrayList<Integer> upwardIDList = new ArrayList<Integer>();
		Employee temp = emp;
		
		/*
		 * Using temp employee, look at each manager until you get to the top.
		 * Add each id to the array.
		 */
		while (temp.getBossID() > -1) {
			upwardIDList.add(temp.getId());
			temp = temp.getManager();
		}
		upwardIDList.add(temp.getId());
		
		/*
		 * We use an arraylist for variable size, then convert back to normal array.
		 */
		int len = upwardIDList.size();
		Integer[] upwardIDs = new Integer[len];
		for (int i=0; i<len; i++) {
			upwardIDs[i] = upwardIDList.get(i);
		}
		
		return upwardIDs;
	}
}
