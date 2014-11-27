package charttraversal;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
	public static List<EmployeeDetail> read (String filename) {
		String line = "";
		List<EmployeeDetail> empList = new ArrayList<>();
		
		
		try {
			FileInputStream inStream = new FileInputStream(filename);
			BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));
			
			
			/*
			 * Just ignore headings for now.
			 * They could be checked to see if they correspond with the 
			 * expected format, but it's assumed for now that that
			 * isn't necessary.
			 */
			String headings = reader.readLine();
			System.out.println(headings + " are headings");
			
			while ((line = reader.readLine()) != null) {
				/*
				 * Explode each line using the "|" separator as delimiter.
				 * Remember that there is one before and one after each line of input
				 * So those should be accounted for (ignored) when collecting the input.
				 */
				String[] resultLine = line.split("\\|");
								
				/*
				 * Store the 3 desired inputs as the employee ID, 
				 * employee name, and ID of their direct boss.
				 */
				
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
				 * Add the employee (and details) to the list.
				 */
				EmployeeDetail emp = new EmployeeDetail(empID, name, bossID);
				empList.add(emp);
			}
			
			reader.close();
			
		}  catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return empList;
		
		
	}
	
}
