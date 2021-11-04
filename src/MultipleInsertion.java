import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class MultipleInsertion {

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
	 			 int repeat=0;
	 			 do {
	 			 System.out.println("Enter Id,Name and Salary");
	 			 int id=t.nextInt();
	 			 String na=t.next();
	 			 double sal=t.nextDouble();
	 			 String qu="insert into employe.student values("+id+",'"+na+"',"+sal+")";
	 			 System.out.println(st.executeUpdate(qu));
	 			 System.out.println("Data Inserted");
	 			 System.out.println("Press 1 to insert one more record....Press any number to exit");
	 			 repeat=t.nextInt();
	 			 }
	 			 while(repeat==1);
	 			 
	 			 
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
