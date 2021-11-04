import java.io.FileInputStream;
import java.io.FileNotFoundException;
 import java.io.IOException;
 import java.sql.*;
 import java.util.Properties;
import java.util.Scanner;
public class InsertByPrepared {

	public static void main(String[] args) {
		Scanner t=new Scanner(System.in);
		 PreparedStatement st=null;
		 Connection cn=null;
		 ResultSet rs=null;
		
		 try {
			 FileInputStream ab=new FileInputStream("C:\\Users\\dell\\eclipse\\JDBC1\\src\\config.properties");
	 			Properties p=new Properties();
	 			p.load(ab);
	 			Class.forName(p.getProperty("driver"));
	 	         cn=DriverManager.getConnection(p.getProperty("url"));
	 	         System.out.println("Connection Established SuccessFully");
	 			 System.out.println("Enter Id,Name and Salary");
	 			 int id=t.nextInt();
	 			 String na=t.next();
	 			 double sal=t.nextDouble();
	 			 String qu="insert into employe.student values("+id+",'"+na+"',"+sal+")";
	 			 st=cn.prepareStatement(qu);
	 			 st.executeUpdate();
	 			 System.out.println("Data Inserted");
	 			 
	 			 
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
