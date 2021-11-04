 
 import java.io.FileInputStream;
 import java.io.FileNotFoundException;
 import java.io.IOException;
 import java.sql.*;
 import java.util.Properties;
 public class StoredProcedureExample {

 	public static void main(String[] args) {
 		     Connection cn=null;
 		     CallableStatement st=null;
 		     ResultSet rs=null;
 		    try {
 			FileInputStream ab=new FileInputStream("C:\\Users\\dell\\eclipse\\JDBC1\\src\\config.properties");
 			Properties p=new Properties();
 			p.load(ab);
 			Class.forName(p.getProperty("driver"));
 	         cn=DriverManager.getConnection(p.getProperty("url"));
 			 st=cn.prepareCall("call employe.selectAll()");
 			 rs=st.executeQuery();
 			while(rs.next())
 			{
 				System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getDouble("salary"));
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

