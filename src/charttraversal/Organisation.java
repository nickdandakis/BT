package charttraversal;

public class Organisation {
	private Employee manager;
	
	public Organisation(Employee managerData, Boolean companyHead) {
		this.manager = new Employee(managerData.getName(), managerData.getId(), managerData.getBossID());
	}
	
}
