import java.io.FileInputStream;
 import java.io.FileNotFoundException;
 import java.io.IOException;
 import java.sql.*;
import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;

public class DataBaseMetaData {

	public static void main(String[] args) {
	  Scanner t=new Scanner(System.in);
	  Connection cn=null;
	 DatabaseMetaData dm=null;
	  try
	  {
		  FileInputStream ab=new FileInputStream("C:\\Users\\dell\\eclipse\\JDBC1\\src\\config.properties");
			Properties p=new Properties();
			p.load(ab);
			Class.forName(p.getProperty("driver"));
	         cn=DriverManager.getConnection(p.getProperty("url"));
	         dm=cn.getMetaData();
	         System.out.println("Data Base Information");
	         System.out.println("Database Name:"+dm.getDatabaseProductName());
	         System.out.println("Database Version:major - "+dm.getDatabaseMajorVersion()+"minor: "+dm.getDriverMinorVersion());
	         System.out.println("URL for Database:"+dm.getURL());
	         System.out.println("Driver Name :"+dm.getDriverName());
	         System.out.println("Driver Version:major - "+dm.getDriverMajorVersion()+"minor - "+dm.getDriverMinorVersion());
	  }
	  catch(SQLException | IOException | ClassNotFoundException e)
		 {
			 System.out.println("Sql Exception Handled 1");
		 }
	 
				 
			
	  
	  
	  

	}

}
