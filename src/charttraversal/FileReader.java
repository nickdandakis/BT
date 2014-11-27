package charttraversal;
import java.io.*;

public class FileReader {
	public static Organisation read (String filename) {
		String line = "";
		List<EmployeeDetail> empList = new ArrayList<>();
		
		
		try {
			FileInputStream inStream = new FileInputStream(filename);
			BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));
			
			boolean headings = true;
			
			while ((line = br.readLine()) != null) {
				String[] resultLine = line.split("|");
				
				if (headings) {
					
					headings = false;
				} else {
					EmployeeDetail emp = new EmployeeDetail(resultLine[0], resultLine[1], resultLine[2]);
					empList.add(emp);
				}
				
				
			}
		}  catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	public static List<Result> read (File CSV) {
		String line = "";
		List<Result> resultList = new ArrayList<>();
		
		try {
			BufferedReader br = new BufferedReader(new java.io.FileReader(CSV));
			while ((line = br.readLine()) != null) {
	 
			    //Explode result to component parts
				String[] resultLine = line.split(",");
				//Store the result as a result object
				Result result = new Result(resultLine[0], resultLine[1], resultLine[2], resultLine[3]);
				
				//Store the result object in the result list
				resultList.add(result);
				
				//Send resultList to the tableBuilder
			}
			
			br.close();
	 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return resultList;
	}
}
