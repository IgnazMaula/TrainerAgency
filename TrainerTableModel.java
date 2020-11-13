import java.util.*;
import javax.swing.table.*;

public class TrainerTableModel extends AbstractTableModel {

	//create header for the table
	private static final String[] tableHeader = 
	{"Trainer ID", "Trainer Category", "Trainer Name", "Course Taught",
	"Base Salary" , "Commission" ,"Monthly Salary"};
	private ArrayList<Trainer> trainerArray;

	public TrainerTableModel() {
		setTrainer(new ArrayList<Trainer>());
	}
	//set the trainer ArrayList that want to show on the table
	public TrainerTableModel(ArrayList<Trainer> trainerArray) {
		setTrainer(trainerArray);
	}
	//get the amount of the row
	public int getRowCount() {
		return getTrainer().size();
	}
	//get the amount of the column
	public int getColumnCount() {
		return tableHeader.length;
	}
	//get the information of the object in each
	//row of the table
	public Object getValueAt(int row, int column) {
		Trainer trainer = (Trainer) getTrainer().get(row);
		switch (column) {
			case 0:
				return trainer.getID();
			case 1:
				return trainer.getCategory();
			case 2:
				return trainer.getName();
			case 3:
				return trainer.getCourseTaught();
			case 4:
				return trainer.getBaseSalary();
			case 5:
				return trainer.commission();
			case 6:
				return trainer.monthlySalary();
			default:
				return "";
		}
	}
	//get the name of the selected column
	public String getColumnName(int column) {
		return tableHeader[column];
	}
	//add trainer to the row
	public void addRow(Trainer trainer) {
		int row = getTrainer().size();
		getTrainer().add(trainer);
		fireTableRowsInserted(row, row);
	}
	//get element at the selected row
	public Trainer getElementAt(int row) {
		Trainer trainer = (Trainer) getTrainer().get(row);
		return trainer;
	}
	//remove element at the selected row
	public Trainer removeRow(int row) {
		Trainer trainer = (Trainer) getTrainer().remove(row);
		fireTableRowsDeleted(row, row);
		return trainer;
	}
	//clear the data of the selected row
	public void clear() {
		int row = getTrainer().size() -1;
		getTrainer().clear();
		if(row >=0)
			fireTableRowsDeleted(0, row);
	}
	//check if selected trainer is contains in the
	//trainer ArrayList
	public boolean contains(Trainer trainer) {
		return getTrainer().contains(trainer);
	}
	//check if trainer ArrayList is empty
	public boolean isEmpty() {
		return getTrainer().size() == 0;
	}
	//set the ArrayList of trainer that want to be display
	//in the table
	public void setTrainer(ArrayList<Trainer> array) {
		trainerArray = array;
		this.fireTableDataChanged();
	}
	//get the ArrayList of trainer
	public ArrayList<Trainer> getTrainer() {
		return trainerArray;
	}

}