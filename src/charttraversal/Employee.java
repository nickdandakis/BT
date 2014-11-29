package charttraversal;

import java.util.HashMap;

public class Employee {
	private Employee manager;
	private String name;
	private int id;
	private HashMap<Integer, Employee> subordinates;
	private int bossID;
	
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public HashMap<Integer, Employee> getSubordinates() {
		return subordinates;
	}
	public void addSubordinate(Employee subordinate) {
		this.subordinates.put(subordinate.getId(), subordinate);
	}
	public int getBossID() {
		return bossID;
	}
	public void setBossID(int bossID) {
		this.bossID = bossID;
	}
	
	
	public Employee(String name, int id, int bossID) {
		this.name = name;
		this.id = id;
		this.bossID = bossID;
		this.subordinates = new HashMap<Integer, Employee>();
	}
	
	
}
