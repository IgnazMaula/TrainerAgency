import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class TrainerHandler implements 
ActionListener, ItemListener{

	//instance variable
	TrainingAgencyGUI agencyGUI;
	TrainerTableModel trainerTM;

	//constructor
	public TrainerHandler(TrainingAgencyGUI agencyGUI) {
		this.agencyGUI = agencyGUI;
		trainerTM = agencyGUI.getTrainerTableModel();
	}

	public void itemStateChanged(ItemEvent e) {
		//sort trainer by name
		if(e.getSource() == agencyGUI.trainerCB) {
			if(agencyGUI.trainerCB.getSelectedItem() == "Default") {
				agencyGUI.getTrainingAgency().trainerDefault();
				agencyGUI.getTrainerTableModel().fireTableDataChanged();
			}
			//soret passenger by booking ref
			else if(agencyGUI.trainerCB.getSelectedItem() == "Name") {
				agencyGUI.getTrainingAgency().trainerByName();
				agencyGUI.getTrainerTableModel().fireTableDataChanged();
			}
			else {
				agencyGUI.getTrainingAgency().trainerByCourseTaught();
				agencyGUI.getTrainerTableModel().fireTableDataChanged();
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		//add trainer
		if(e.getSource() == agencyGUI.addTrainer) {	
			//call TrainerrAddDialog to create Passenger
			TrainerAddDialog addTrainerDialog = 
			new TrainerAddDialog(agencyGUI);
			addTrainerDialog.pack();
			addTrainerDialog.setLocationRelativeTo(agencyGUI);
			addTrainerDialog.setVisible(true);
			//add trainer to table
			Trainer trainer = addTrainerDialog.getTrainer();
			if(trainer != null) {
				trainerTM.addRow(trainer);
			}
		}
		//delete trainer
		else if(e.getSource() == agencyGUI.deleteTrainer) {
			if(agencyGUI.trainerTable.getRowCount() == 0) {
				JOptionPane.showMessageDialog
				(agencyGUI, "No trainer in the table!");
			}
			else {
				int rowIndex = agencyGUI.trainerTable.getSelectedRow();
				if(rowIndex!= -1) {
					//search passenger to be delete
					Trainer trainer = 
					trainerTM.getElementAt(rowIndex);
					//delete confirmation
					int confirm = JOptionPane.showConfirmDialog
					(agencyGUI, 
					"Are you sure you want to delete this trainer?", 
					"Confirm Delete", JOptionPane.OK_CANCEL_OPTION);
					if (confirm == JOptionPane.YES_OPTION) {
						//delete Passenger
						trainerTM.removeRow(rowIndex);
						JOptionPane.showMessageDialog(agencyGUI, 
						"Trainer successfully deleted!");
					}
				}
				else {
					JOptionPane.showMessageDialog
					(agencyGUI, "Please select a row of trainer "+
					"that want to be delete!");
				} 
			}
		}
	}

}