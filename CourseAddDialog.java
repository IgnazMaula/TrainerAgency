import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CourseAddDialog extends JDialog 
implements ActionListener{
	//instance variable
	private JLabel name, level, cost, 
	noOfDay,seatBooked;
	private JTextField nameTF, levelTF, costTF,
	noOfDayTF, seatBookedTF;
	private JButton okButton, cancelButton;

	private Course course;

	//custom font
	final Font calibri14 = new Font("Calibri", Font.PLAIN, 14);

	//constructor
	public CourseAddDialog(JFrame parent) {
		super(parent, true);
		course = null;
			
		setTitle("Add New Course");
		setSize(400, 300);
		setLocation(500,300);

		//create label
		name = new JLabel("Name  ");
		name.setFont(calibri14);
		level = new JLabel("Level (1-3)  ");
		level.setFont(calibri14);
		cost = new JLabel("Cost (RM)   ");
		cost.setFont(calibri14);
		noOfDay = new JLabel("No of Day");
		noOfDay.setFont(calibri14);
		seatBooked = new JLabel("Seat Booked");
		seatBooked.setFont(calibri14);


		//create text field
		nameTF = new JTextField(15);
		levelTF = new JTextField(15);
		costTF = new JTextField(15);
		noOfDayTF = new JTextField(15);
		seatBookedTF = new JTextField(15);

		//create button and raido button
		okButton = new JButton("OK");
		okButton.setFont(calibri14);
		okButton.setBackground(Color.WHITE);
		cancelButton = new JButton("Cancel");
		cancelButton.setFont(calibri14);
		cancelButton.setBackground(Color.WHITE);

		//add component to panel
		JPanel panel1 = new JPanel(new GridLayout(0,1,0,6));
		panel1.add(name);
		panel1.add(level);
		panel1.add(cost);
		panel1.add(noOfDay);
		panel1.add(seatBooked);

		JPanel panel2 = new JPanel(new GridLayout(0,1,0,4));
		panel2.add(nameTF);
		panel2.add(levelTF);
		panel2.add(costTF);
		panel2.add(noOfDayTF);
		panel2.add(seatBookedTF);

		JPanel panel3 = new JPanel();
		panel3.add(panel1);
		panel3.add(panel2);

		JPanel panel5 = new JPanel();
		panel5.add(okButton);
		panel5.add(cancelButton);

		getContentPane().add(panel3, "Center");
		getContentPane().add(panel5, "South");

		//add action listener
		okButton.addActionListener(this);
		cancelButton.addActionListener(this);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == okButton) {
			//get all information from the textfield
			String name = nameTF.getText().trim();
			String levelSTR = levelTF.getText().trim();
			String costSTR = costTF.getText().trim();
			String noOfDaySTR = noOfDayTF.getText().trim();
			String seatBookedSTR = seatBookedTF.getText().trim();

			if(name.equals("") || levelSTR.equals("") 
			|| costSTR.equals("") || noOfDaySTR.equals("")
			|| seatBookedSTR.equals("")) {
				JOptionPane.showMessageDialog
				(this, "[Error] Please fill all field", 
				"Error Message", JOptionPane.ERROR_MESSAGE);
				return ;
			}

			//parse the double and integer
			int level = 0;
			try {
			level = Integer.parseInt(levelSTR);
			}
			catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog
				(this, "[Error] Level/Cost/No Of Day/Seat "+
					"Booked given is invalid", 
				"Error Message", JOptionPane.ERROR_MESSAGE);
				return ;
			}
			double cost = 0;
			try {
			cost = Double.parseDouble(costSTR);
			}
			catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog
				(this, "[Error] Level/Cost/No Of Day/Seat "+
					"Booked given is invalid", 
				"Error Message", JOptionPane.ERROR_MESSAGE);
				return ;
			}
			int noOfDay = 0;
			try {
			noOfDay = Integer.parseInt(noOfDaySTR);
			}
			catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog
				(this, "[Error] Level/Cost/No Of Day/Seat "+
					"Booked given is invalid", 
				"Error Message", JOptionPane.ERROR_MESSAGE);
				return ;
			}
			int seatBooked = 0;
			try {
			seatBooked = Integer.parseInt(seatBookedSTR);
			}
			catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog
				(this, "[Error] Level/Cost/No Of Day/Seat "+
					"Booked given is invalid", 
				"Error Message", JOptionPane.ERROR_MESSAGE);
				return ;
			}

			if (level < 0 || cost < 0 || noOfDay < 0 || seatBooked < 0) {
				JOptionPane.showMessageDialog
				(this, "[Error] Plese input positif number "+
					"for Level/Cost/No Of Day/Seat Booked", 
				"Error Message", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (level < 1 || level > 3) {
				JOptionPane.showMessageDialog
				(this, "[Error] Plese input level between 1-3", 
				"Error Message", JOptionPane.ERROR_MESSAGE);
				return;
			}
			//create course
			course = new Course(name, level, cost, noOfDay, seatBooked, 0);
			setVisible(false);
		}
		else if(e.getSource() == cancelButton) {
			course = null;
			setVisible(false);
		}
	}
	public Course getCourse() {
		return course;
	}
}