package charttraversal;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {
	private String file;
	private String employee1;
	private String employee2;
	private String shortestPath;

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getEmployee1() {
		return employee1;
	}

	public void setEmployee1(String employee1) {
		this.employee1 = employee1;
	}

	public String getEmployee2() {
		return employee2;
	}

	public void setEmployee2(String employee2) {
		this.employee2 = employee2;
	}
	
	public String getShortestPath() {
		return shortestPath;
	}

	public void setShortestPath(String shortestPath) {
		this.shortestPath = shortestPath;
	}

	public InputHandler(String filename, String emp1, String emp2) {
		this.file = filename;
		this.employee1 = emp1;
		this.employee2 = emp2;
		run(this);
	}


	public static void main(String[] args) {
		// NOTE: This makes the assumption that 3 arguments will be passed in 
		// when invoking the program. It also makes the assumption that 
		// the arguments will be of format [filename, employee, employee]
		String filename = args[0];
		String emp1 = args[1];
		String emp2 = args[2];
		
		InputHandler input = new InputHandler(filename, emp1, emp2);
		System.out.println(input.shortestPath);
		
	}
	
	private void run(InputHandler input) {
		ArrayList<Employee> company = input.constructOrganisation(input.file);
		PathCalculator pCalc = new PathCalculator();
		shortestPath = pCalc.calculate(company, input.employee1, input.employee2);
	}
	
	private ArrayList<Employee> constructOrganisation(String filename) {
		/*
		 * The file reader makes the assumption that the input file is in the working directory for the program.
		 */
		ArrayList<EmployeeDetail> employeeDetails = FileReader.read(file);
		ArrayList<Employee> employees = new ArrayList<>();
		
		/*
		 * For now, just add all of the employee to the list with their names and ID's.
		 */
		for (EmployeeDetail empDet : employeeDetails) {
			//Start off with a null employee
			Employee newEmployee = new Employee(null, 0, 0);
			
			//Give the employee their independent qualities
			newEmployee.setId(empDet.getId());
			newEmployee.setName(empDet.getName());
			newEmployee.setBossID(empDet.getBoss());
			
			//Add the employee to the company (list)
			employees.add(newEmployee);
		}
		
		for (Employee emp : employees) {
			System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getBossID() + " party");
		}
		
		BuildHierarchy hierarchy = new BuildHierarchy();
		ArrayList<Employee> company = hierarchy.build(employees);
		System.out.println(company.get(2).getName());
				
		return company;
		
		
//		for (int i=0; i<employeeDetails.size(); i++) {
//			System.out.println(employeeDetails.get(i).getId() + " " + employeeDetails.get(i).getName() + " " + employeeDetails.get(i).getBoss());
//		}
		
	}
	
	
	//Need to read the standard input args correctly				-- CHECK
	//Need to find and read file correctly 							-- CHECK
	//Need to store the input from the file appropriately			-- CHECK
	//Need to find the shortest route from one employee to another

}