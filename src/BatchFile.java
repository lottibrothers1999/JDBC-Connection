import java.io.FileInputStream;
 import java.io.FileNotFoundException;
 import java.io.IOException;
 import java.sql.*;
import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;

public class BatchFile {

	public static void main(String[] args) {
	  Scanner t=new Scanner(System.in);
	  Connection cn=null;
	  PreparedStatement pst=null;
	  try
	  {
		  FileInputStream ab=new FileInputStream("C:\\Users\\dell\\eclipse\\JDBC1\\src\\config.properties");
			Properties p=new Properties();
			p.load(ab);
			Class.forName(p.getProperty("driver"));
	         cn=DriverManager.getConnection(p.getProperty("url"));
	         String qu="insert into employe.student values(?,?,?)";
	         pst=cn.prepareStatement(qu);
	         int r=0;
	         do {
	        	 System.out.println("Enter id,name,salary");
	        	 int id=t.nextInt();
	        	 String na=t.next();
	        	 double sal=t.nextDouble();
	        	 pst.setInt(1, id);
	        	 pst.setString(2, na);
	        	 pst.setDouble(3, sal);
	        	 pst.addBatch();
	        	 System.out.println("Data Inserted");
	        	 System.out.println("Press 1 for more record");
	        	 r=t.nextInt();
	        	}
	         while(r==1);
	         int arr[]=pst.executeBatch();
	         System.out.println(Arrays.toString(arr));
	         
	  }
	  catch(SQLException | IOException | ClassNotFoundException e)
		 {
			 System.out.println("Sql Exception Handled 1");
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
