import java.util.*;
import javax.swing.table.*;

public class CourseTableModel extends AbstractTableModel {

	//create header for the table
	private static final String[] tableHeader = 
	{"Course Name", "Level", "Code", "Cost",
	"No of Day" , "Seat Booked" ,"Trainer ID"};
	private ArrayList<Course> courseArray;

	public CourseTableModel() {
		setCourse(new ArrayList<Course>());
	}
	//set the course ArrayList that want to show on the table
	public CourseTableModel(ArrayList<Course> courseArray) {
		setCourse(courseArray);
	}
	//get the amount of the row
	public int getRowCount() {
		return getCourse().size();
	}
	//get the amount of the column
	public int getColumnCount() {
		return tableHeader.length;
	}
	//get the information of the object in each
	//row of the table
	public Object getValueAt(int row, int column) {
		Course course = (Course) getCourse().get(row);
		switch (column) {
			case 0:
				return course.getName();
			case 1:
				return course.getLevel();
			case 2:
				return course.getCode();
			case 3:
				return course.getCost();
			case 4:
				return course.getNoOfDay();
			case 5:
				return course.getSeatBooked();
			case 6:
				return course.getTrainerIdNumber();
			default:
				return "";
		}
	}
	//get the name of the selected column
	public String getColumnName(int column) {
		return tableHeader[column];
	}
	//add course to the row
	public void addRow(Course course) {
		int row = getCourse().size();
		getCourse().add(course);
		fireTableRowsInserted(row, row);
	}
	//get element at the selected row
	public Course getElementAt(int row) {
		Course course = (Course) getCourse().get(row);
		return course;
	}
	//remove element at the selected row
	public Course removeRow(int row) {
		Course course = (Course) getCourse().remove(row);
		fireTableRowsDeleted(row, row);
		return course;
	}
	//clear the data of the selected row
	public void clear() {
		int row = getCourse().size() -1;
		getCourse().clear();
		if(row >=0)
			fireTableRowsDeleted(0, row);
	}
	//check if selected course is contains in the
	//course ArrayList
	public boolean contains(Course course) {
		return getCourse().contains(course);
	}
	//check if course ArrayList is empty
	public boolean isEmpty() {
		return getCourse().size() == 0;
	}
	//set the ArrayList of course that want to be display
	//in the table
	public void setCourse(ArrayList<Course> array) {
		courseArray = array;
		this.fireTableDataChanged();
	}
	//get the ArrayList of course
	public ArrayList<Course> getCourse() {
		return courseArray;
	}

}