package charttraversal;

import java.util.ArrayList;

public class Employee {
	private Employee manager;
	private String name;
	private ArrayList<Employee> subordinates;
	
	public Employee getManager() {
		return manager;
	}
	public void setManager(Employee manager) {
		this.manager = manager;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Employee> getSubordinates() {
		return subordinates;
	}
	public void setSubordinates(ArrayList<Employee> subordinates) {
		this.subordinates = subordinates;
	}
	
	public Employee(Employee manager, String name, ArrayList<Employee> subordinates) {
		this.manager = manager;
		this.name = name;
		this.subordinates = subordinates;
	}
	
	
}
