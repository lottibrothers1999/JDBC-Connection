import java.sql.*;
import java.sql.SQLException;
import java.sql.Connection;

public class  FetchingData{

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Registration Completed");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=abcd&useSSL=false");
			System.out.println("Connection Established SuccessFully");
			Statement st=cn.createStatement();
			System.out.println("statement is created");
			String qu="select * from employe.student";
			ResultSet rs=st.executeQuery(qu);
			while(rs.next())
			{
				int id=rs.getInt(1);
				String na=rs.getString(2);
				Double sa=rs.getDouble(3);
				System.out.println(id+" "+na+" "+sa);
			}
			
		
			
			
		} 
		catch (ClassNotFoundException | SQLException e) {
	
			e.printStackTrace();
		}

	}

}
