package charttraversal;


import java.util.HashMap;

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
		/*
		 * Handle funny spacing in the input
		 * (more than one space is replaced by one space).
		 */
		this.employee1 = emp1.trim().replaceAll("( )+", " ");
		this.employee2 = emp2.trim().replaceAll("( )+", " ");
		run(this);
	}


	public static void main(String[] args) {
		/*
		 *  NOTE: This makes the assumption that 3 arguments will be passed in 
		 *  when invoking the program. It also makes the assumption that 
		 *  the arguments will be of format [filename, employee, employee]
		 */
		String filename = args[0];
		String emp1 = args[1];
		String emp2 = args[2];
		
		InputHandler input = new InputHandler(filename, emp1, emp2);
		System.out.println(input.shortestPath);
		
	}
	
	private void run(InputHandler input) {
		HashMap<Integer, Employee> company = input.constructOrganisation(input.file);
		PathCalculator pCalc = new PathCalculator();
		this.shortestPath = pCalc.calculate(company, input.employee1, input.employee2);
	}
	
	private HashMap<Integer, Employee> constructOrganisation(String filename) {
		/*
		 * The file reader makes the assumption that the input file is in the working directory for the program.
		 */
		HashMap<Integer, Employee> employees = FileReader.read(file);
		
		/*
		 * Call the hierarchy builder to add employees managers and subordinates in
		 * (hence creating the company structure)
		 */
		BuildHierarchy hierarchy = new BuildHierarchy();		
		HashMap<Integer, Employee> company = hierarchy.build(employees);
				
		return company;
		
		
	}

}