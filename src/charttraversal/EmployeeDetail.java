package charttraversal;

public class EmployeeDetail {
	private int id;
	private String name;
	private int boss;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBoss() {
		return boss;
	}

	public void setBoss(int boss) {
		this.boss = boss;
	}



	public EmployeeDetail(int id, String name, int boss) {
		this.id = id;
		this.name = name;
		this.boss = boss;
	}
	
	
}
