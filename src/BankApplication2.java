import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class BankApplication2{

	public static void main(String[] args) {
		Scanner t=new Scanner(System.in);
		 Statement st=null;
		 Connection cn=null;
		 ResultSet rs=null;
		
		 try {
			 FileInputStream ab=new FileInputStream("C:\\Users\\dell\\eclipse\\JDBC1\\src\\config.properties");
	 			Properties p=new Properties();
	 			p.load(ab);
	 			Class.forName(p.getProperty("driver"));
	 	         cn=DriverManager.getConnection(p.getProperty("url"));
	 	         System.out.println("Connection Established SuccessFully");
	 			 st=cn.createStatement();
	 			 System.out.println("Enter Username");
	 			 String user=t.next();
	 			 System.out.println("Enter Password");
	 			 String pass=t.next();
	 			 String qu="select balance from bank.customer where username='"+user+"' and password='"+pass+"'";
	 			 System.out.println("Our query is: "+qu);
	 			 rs=st.executeQuery(qu);
	 			 if(rs.next())
	 			 {
	 				 System.out.println("Balance is : "+rs.getDouble(1));
	 			 }
	 			 else
	 			 {
	 				 System.out.println("Invalid Details");
	 			 }
	 			 
	 			 
	 			 
	 		} catch (ClassNotFoundException | SQLException | IOException e) {
	 			
	 			e.printStackTrace();
	 		}
		 finally
		 {
			 try
			 {
				 t.close();
				 if(st!=null)
				 {
					 st.close();
				 }
				 if(cn!=null)
				 {
					 cn.close();
				 }
			 }
			 catch(SQLException e)
			 {
				 System.out.println("Sql Exception Handled");
			 }
		 }

	}

}
