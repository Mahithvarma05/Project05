package pojoClass;

public class Pojo {
	private int id;
	private String name;
	private double salary;
	private String type;
	public Pojo() {
		
	}
	public Pojo(int id, String name, double salary, String type) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.type = type;
		
	}
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "pojo [id=" + id + ", name=" + name + ", salary=" + salary + ", type=" + type + "]";
	}
	

}


