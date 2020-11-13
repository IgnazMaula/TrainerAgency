import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TrainerAddDialog extends JDialog 
implements ActionListener{
	//instance variable
	private JLabel name, baseSalary, rateAllowance;
	private JTextField nameTF, baseSalaryTF, 
	rateAllowanceTF;
	private JButton okButton, cancelButton;
	private JRadioButton fullTimeRB, contractRB;

	private Trainer trainer;

	//custom font
	final Font calibri14 = new Font("Calibri", Font.PLAIN, 14);

	//constructor
	public TrainerAddDialog(JFrame parent) {
		super(parent, true);
		trainer = null;
			
		setTitle("Add New Trainer");
		setSize(400, 300);
		setLocation(500,300);

		//create label
		name = new JLabel("Name  ");
		name.setFont(calibri14);
		baseSalary = new JLabel("Base Salary (RM)   ");
		baseSalary.setFont(calibri14);
		rateAllowance = new JLabel("Rate (1-5%)");
		rateAllowance.setFont(calibri14);

		//create text field
		nameTF = new JTextField(15);
		baseSalaryTF = new JTextField(15);
		rateAllowanceTF = new JTextField(15);

		//create button and raido button
		okButton = new JButton("OK");
		okButton.setFont(calibri14);
		okButton.setBackground(Color.WHITE);
		cancelButton = new JButton("Cancel");
		cancelButton.setFont(calibri14);
		cancelButton.setBackground(Color.WHITE);
		fullTimeRB = new JRadioButton("Full Time");
		fullTimeRB.setFont(calibri14);
		contractRB = new JRadioButton("Contract");
		contractRB.setFont(calibri14);
		fullTimeRB.setSelected(true);

		//create button group
		ButtonGroup rb = new ButtonGroup();
		rb.add(fullTimeRB);
		rb.add(contractRB);

		//add component to panel
		JPanel panel1 = new JPanel(new GridLayout(0,1,0,6));
		panel1.add(name);
		panel1.add(baseSalary);
		panel1.add(rateAllowance);

		JPanel panel2 = new JPanel(new GridLayout(0,1,0,4));
		panel2.add(nameTF);
		panel2.add(baseSalaryTF);
		panel2.add(rateAllowanceTF);

		JPanel panel3 = new JPanel();
		panel3.add(panel1);
		panel3.add(panel2);

		JPanel panel4 = new JPanel();
		panel4.add(fullTimeRB);
		panel4.add(contractRB);

		JPanel panel5 = new JPanel();
		panel5.add(okButton);
		panel5.add(cancelButton);

		getContentPane().add(panel3, "Center");
		getContentPane().add(panel4, "North");
		getContentPane().add(panel5, "South");

		//add action listener
		okButton.addActionListener(this);
		cancelButton.addActionListener(this);
		fullTimeRB.addActionListener(this);
		contractRB.addActionListener(this);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == okButton) {
			//get all information from the textfield
			String name = nameTF.getText().trim();
			String baseSalarySTR = baseSalaryTF.getText().trim();
			String rateAllowanceSTR = rateAllowanceTF.getText().trim();

			if(name.equals("") || baseSalarySTR.equals("") 
				|| rateAllowanceSTR.equals("")) {
				JOptionPane.showMessageDialog
				(this, "[Error] Please fill all field", 
				"Error Message", JOptionPane.ERROR_MESSAGE);
				return ;
			}

			//parse the double and integer
			double baseSalary = 0;
			try {
			baseSalary = Double.parseDouble(baseSalarySTR);
			}
			catch(NumberFormatException nfe) {
				if (e.getSource() == fullTimeRB)

					JOptionPane.showMessageDialog
					(this, "[Error] Base Salary/Rate given is invalid", 
					"Error Message", JOptionPane.ERROR_MESSAGE);
				else
					JOptionPane.showMessageDialog
					(this, "[Error] Base Salary/Allowance given is invalid", 
					"Error Message", JOptionPane.ERROR_MESSAGE);
				return ;
			}
			double rateAllowance = 0;
			try {
			rateAllowance = Double.parseDouble(rateAllowanceSTR);
			}
			catch(NumberFormatException nfe) {
				if (fullTimeRB.isSelected())
					JOptionPane.showMessageDialog
					(this, "[Error] Base Salary/Rate given is invalid", 
					"Error Message", JOptionPane.ERROR_MESSAGE);
				else
					JOptionPane.showMessageDialog
					(this, "[Error] Base Salary/Allowance given is invalid", 
					"Error Message", JOptionPane.ERROR_MESSAGE);
				return ;
			}
			if (baseSalary < 0) {
				JOptionPane.showMessageDialog
				(this, "[Error] Plese input positif number for base salary", 
				"Error Message", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (fullTimeRB.isSelected() 
				&& (rateAllowance < 1 || rateAllowance > 5)) {
				JOptionPane.showMessageDialog
				(this, "[Error] Plese input rate between 1-5", 
				"Error Message", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (contractRB.isSelected() 
				&& (rateAllowance != 25 && rateAllowance != 50)) {
				JOptionPane.showMessageDialog
				(this, "[Error] Plese input allowance between 25/50", 
				"Error Message", JOptionPane.ERROR_MESSAGE);
				return;
			}

			//create FullTime if fullTimeRB selected
			if(fullTimeRB.isSelected()) {
				trainer = new FullTime(name, baseSalary, 
				rateAllowance);
			}
			//create Contract if contractRB selected
			else {
				trainer = new Contract(name, baseSalary, 
				rateAllowance);
			}
			setVisible(false);
		}
		else if(e.getSource() == cancelButton) {
			trainer = null;
			setVisible(false);
		}
		else if (e.getSource() == fullTimeRB) {
            rateAllowance.setText("Rate (1-5%)");
        }
        //set the rate to 1 and unchangeable
        else if (e.getSource() == contractRB) {
             rateAllowance.setText("Allowance (25/50)");
        }	
	}
	public Trainer getTrainer() {
		return trainer;
	}
}