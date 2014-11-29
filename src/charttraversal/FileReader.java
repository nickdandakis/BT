package charttraversal;
import java.io.*;
import java.util.HashMap;

public class FileReader {
	public static HashMap<Integer, Employee> read (String filename) {
		String line = "";
		HashMap<Integer, Employee> employees = new HashMap<Integer, Employee>();
		
		
		try {
			/*
			 * The file reader makes the assumption that the input file is in the working directory for the program.
			 */
			FileInputStream inStream = new FileInputStream(filename);
			BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));
			
			
			/*
			 * Just ignore headings for now.
			 * They could be checked to see if they correspond with the 
			 * expected format, but it's assumed for now that that
			 * isn't necessary.
			 */
			String headings = reader.readLine();
			
			while ((line = reader.readLine()) != null) {
				/*
				 * Explode each line using the "|" separator as delimiter.
				 * Remember that there is one before and one after each line of input
				 * So those should be accounted for (ignored) when collecting the input.
				 */
				String[] resultLine = line.split("\\|");
				
				/*
				 * Check if array is empty (if you have picked up a blank line where employee was removed)
				 */
				boolean empty = true;
				for (String s : resultLine) {
					if (!(s.trim().isEmpty())) {
						empty = false;
					}
				}
				
				/*
				 * Store the 3 desired inputs as the employee ID, 
				 * employee name, and ID of their direct boss.
				 */
				if (!empty) {
					int empID = Integer.parseInt(resultLine[1].trim());
					String name = resultLine[2].trim();
					
					/*
					 * If the employee has no boss, the bossID will be stored as -1.
					 * bossID = -1 indicates top level manager.
					 */
					int bossID = -1;
					if (!(resultLine[3].trim().isEmpty())) {
						bossID = Integer.parseInt(resultLine[3].trim());
					} 
					
					/*
					 * Add the employee (and details) to the employees hashmap.
					 */
					Employee emp = new Employee(name, empID, bossID);
					employees.put(empID, emp);
				}
								
			}
			
			reader.close();
			
		}  catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return employees;
		
		
	}
	
}
