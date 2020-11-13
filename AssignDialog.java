import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AssignDialog 
extends JDialog implements ActionListener{
	//instance variable
	private JLabel code, name, idNumber;
	private JTextField codeTF, nameTF, idNumberTF;
	private JButton okButton, cancelButton;

	private TrainingAgency agency;
	private Course course;

	//costum font
	final Font calibri14 = new Font("Calibri", Font.PLAIN, 14);

	//constructor
	public AssignDialog(JFrame parent, 
	Course course, TrainingAgency agency) {
		super(parent, true);
		this.agency = agency;
		this.course = course;
		
		setTitle("Assign Trainer");
		setSize(300, 150);
		setLocation(500,300);

		//create label
		code = new JLabel("Course Code   ");
		code.setFont(calibri14);
		name = new JLabel("Course Name  ");
		name.setFont(calibri14);
		idNumber = new JLabel("Enter Trainer ID to assign ");
		idNumber.setFont(calibri14);

		//create text field
		codeTF = new JTextField(15); 
		codeTF.setText(course.getCode());
		codeTF.setEditable(false);
		nameTF = new JTextField(15);
		nameTF.setText(course.getName());
		nameTF.setEditable(false);
		idNumberTF = new JTextField(15);

		//create button
		okButton = new JButton("OK");
		okButton.setFont(calibri14);
		okButton.setBackground(Color.WHITE);
		cancelButton = new JButton("Cancel");
		cancelButton.setFont(calibri14);
		cancelButton.setBackground(Color.WHITE);

		//add component to panel
		JPanel panel1 = new JPanel(new GridLayout(0,1,0,8));
		panel1.add(code);
		panel1.add(name);
		panel1.add(idNumber);

		JPanel panel2 = new JPanel(new GridLayout(0,1,0,4));
		panel2.add(codeTF);
		panel2.add(nameTF);
		panel2.add(idNumberTF);

		JPanel panel3 = new JPanel();
		panel3.add(panel1);
		panel3.add(panel2);

		JPanel panel4 = new JPanel();
		panel4.add(okButton);
		panel4.add(cancelButton);

		getContentPane().add(panel3, "North");
		getContentPane().add(panel4, "Center");

		//add action listener
		okButton.addActionListener(this);
		cancelButton.addActionListener(this);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == okButton) {
			String idNumberSTR = idNumberTF.getText().trim();
			int idNumber = Integer.parseInt(idNumberSTR);

			//search selected trainer
			Trainer selectedTrainer = null;
			for (Trainer i : agency.getTrainerArray()) {
				if(i.getID() == idNumber)
					selectedTrainer = i;
			}
			if(selectedTrainer != null) {
				
				if(course.getTrainerIdNumber() != 0) {
					if(course.getTrainerIdNumber() == idNumber) {
						JOptionPane.showMessageDialog(this,
						"This course have been assigned to this trainer");
					}
					else {
						//give option to keep or remove trainer
						//if the trainer date is conflict
						Object[] options = 
						{"Keep Previous Trainer", 
						"Replace Previous Trainer", "Cancel"};
						int n = JOptionPane.showOptionDialog
						(this, "This course already have a trainer"+
					    ", would you like to", "Assign Trainer Option", 
					    JOptionPane.YES_NO_CANCEL_OPTION, 
					    JOptionPane.QUESTION_MESSAGE,
					    null,options, options[2]);
					    //keep previous trainer
					    if (n == 0) {
					    	JOptionPane.showMessageDialog
					    	(this, "Previous trainer has been keeped,"+
					    	" no change is made");
					    }
					    //replace previous trainer
					    else if (n == 1) {
							for(Trainer i : agency.getTrainerArray()) {
								if(course.getTrainerIdNumber() == i.getID())
									i.getCourseArray().remove(course);
							}
							selectedTrainer.getCourseArray().add(course);
							selectedTrainer.assign(course);
					    	JOptionPane.showMessageDialog
					    	(this, "Previous trainer replaced "+
					    	"with selected trainer!");
					    }
					    else {
					    }
					}
				}
				else {
					//assign selected trainer
					selectedTrainer.getCourseArray().add(course);
					selectedTrainer.assign(course);
					JOptionPane.showMessageDialog(this, 
					"Successfully add a trainer!");
				}
			}
			else {
				JOptionPane.showMessageDialog(this, 
				"Trainer that you tried to assign not available!");
			}
		setVisible(false);
		}
	}	
}
