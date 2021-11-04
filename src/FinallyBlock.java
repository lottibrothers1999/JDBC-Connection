 
 import java.io.FileInputStream;
 import java.io.FileNotFoundException;
 import java.io.IOException;
 import java.sql.*;
 import java.util.Properties;
 public class FinallyBlock {

 	public static void main(String[] args) {
 		     Connection cn=null;
 		     Statement st=null;
 		     ResultSet rs=null;
 		    try {
 			FileInputStream ab=new FileInputStream("C:\\Users\\dell\\eclipse\\JDBC1\\src\\config.properties");
 			Properties p=new Properties();
 			p.load(ab);
 			Class.forName(p.getProperty("driver"));
 	         cn=DriverManager.getConnection(p.getProperty("url"));
 			 st=cn.createStatement();
 			String qu="select * from employe.student";
 			 rs=st.executeQuery(qu);
 			while(rs.next())
 			{
 				int id=rs.getInt(1);
 				String na=rs.getString(2);
 				Double sa=rs.getDouble(3);
 				System.out.println(id+" "+na+" "+sa);
 			}
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

