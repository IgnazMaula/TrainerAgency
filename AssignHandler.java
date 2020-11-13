import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class AssignHandler implements ActionListener {
	//instance variable
	TrainingAgencyGUI agencyGUI;
	TrainerTableModel trainerTM;
	CourseTableModel courseTM;

	//constructor
	public AssignHandler(TrainingAgencyGUI agencyGUI ) {
		this.agencyGUI = agencyGUI;
		trainerTM = agencyGUI.getTrainerTableModel();
	}
	//handle actionperformed
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == agencyGUI.searchCourse) {
			//search course based on code
			String code = 
			agencyGUI.searchTrainerTF.getText();
			Course courseToAssign = null;
			for( Course i : agencyGUI.getTrainingAgency().
				getCourseArray()) {
				if(i.getCode().equals(code))
					courseToAssign = i;
			}
			//if course not found
			if(courseToAssign == null) {
				JOptionPane.showMessageDialog(agencyGUI, 
				"Course that you search not available on the list!");
				agencyGUI.searchTrainerTF.setText("");
			}
			else {
				//call AssignDialog
				AssignDialog assignDialog = 
				new AssignDialog(agencyGUI, 
				courseToAssign, agencyGUI.getTrainingAgency());
				agencyGUI.searchTrainerTF.setText("");
				assignDialog.pack();
	            assignDialog.setLocationRelativeTo(agencyGUI);
	            assignDialog.setVisible(true);
			}
		}
		
	}
}