 
 import java.io.FileInputStream;
 import java.io.FileNotFoundException;
 import java.io.IOException;
 import java.sql.*;
 import java.util.Properties;

import java.util.Scanner;
 public class InsertCallable {

 	public static void main(String[] args) {
 		     Connection cn=null;
 		     CallableStatement st=null;
 		     ResultSet rs=null;
 		     Scanner t=new Scanner(System.in);
 		    try {
 			FileInputStream ab=new FileInputStream("C:\\Users\\dell\\eclipse\\JDBC1\\src\\config.properties");
 			Properties p=new Properties();
 			p.load(ab);
 			Class.forName(p.getProperty("driver"));
 	         cn=DriverManager.getConnection(p.getProperty("url"));
 			 st=cn.prepareCall("call raghu.insertRecord(?,?,?,?,?)");
 			 System.out.println("Enter Id");
 			 st.setInt(1,t.nextInt());
 			 System.out.println("Enter Name");
 			 st.setString(2,t.next());
 			 System.out.println("Enter Marks");
 			 st.setDouble(3,t.nextDouble());
 			 System.out.println("Enter MobileNumber");
 			 st.setString(4,t.next());
 			 System.out.println("Enter Address");
 			 st.setString(5,t.next());
 			 st.executeUpdate();
 			 System.out.println("Data Inserted");
 			
 		} catch (IOException | ClassNotFoundException | SQLException e) {
 			
 			e.printStackTrace();
 		}
 		    finally
 		    
 		    {
 		    	try {
 		    	if(rs!=null)
 		    	{
 		    		rs.close();
 		    	}
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

