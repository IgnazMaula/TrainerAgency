import java.util.ArrayList;
import java.io.Serializable;

public abstract class Trainer implements Comparable<Trainer>, Serializable {

	private int idNumber;
	private String name;
	private double baseSalary;
	private ArrayList<Course> courseArray =
	new ArrayList<Course>();

	private static int nextID = 0;

	public Trainer(String name, double baseSalary) {
		idNumber = ++nextID;
		this.name = name;
		this.baseSalary = baseSalary;
	}

	public int compareTo(Trainer obj) {
		if (this == obj)
			return 0;
		if (this.equals(obj))
			return 0;
		return getCategory().compareTo(obj.getCategory());
				
	}

	public int getID() {
		return idNumber;
	}
	public String getName() {
		return name;
	}
	public double getBaseSalary() {
		return baseSalary;
	}
	public int getCourseTaught() {
		return courseArray.size();
	}
	public ArrayList<Course> getCourseArray() {
		return courseArray;
	}
	public void setID(int idNumber) {
		this.idNumber = idNumber;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	public double monthlySalary() {
		return baseSalary + commission();
	}
	public abstract double commission();
	public abstract String getCategory();
	public abstract void assign(Course course);

}