package charttraversal;

public class InputHandler {
	private String file;
	private String employee1;
	private String employee2;
	private Organisation company;

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
	
	public InputHandler(String filename, String emp1, String emp2) {
		this.file = filename;
		this.employee1 = emp1;
		this.employee2 = emp2;
		constructOrganisation(this.file);
	}


	public static void main(String[] args) {
		// NOTE: This makes the assumption that 3 arguments will be passed in 
		// when invoking the program. It also makes the assumption that 
		// the arguments will be of format [filename, employee, employee]
		String filename = args[0];
		String emp1 = args[1];
		String emp2 = args[2];
		
		InputHandler input = new InputHandler(filename, emp1, emp2);
		
	}
	
	private void constructOrganisation(String filename) {
		
		this.company = new Organisation()
	}
	
	
	//Need to read the standard input args correctly  -- CHECK
	//Need to find and read file correctly
	//Need to store the input from the file appropriately
	//Need to find the shortest route from one employee to another

}