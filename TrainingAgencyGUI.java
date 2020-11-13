import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class TrainingAgencyGUI extends JFrame{

    private TrainingAgency agency;

    private TrainerTableModel trainerTM;
    private CourseTableModel courseTM;

    JMenuItem newItem, openItem, exitItem, saveItem, saveAsItem;
    JMenuBar menuBar;
    JTabbedPane tabbedPane;

    JTable trainerTable, trainerTableAssign;
    JTable courseTable, courseTableAssign;

    //Trainer Table
    JButton addTrainer, deleteTrainer;
    JLabel listUser;
    JComboBox trainerCB;

    //Course Table
    JButton addCourse;

    //Assign Trainer
    JButton searchCourse;
    JTextField searchTrainerTF;

    //costum fonts
    final Font calibri14 = new Font("Calibri", Font.PLAIN, 14);
    final Font calibri15 = new Font("Calibri", Font.BOLD, 15);
    final Font calibri16 = new Font("Calibri", Font.BOLD, 16);
    final Font calibri24 = new Font("Calibri", Font.BOLD, 24);

    //costum icon
    Icon ico1 = new ImageIcon("ico1.png");
    Icon ico2 = new ImageIcon("ico2.png");
    Icon ico3 = new ImageIcon("ico3.png");

    //constructor
    public TrainingAgencyGUI() {
        //create training agency
         agency = new TrainingAgency();
         setTitle(
        "Excellent IT Training Sdn Bhd Management");
        
        //set size of the main frame
        setSize(1000, 665);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //create a tab pane
        tabbedPane = new JTabbedPane();
        tabbedPane.setFont(calibri16);
        //create menu bar
        menuBar = new JMenuBar();
        setUpMenuBar();
        setJMenuBar(menuBar);

        //call the components of the tab
        setUpTrainerTab();
        setUpCourseTab();
        setUpAssignTrainer();

        //add tab pane to main frame
        getContentPane().add(tabbedPane);

    }

    public void setUpMenuBar() {
        //create JMenu
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        //create item of JMenu
        newItem = new JMenuItem("New");
        openItem = new JMenuItem("Open");
        exitItem = new JMenuItem("Exit");
        saveItem = new JMenuItem("Save");
        saveAsItem = new JMenuItem("Save As...");
        //add item to JMenu
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.addSeparator();
        fileMenu.add(saveItem);
        fileMenu.add(saveAsItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        
        //add action listener to the menu item
        FileHandler fileHandler = new FileHandler(this);
        newItem.addActionListener(fileHandler);
        openItem.addActionListener(fileHandler);
        saveItem.addActionListener(fileHandler);
        saveAsItem.addActionListener(fileHandler);
        exitItem.addActionListener(fileHandler);

    }
    public void setUpTrainerTab() {
        //create the panel for the tab
        JPanel trainerPanel = new JPanel(new BorderLayout());
        tabbedPane.addTab("  Trainer Manager", ico1 ,trainerPanel);

        //create trainer table with costume table model
        trainerTM =
        new TrainerTableModel(agency.getTrainerArray());
        trainerTable = new JTable(trainerTM);
        trainerTable.setSelectionMode
        (ListSelectionModel.SINGLE_SELECTION);
        //align table to center
        DefaultTableCellRenderer CENTERCELL 
        = new DefaultTableCellRenderer();
        CENTERCELL.setHorizontalAlignment(JLabel.CENTER);
        trainerTable.getColumnModel().
        getColumn(0).setCellRenderer(CENTERCELL);
        trainerTable.getColumnModel().
        getColumn(1).setCellRenderer(CENTERCELL);
        trainerTable.getColumnModel().
        getColumn(2).setCellRenderer(CENTERCELL);
        trainerTable.getColumnModel().
        getColumn(3).setCellRenderer(CENTERCELL);
        trainerTable.getColumnModel().
        getColumn(4).setCellRenderer(CENTERCELL);
        trainerTable.getColumnModel().
        getColumn(5).setCellRenderer(CENTERCELL);
        trainerTable.getColumnModel().
        getColumn(6).setCellRenderer(CENTERCELL);

        //create panel for the table
        JPanel displayPanel = new JPanel(new BorderLayout());
        displayPanel.setBackground(new Color(143, 235, 52));
        JLabel listTrainer = new JLabel("List of Trainer");
        listTrainer.setHorizontalAlignment(JLabel.CENTER);
        listTrainer.setFont(calibri15);
        listTrainer.setForeground(Color.WHITE);
        JScrollPane trainerSP = new JScrollPane(trainerTable);
        displayPanel.add(listTrainer, "North");
        displayPanel.add(trainerSP, "Center");

        //create button in this tab
        JPanel buttonPanel = new JPanel();
        addTrainer = new JButton("Add New Trainer");
        addTrainer.setFont(calibri14);
        addTrainer.setBackground(Color.WHITE);
        deleteTrainer = new JButton("Delete Trainer");
        deleteTrainer.setFont(calibri14);
        deleteTrainer.setBackground(Color.WHITE);
        trainerCB = new JComboBox();
        trainerCB.setFont(calibri14);
        trainerCB.setBackground(Color.WHITE);
        trainerCB.addItem("Default");
        trainerCB.addItem("Name");
        trainerCB.addItem("Num of Course taught");
        buttonPanel.add(addTrainer);
        buttonPanel.add(deleteTrainer);
        buttonPanel.add(trainerCB);

        //add table panel and button panel to main panel
        trainerPanel.add(displayPanel, "Center");
        trainerPanel.add(buttonPanel, "South");

        //add action listener to the item
        
        TrainerHandler trainerHandler = new TrainerHandler(this);
        addTrainer.addActionListener(trainerHandler);
        deleteTrainer.addActionListener(trainerHandler);
        trainerCB.addItemListener(trainerHandler);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void setUpCourseTab() {
        //create the panel for the tab
        JPanel coursePanel = new JPanel(new BorderLayout());
        tabbedPane.addTab("  Course Manager", ico2 ,coursePanel);

        //create trainer table with costume table model
        courseTM =
        new CourseTableModel(agency.getCourseArray());
        courseTable = new JTable(courseTM);
        courseTable.setSelectionMode
        (ListSelectionModel.SINGLE_SELECTION);
        //align table to center
        DefaultTableCellRenderer CENTERCELL = 
        new DefaultTableCellRenderer();
        CENTERCELL.setHorizontalAlignment(JLabel.CENTER);
        courseTable.getColumnModel().
        getColumn(0).setCellRenderer(CENTERCELL);
        courseTable.getColumnModel().
        getColumn(1).setCellRenderer(CENTERCELL);
        courseTable.getColumnModel().
        getColumn(2).setCellRenderer(CENTERCELL);
        courseTable.getColumnModel().
        getColumn(3).setCellRenderer(CENTERCELL);
        courseTable.getColumnModel().
        getColumn(4).setCellRenderer(CENTERCELL);
        courseTable.getColumnModel().
        getColumn(5).setCellRenderer(CENTERCELL);
        courseTable.getColumnModel().
        getColumn(6).setCellRenderer(CENTERCELL);

        //create panel for the table
        JPanel displayPanel = new JPanel(new BorderLayout());
        displayPanel.setBackground(new Color(222, 41, 13));
        JLabel listCourse = new JLabel("List of Course");
        listCourse.setHorizontalAlignment(JLabel.CENTER);
        listCourse.setFont(calibri15);
        listCourse.setForeground(Color.WHITE);
        JScrollPane courseSP = new JScrollPane(courseTable);
        displayPanel.add(listCourse, "North");
        displayPanel.add(courseSP, "Center");

        //create button in this tab
        JPanel buttonPanel = new JPanel();
        addCourse = new JButton("Add New Course");
        addCourse.setFont(calibri14);
        addCourse.setBackground(Color.WHITE);
        buttonPanel.add(addCourse);

        //add table panel and button panel to main panel
        coursePanel.add(displayPanel, "Center");
        coursePanel.add(buttonPanel, "South");

        //add action listener to the item
        CourseHandler courseHandler = new CourseHandler(this);
        addCourse.addActionListener(courseHandler);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void setUpAssignTrainer() {
        //create the panel for the tab
        JPanel display = new JPanel(new GridLayout(2,0,0,0));
        JPanel assignPanel = new JPanel(new GridLayout(2,3,0,0));
        assignPanel.setBackground(new Color(173, 227, 255));
        tabbedPane.addTab("  Assign Trainer to Course", ico3, display);

        //create the title of the tab
        JPanel titlePanel = new JPanel();
        JLabel assignText = new JLabel("Assign Trainer to Course");
        assignText.setHorizontalAlignment(JLabel.CENTER);
        assignText.setFont(calibri24);
        titlePanel.add(assignText);

        //create search bar and button for search trainer
        JPanel searchPanel = new JPanel();
        searchPanel.setBackground(new Color(173, 227, 255));
        JLabel searchText = new JLabel
        ("Enter the code of course to assign trainer");
        searchText.setFont(calibri14);
        searchTrainerTF = new JTextField(25);
        searchCourse = new JButton("Search");
        searchCourse.setFont(calibri16);
        searchCourse.setForeground(Color.WHITE);
        searchCourse.setBackground(new Color(17, 131, 237));
        searchPanel.add(searchText);
        searchPanel.add(searchTrainerTF);
        searchPanel.add(searchCourse);

        //put the title, search bar, and button into grid
        assignPanel.add(new JLabel(""));
        assignPanel.add(assignText);
        assignPanel.add(new JLabel(""));
        assignPanel.add(new JLabel(""));
        assignPanel.add(searchPanel);
        assignPanel.add(new JLabel(""));

        //create panel for trainer and course table
        JPanel tabelPanel = new JPanel(new GridLayout(2,0,0,0));

        //reshow the trainer table
        JPanel trainerTablePanel = new JPanel(new BorderLayout());
        trainerTablePanel.setBackground(new Color(143, 235, 52));
        trainerTableAssign = new JTable(trainerTM);
        trainerTableAssign.setSelectionMode
        (ListSelectionModel.SINGLE_SELECTION);
        //align table to center
        DefaultTableCellRenderer CENTERCELL = 
        new DefaultTableCellRenderer();
        CENTERCELL.setHorizontalAlignment(JLabel.CENTER);
        trainerTableAssign.getColumnModel().
        getColumn(0).setCellRenderer(CENTERCELL);
        trainerTableAssign.getColumnModel().
        getColumn(1).setCellRenderer(CENTERCELL);
        trainerTableAssign.getColumnModel().
        getColumn(2).setCellRenderer(CENTERCELL);
        trainerTableAssign.getColumnModel().
        getColumn(3).setCellRenderer(CENTERCELL);
        trainerTableAssign.getColumnModel().
        getColumn(4).setCellRenderer(CENTERCELL);
        trainerTableAssign.getColumnModel().
        getColumn(5).setCellRenderer(CENTERCELL);
        trainerTableAssign.getColumnModel().
        getColumn(6).setCellRenderer(CENTERCELL);
        //add trainer table to the panel
        JScrollPane trainerAssignSP = new JScrollPane(trainerTableAssign);
        JLabel trainerLabel = new JLabel("List of Available Trainer");
        trainerLabel.setHorizontalAlignment(JLabel.CENTER);
        trainerLabel.setFont(calibri15);
        trainerLabel.setForeground(Color.WHITE);
        trainerTablePanel.add(trainerLabel, BorderLayout.NORTH);
        trainerTablePanel.add(trainerAssignSP, BorderLayout.CENTER);

        //reshow the course table
        JPanel courseTablePanel = new JPanel(new BorderLayout());
        courseTablePanel.setBackground(new Color(222, 41, 13));
        courseTableAssign = new JTable(courseTM);
        courseTableAssign.
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //align table to center
        courseTableAssign.getColumnModel().
        getColumn(0).setCellRenderer(CENTERCELL);
        courseTableAssign.getColumnModel().
        getColumn(1).setCellRenderer(CENTERCELL);
        courseTableAssign.getColumnModel().
        getColumn(2).setCellRenderer(CENTERCELL);
        courseTableAssign.getColumnModel().
        getColumn(3).setCellRenderer(CENTERCELL);
        courseTableAssign.getColumnModel().
        getColumn(4).setCellRenderer(CENTERCELL);
        courseTableAssign.getColumnModel().
        getColumn(5).setCellRenderer(CENTERCELL);
        //add course table to the panel
        JScrollPane courseAssignSP = new JScrollPane(courseTableAssign);
        JLabel courseLabel = new JLabel("List of Available Course");
        courseLabel.setHorizontalAlignment(JLabel.CENTER);
        courseLabel.setFont(calibri15);
        courseLabel.setForeground(Color.WHITE);
        courseTablePanel.add(courseLabel, BorderLayout.NORTH);
        courseTablePanel.add(courseAssignSP, BorderLayout.CENTER);

        //add trainer and course table to table panel
        tabelPanel.add(courseTablePanel);
        tabelPanel.add(trainerTablePanel);
        //add all panel to the main panel
        display.add(assignPanel);
        display.add(tabelPanel);

        //add action listener to the item
        AssignHandler assignHandler = new AssignHandler(this);
        searchCourse.addActionListener(assignHandler);
    }

    //method to access the agency in this JFrame
    public TrainingAgency getTrainingAgency() {
        return agency;
    }
    
    public void setTrainingAgency(TrainingAgency newAgency) {
        agency = newAgency;
        trainerTM.setTrainer(agency.getTrainerArray());
        trainerTable.setModel(trainerTM);
        courseTM.setCourse(agency.getCourseArray());
        courseTable.setModel(courseTM);
    }
    public TrainerTableModel getTrainerTableModel() {
        return trainerTM;
    }
    public CourseTableModel getCourseTableModel() {
        return courseTM;
    }
    //main method
    public static void main(String[] args)
    {
        JFrame frame = new TrainingAgencyGUI();
        frame.setVisible(true);
    }
}