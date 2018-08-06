import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LibraryController
{
	private LibraryView libView;
	
	LibraryController(LibraryView libView)
	{
		this.libView = libView;
		this.libView.addButtonListener(new ButtonListener());
	}
	
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Connection myConn = null;
			Statement myStmt = null;
			ResultSet myRslt = null;
			
			//Borrower Variables
			String firstName = libView.getFirstName();
			String lastName = libView.getLastName();
			String brwrEmail = libView.getEmail();
			
			try 
			{
				myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/info5051_books?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=EST5EDT","root","password");
				
				myStmt = myConn.createStatement();
				
				
				//Library Content Buttons
				if(e.getSource().equals(libView.getBooksButton()))
				{
					String bookSlct = "SELECT Title FROM book";
					
					myRslt = myStmt.executeQuery(bookSlct);
					
					while(myRslt.next())
					{
						System.out.println(myRslt.getString("Title"));
					}
				}
				else if(e.getSource().equals(libView.getBorwButton()))
				{
					String borwSlct = "SELECT First_Name, Last_Name FROM Borrower";
					
					myRslt = myStmt.executeQuery(borwSlct);
					
					while(myRslt.next())
					{
						System.out.println(myRslt.getString("First_Name") + " " + myRslt.getString("Last_Name"));
					}
				}
				else if(e.getSource().equals(libView.getLoanButton()))
				{
					//TO-DO
				}
				else if(e.getSource().equals(libView.addBrwrButton()))
				{
					String createBrwr = "INSERT INTO Borrower (Last_Name, First_Name, Borrower_email) "
										+ "VALUES('"+lastName+"', '"+firstName+"', '"+brwrEmail+"')";
					
					myStmt.executeUpdate(createBrwr);
				}
			}
			catch(SQLException ex)
			{
				System.out.println("SQLException caught, message is: " + ex.getMessage());
				ex.printStackTrace();
			}
			catch(Exception ex)
			{
				System.out.println("Some Exception caught, message is: " + ex.getMessage());
			}
			finally 
			{
					try
						{
						if(myRslt != null)
						{
							myRslt.close();
						}
						
						if(myStmt != null)
						{
							myStmt.close();
						}
						
						if(myConn != null)
						{
							myConn.close();
						}
						}//end try
			catch (Exception ex)
			{
				System.out.println(ex.getMessage());
			}
		}
	}
}
	
}
