 
 import java.io.FileInputStream;
 import java.io.FileNotFoundException;
 import java.io.IOException;
 import java.sql.*;
 import java.util.Properties;

import java.util.Scanner;
 public class OutParameter {

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
 			 st=cn.prepareCall("call raghu.fetching(?,?,?,?,?)");
 			 System.out.println("Enter id");
 			 st.setInt(1,t.nextInt());
 			 st.registerOutParameter(3,Types.VARCHAR);
 			st.registerOutParameter(4,Types.BIGINT);
 			st.registerOutParameter(2,Types.DECIMAL);
 			st.registerOutParameter(5,Types.VARCHAR);
 			st.executeQuery();
 			System.out.println(st.getString(3)+" "+st.getDouble(2)+" "+st.getLong(4)+" "+st.getString(5));
 			
 			
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

