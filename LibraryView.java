import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class LibraryView extends JFrame
{
	//Components
	JTextField fNameTxt, lNameTxt, emailTxt;
	JButton listBkBtn, listLnBtn, listBrwBtn, addBrwrBtn;
	
	public LibraryView()
	{
		super("Professor Mohan's Personal Library");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		
		//Tabbed Pane
		JTabbedPane libraryPane = new JTabbedPane();
		
		this.add(libraryPane);
		//Panels
		JPanel userPanel = new JPanel();
		JPanel bookPanel = new JPanel();
		JPanel librPanel = new JPanel();
		JPanel lBtnPanel = new JPanel();
		JPanel addUPanel = new JPanel();
		JPanel usrBPanel = new JPanel();
		
		//Panel Labels
		JLabel userLbl = new JLabel();
		JLabel bookLbl = new JLabel();
		JLabel librLbl = new JLabel();
		
		//Set Panel Labels
		userLbl.setText("Borrower Maintenance Panel");
		bookLbl.setText("Book Maintenance Panel");
		librLbl.setText("Library Content");
		
		//Add Panel Labels
		userPanel.add(userLbl);
		bookPanel.add(bookLbl);
		librPanel.add(librLbl);
		
		//Panel Layouts
		librPanel.setLayout(new FlowLayout());
		lBtnPanel.setLayout(new FlowLayout());
		addUPanel.setLayout(new GridLayout(3,2,2,2));
		usrBPanel.setLayout(new FlowLayout());
		
		//Panel Backgrounds 
		
		//User Maintenance Panel Components
		fNameTxt = new JTextField();
		lNameTxt = new JTextField();
		emailTxt = new JTextField();
		
		JLabel fNameLbl = new JLabel("First Name: ");
		JLabel lNameLbl = new JLabel("Last Name: ");
		JLabel emailLbl = new JLabel("Email: ");
		
		addUPanel.add(fNameLbl);
		addUPanel.add(fNameTxt);
		addUPanel.add(lNameLbl);
		addUPanel.add(lNameTxt);
		addUPanel.add(emailLbl);
		addUPanel.add(emailTxt);
		
		userPanel.add(addUPanel, BorderLayout.NORTH);
		
		addBrwrBtn = new JButton("Add User");
		
		usrBPanel.add(addBrwrBtn);
		
		userPanel.add(usrBPanel, BorderLayout.SOUTH);
		
		
		//Library Content Panel Components
		listBkBtn = new JButton("List Books");
		listLnBtn = new JButton("List Loans");
		listBrwBtn = new JButton("List Borrowers");
		
		lBtnPanel.add(listBkBtn);
		lBtnPanel.add(listLnBtn);
		lBtnPanel.add(listBrwBtn);
		
		librPanel.add(lBtnPanel, BorderLayout.CENTER);
		
		//Add Tabs
		libraryPane.addTab("Borrowers", userPanel);
		libraryPane.addTab("Books", bookPanel);
		libraryPane.addTab("Contents", librPanel);
		
		this.setVisible(true);
	}
	
	public void addButtonListener(ActionListener a)
	{
		listBkBtn.addActionListener(a);
		listLnBtn.addActionListener(a);
		listBrwBtn.addActionListener(a);
		addBrwrBtn.addActionListener(a);
	}
	
	//Fields Getters
	public String getFirstName()
	{
		return fNameTxt.getText();
	}
	public String getLastName()
	{
		return lNameTxt.getText();
	}
	public String getEmail()
	{
		return emailTxt.getText();
	}
	
	
	//Button Getters
	public JButton getBooksButton()
	{
		return listBkBtn;
	}
	public JButton getLoanButton()
	{
		return listLnBtn;
	}
	public JButton getBorwButton()
	{
		return listBrwBtn;
	}
	public JButton addBrwrButton()
	{
		return addBrwrBtn;
	}
	
}








