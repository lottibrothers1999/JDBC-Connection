import java.io.FileInputStream;
import java.io.FileNotFoundException;
 import java.io.IOException;
 import java.sql.*;
 import java.util.Properties;
import java.util.Scanner;
public class PreparedStatement2 {

	public static void main(String[] args) {
		Scanner t=new Scanner(System.in);
		 PreparedStatement pst=null;
		 Connection cn=null;
		 ResultSet rs=null;
		
		 try {
			 FileInputStream ab=new FileInputStream("C:\\Users\\dell\\eclipse\\JDBC1\\src\\config.properties");
	 			Properties p=new Properties();
	 			p.load(ab);
	 			Class.forName(p.getProperty("driver"));
	 	         cn=DriverManager.getConnection(p.getProperty("url"));
	 	         System.out.println("Connection Established SuccessFully");
	 	        String qu="insert into employe.student values(?,?,?)";
	 	        pst=cn.prepareStatement(qu);
	 			 System.out.println("Enter Id,Name and Salary");
	 			 int id=t.nextInt();
	 			 String na=t.next();
	 			 double sal=t.nextDouble();
	 			 pst.setInt(1, id);
	 			 pst.setString(2,na);
	 			 pst.setDouble(3,sal);
	 			
	 			 
	 			 pst.executeUpdate();
	 			 System.out.println("Data Inserted");
	 			 
	 			 
	 		} catch (ClassNotFoundException | SQLException | IOException e) {
	 			
	 			e.printStackTrace();
	 		}
		 finally
		 {
			 try
			 {
				 t.close();
				 if(pst!=null)
				 {
					 pst.close();
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
