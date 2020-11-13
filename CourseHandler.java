import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class CourseHandler implements ActionListener{

	//instance variable
	TrainingAgencyGUI agencyGUI;
	CourseTableModel courseTM;

	//constructor
	public CourseHandler(TrainingAgencyGUI agencyGUI) {
		this.agencyGUI = agencyGUI;
		courseTM = agencyGUI.getCourseTableModel();
	}

	public void actionPerformed(ActionEvent e) {
		//add course
		if(e.getSource() == agencyGUI.addCourse) {	
			//call CourseAddDialog to create Passenger
			CourseAddDialog addCourseDialog = 
			new CourseAddDialog(agencyGUI);
			addCourseDialog.pack();
			addCourseDialog.setLocationRelativeTo(agencyGUI);
			addCourseDialog.setVisible(true);
			//add course to table
			Course course = addCourseDialog.getCourse();
			if(course != null) {
				courseTM.addRow(course);
			}
		}
	}

}